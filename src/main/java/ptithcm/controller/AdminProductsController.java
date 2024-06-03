package ptithcm.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import ptithcm.bean.ProductDetailBean;
import ptithcm.dao.ColorDao;
import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductDetailDao;
import ptithcm.dao.ProductImageDao;
import ptithcm.dao.SizeDao;

import ptithcm.entity.Size;
import ptithcm.entity.composite.ProductDetailId;
import ptithcm.entity.Color;
import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;
import ptithcm.entity.ProductImage;

@Controller
@RequestMapping("/admin")
public class AdminProductsController {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductDetailDao productDetailDao;
	@Autowired
	private ProductImageDao productImage;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private SizeDao sizeDao;
	@Autowired
	private Cloudinary cloudinary;

	@RequestMapping("/products")
	public String getProducts(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(value = "search", defaultValue = "", required = false) String search, ModelMap model) {
		Integer recordPerPage = 2;
		List<Product> products = productDao.getProducts(page, recordPerPage, search);
		Long totalProduct = productDao.countProducts(search);
		Integer totalPage = (int) Math.ceil((float) totalProduct / recordPerPage);
		model.addAttribute("products", products);
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("totalPage", totalPage);
		return "page/admin/products";
	}

	@RequestMapping(value = "/products/add-product/{productId}", method = RequestMethod.GET)
	public String productForm(@PathVariable Integer productId, Model model) {
//		pd : product detail
		List<Color> colors = colorDao.getAllColors();
		List<Size> sizes = sizeDao.getAllSizes();
		model.addAttribute("colors", colors);
		model.addAttribute("sizes", sizes);
		model.addAttribute("pd", new ProductDetailBean());
		model.addAttribute("productId", productId);
		return "page/admin/handleProductDetail";
	}

	@RequestMapping(value = "/products/add-product/{productId}", method = RequestMethod.POST)
	public String addProduct(@PathVariable Integer productId, ModelMap model, RedirectAttributes redirectAttributes,
			@Validated @ModelAttribute("pd") ProductDetailBean pd, BindingResult errors) {
		try {
			// get error
			model.addAttribute("colorErr", errors.hasFieldErrors("color"));
			model.addAttribute("quantityErr", errors.hasFieldErrors("quantity"));
			System.out.println(pd.getTemplImg().size());
			if (errors.hasErrors()) {
				List<Color> colors = colorDao.getAllColors();
				List<Size> sizes = sizeDao.getAllSizes();
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("productId", productId);
				return "page/admin/handleProductDetail";
			}
			List<MultipartFile> files = pd.getFiles();
			if (files.get(0).isEmpty()) {
				List<Color> colors = colorDao.getAllColors();
				List<Size> sizes = sizeDao.getAllSizes();
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("productId", productId);
				model.addAttribute("error", "Ảnh không được rỗng");
				return "page/admin/handleProductDetail";
			}
			ProductDetail newPd = new ProductDetail();
			// Tim color
			Color color = colorDao.getColorByName(pd.getColor());

			if (color == null) {
				// K có thì thêm color
				color = new Color(pd.getColor());
				pd.setColorId(colorDao.insertColor(color));
			}
			newPd.setProductId(productId);
			newPd.setColorId(pd.getColorId());
			newPd.setQuantity(pd.getQuantity());
			newPd.setSizeId(pd.getSizeId());
			Integer pdId = productDetailDao.addProductDetail(newPd);
			if (pdId == -1) {
				List<Color> colors = colorDao.getAllColors();
				List<Size> sizes = sizeDao.getAllSizes();
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("productId", productId);
				redirectAttributes.addFlashAttribute("error", "Sản phẩm đã tồn tại");
				return "redirect:/admin/products/add-product/" + productId + ".htm";
			}
			// thêm ảnh
			Integer piority = productImage.countImageById(pdId);
			if (piority == null) {
				piority = 1;
			}
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				if (!file.isEmpty()) {
					piority += i;
					long currentTimeMillis = System.currentTimeMillis() + i;
					String fileName = file.getOriginalFilename().substring(0,
							file.getOriginalFilename().lastIndexOf('.'));
					Map<String, String> m = cloudinary.uploader().upload(file.getBytes(),
							ObjectUtils.asMap("resource_type", "auto", "folder", "WebAoQuan/Products", "public_id",
									fileName + currentTimeMillis));

					String url = (String) m.get("secure_url");

					ProductImage pi = new ProductImage(url, pdId, piority);

					if (!productImage.addProductImage(pi)) {
						redirectAttributes.addFlashAttribute("error", "Thêm ảnh thất bại");
						return "redirect:/admin/products/add-product/" + productId + ".htm";
					}
				}
			}
			redirectAttributes.addFlashAttribute("success", "Thêm chi tiết hàng thành công");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Xảy ra lỗi khi thêm sản phẩm");
			return "redirect:/admin/products/add-product/" + productId + ".htm";
		} finally {

		}
		return "redirect:/admin/products.htm";

	}

}