package ptithcm.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductImageDao;
import ptithcm.entity.ProductImage;
import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;

@Controller
@RequestMapping("/admin")
public class AdminProductsController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImageDao productImage;
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
		model.addAttribute("pd", new ProductDetail());
		model.addAttribute("productId", productId);
		return "page/admin/handleProductDetail";
	}

	@RequestMapping(value = "/products/add-product/{productId}", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("pd") ProductDetail pd, @PathVariable Integer productId, ModelMap model,
			RedirectAttributes redirectAttributes) {
		try {
			List<MultipartFile> files = pd.getFiles();
			Boolean res = productDao.addProductDetail(pd);
			if (!res) {
				model.addAttribute("error", "Thêm hàng thất bại");
				return "page/admin/handleProductDetail";
			}
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				if (!file.isEmpty()) {
					long currentTimeMillis = System.currentTimeMillis() + i;
					String fileName = file.getOriginalFilename().substring(0,
							file.getOriginalFilename().lastIndexOf('.'));

					Map<String, String> m = cloudinary.uploader().upload(file.getBytes(),
							ObjectUtils.asMap("resource_type", "auto", "folder", "WebAoQuan/Products", "public_id",
									fileName + currentTimeMillis));
					String url = (String) m.get("secure_url");
					ProductImage pi = new ProductImage(url, pd.getCompositeKey().getProductId(), i);
					if (!productImage.addProductImage(pi)) {
						model.addAttribute("error", "Thêm ảnh thất bại");
						return "page/admin/handleProductDetail";
					}
				}
			}
			redirectAttributes.addFlashAttribute("success", "Thêm chi tiết hàng thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Xảy ra lỗi khi thêm chi tiết sản phẩm");
			e.printStackTrace();
		}
		return "redirect:/admin/products.htm";

	}

}