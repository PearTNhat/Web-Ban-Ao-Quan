package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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

import ptithcm.bean.ProductBean;
import ptithcm.bean.ProductDetailBean;
import ptithcm.dao.ColorDao;
import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductDetailDao;
import ptithcm.dao.ProductImageDao;
import ptithcm.dao.SizeDao;
import ptithcm.dao.TypeDetailDao;
import ptithcm.entity.Size;
import ptithcm.entity.TypeDetail;
import ptithcm.utils.UploadImage;
import ptithcm.entity.Color;
import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;
import ptithcm.entity.ProductImage;

@Controller
@RequestMapping("/admin")
public class AdminProductsController {
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
	private TypeDetailDao typeDetailDao;
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

	// product

	@RequestMapping(value = "/products/add-product", method = RequestMethod.GET)
	public String productForm(Model model) {
		List<TypeDetail> typesDetail = typeDetailDao.getAllTypeDetail();
		model.addAttribute("tsd", typesDetail);
		model.addAttribute("p", new ProductBean());
		return "page/admin/handleProduct";
	}

	@RequestMapping(value = "/products/add-product", method = RequestMethod.POST)
	public String addProduct(RedirectAttributes redirectAttributes, ModelMap model,

			@Validated @ModelAttribute("p") ProductBean p, BindingResult errors) {
		List<TypeDetail> typesDetail = typeDetailDao.getAllTypeDetail();
		try {
			model.addAttribute("nameErr", errors.hasFieldErrors("name"));
			model.addAttribute("priceErr", errors.hasFieldErrors("price"));
			model.addAttribute("discountErr", errors.hasFieldErrors("discount"));
			model.addAttribute("descriptionErr", errors.hasFieldErrors("description"));
			if (errors.hasErrors()) {
				model.addAttribute("tsd", typesDetail);
				model.addAttribute("p", p);
				return "page/admin/handleProduct";
			}
			Product newP = new Product();
			newP.setName(p.getName());
			newP.setPrice(p.getPrice());
			newP.setDiscount(p.getDiscount());
			newP.setTypeDetailId(p.getTypeDetailId());
			newP.setDescription(p.getDescription());
			Boolean res = productDao.addProduct(newP);
			if (!res) {
				model.addAttribute("tsd", typesDetail);
				model.addAttribute("p", p);
				model.addAttribute("error", "Sản phẩm đã tồn tại");
				return "page/admin/handleProduct";
			}
			redirectAttributes.addFlashAttribute("success", "Thêm sản phẩm thành công");
			return "redirect:/admin/products.htm";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("tsd", typesDetail);
			model.addAttribute("p", p);
			model.addAttribute("error", "Xảy ra lỗi khi thêm sản phẩm");
			return "page/admin/handleProduct";
		}
	}

	// edit-product
	@RequestMapping(value = "/products/edit-product/{productId}", method = RequestMethod.GET)
	public String productEditForm(Model model, @PathVariable String productId) {
		List<TypeDetail> typesDetail = typeDetailDao.getAllTypeDetail();
		Product currP = productDao.findProductById(productId);
		ProductBean p = new ProductBean();
		p.setName(currP.getName());
		p.setPrice(currP.getPrice());
		p.setDescription(currP.getDescription());
		p.setTypeDetailId(currP.getTypeDetailId());
		p.setDiscount(currP.getDiscount());

		model.addAttribute("tsd", typesDetail);
		model.addAttribute("p", p);
		model.addAttribute("productId", productId);
		model.addAttribute("event", "update");
		return "page/admin/handleProduct";
	}

	@RequestMapping(value = "/products/edit-product/{productId}", method = RequestMethod.POST)
	public String editProduct(RedirectAttributes redirectAttributes, Model model, @PathVariable Integer productId,
			@Validated @ModelAttribute("p") ProductBean p, BindingResult errors) {
		try {
			Product newP = new Product();
			newP.setProductId(productId);
			newP.setName(p.getName());
			newP.setPrice(p.getPrice());
			newP.setDiscount(p.getDiscount());
			newP.setTypeDetailId(p.getTypeDetailId());
			newP.setDescription(p.getDescription());

			Boolean res = productDao.updateProduct(newP);
			if (!res) {
				List<TypeDetail> typesDetail = typeDetailDao.getAllTypeDetail();
				model.addAttribute("tsd", typesDetail);
				model.addAttribute("p", p);
				model.addAttribute("error", "Cập nhật thất bại");
				return "page/admin/handleProduct";
			}
			redirectAttributes.addFlashAttribute("success", "Cập nhật sản phẩm thành công");
			return "redirect:/admin/products.htm";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Xảy ra lỗi khi sửa đổi sản phẩm");
			return "redirect:/admin/products/edit-product/" + productId + ".htm";
		}
	}

	// prodcut detail
	@RequestMapping(value = "/products/add-product-detail/{productId}", method = RequestMethod.GET)
	public String productDetailForm(@PathVariable Integer productId, Model model) {
//		pd : product detail
		List<Color> colors = colorDao.getAllColors();
		List<Size> sizes = sizeDao.getAllSizes();
		model.addAttribute("colors", colors);
		model.addAttribute("sizes", sizes);
		model.addAttribute("pd", new ProductDetailBean());
		model.addAttribute("productId", Integer.toString(productId));
		return "page/admin/handleProductDetail";
	}

	@RequestMapping(value = "/products/add-product-detail/{productId}", method = RequestMethod.POST)
	public String addProductDetail(@PathVariable Integer productId, ModelMap model,
			RedirectAttributes redirectAttributes, @Validated @ModelAttribute("pd") ProductDetailBean pd,
			BindingResult errors) {
		try {
			// get error
			System.out.println("size " + pd.getTemplImg().size());
			model.addAttribute("colorErr", errors.hasFieldErrors("color"));
			model.addAttribute("quantityErr", errors.hasFieldErrors("quantity"));
			if (errors.hasErrors()) {
				List<Color> colors = colorDao.getAllColors();
				List<Size> sizes = sizeDao.getAllSizes();
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("tempImage", pd.getTemplImg());
				model.addAttribute("productId", Integer.toString(productId));
				return "page/admin/handleProductDetail";
			}
			List<MultipartFile> files = pd.getFiles();
			if (files.get(0).isEmpty()) {
				List<Color> colors = colorDao.getAllColors();
				List<Size> sizes = sizeDao.getAllSizes();
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("productId", Integer.toString(productId));
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
			pd.setColorId(color.getColorId());
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
				model.addAttribute("productId", Integer.toString(productId));
				model.addAttribute("error", "Sản phẩm đã tồn tại");
				return "page/admin/handleProductDetail";
			}
			// thêm ảnh
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				if (!file.isEmpty()) {
					String url = UploadImage.addToProduct(file, i);
					ProductImage pi = new ProductImage(url, pdId, i);
					if (!productImage.addProductImage(pi)) {
						redirectAttributes.addFlashAttribute("error", "Thêm ảnh thất bại");
						return "redirect:/admin/products/add-product-detail/" + productId + ".htm";
					}
				}
			}
			redirectAttributes.addFlashAttribute("success", "Thêm chi tiết sản phẩm thành công");
			return "redirect:/admin/products.htm";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Xảy ra lỗi khi thêm chi tiết sản phẩm");
			return "redirect:/admin/products/add-product-detail/" + productId + ".htm";
		}

	}

	@RequestMapping(value = "/products/edit-product-detail/{id}", method = RequestMethod.GET)
	public String editProductDetailForm(@PathVariable Integer id, ModelMap model) {
		List<Color> colors = colorDao.getAllColors();

		List<Size> sizes = sizeDao.getAllSizes();

		List<ProductImage> pi = productImage.findImageByPD(id);
		List<String> url = new ArrayList<String>();
		if (pi != null) {
			for (int i = 0; i < pi.size(); i++) {
				url.add(pi.get(i).getImage());
			}
		}
		removeProductImage("https://res.cloudinary.com/dqf9nmozd/image/upload/v1717755060/WebAoQuan/Products/ao-polo-to-ong-phoi-bo-det-kieu-form-slimfit-po124_small-184541717755061193.jpg");
		ProductDetail currP = productDetailDao.findProductDetailById(id);
		ProductDetailBean pd = new ProductDetailBean();
		pd.setProductId(currP.getProductId());
		pd.setQuantity(currP.getQuantity());
		pd.setColor(currP.getColor().getName());
		pd.setSizeId(currP.getSizeId());
		pd.setTemplImg(url);
		model.addAttribute("colors", colors);
		model.addAttribute("sizes", sizes);
		model.addAttribute("pd", pd);
		model.addAttribute("pdId", Integer.toString(id));
		model.addAttribute("productName", currP.getProduct().getName());
		model.addAttribute("productId", Integer.toString(currP.getProduct().getProductId()));
		model.addAttribute("event", "update");
		return "page/admin/handleProductDetail";
	}

	@RequestMapping(value = "/products/edit-product-detail/{pdId}", method = RequestMethod.POST)
	public String editProductDetail(@PathVariable Integer pdId, ModelMap model, RedirectAttributes redirectAttributes,
			@Validated @ModelAttribute("pd") ProductDetailBean pd, BindingResult errors) {
		try {
			List<MultipartFile> files = pd.getFiles();
			model.addAttribute("colorErr", errors.hasFieldErrors("color"));
			model.addAttribute("quantityErr", errors.hasFieldErrors("quantity"));
			ProductDetail currP = productDetailDao.findProductDetailById(pdId);
			String productId = Integer.toString(currP.getProduct().getProductId());

			ProductDetail newPd = new ProductDetail();
			// Tim color
			Color color = colorDao.getColorByName(pd.getColor());
			if (color == null) {
				// K có thì thêm color
				color = new Color(pd.getColor());
				pd.setColorId(colorDao.insertColor(color));
			}
			pd.setColorId(color.getColorId());
			newPd.setProductId(Integer.valueOf(productId));
			newPd.setColorId(pd.getColorId());
			newPd.setQuantity(pd.getQuantity());
			newPd.setSizeId(pd.getSizeId());
			newPd.setProductDetailId(pdId);
			Boolean upPd = productDetailDao.updateProductDetail(newPd);

			List<ProductImage> pi = productImage.findImageByPD(pdId);
			List<String> imgToDelete = new ArrayList<String>();
			if (pi != null) {
				for (int i = 0; i < pi.size(); i++) {
					String img = pi.get(i).getImage();
					if (!pd.getTemplImg().contains(img)) {
						imgToDelete.add(img);
					}

				}
			}
			Boolean isFileEmpty = true;
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					isFileEmpty = false;
				}
			}
			Boolean errImg = imgToDelete.size() == pi.size() && isFileEmpty;
			if (upPd == false || errImg) {
				List<Color> colors = colorDao.getAllColors();
				List<Size> sizes = sizeDao.getAllSizes();
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("pdId", Integer.toString(pdId));
				model.addAttribute("productId", productId);
				model.addAttribute("event", "update");
				if (errImg) {
					model.addAttribute("error", "Ảnh không được rỗng");
				} else {
					model.addAttribute("error", "Sản phẩm đã tồn tại");
				}
				return "page/admin/handleProductDetail";
			}

			// xoa những ảnh đã bị xoá bỏ trong giao diện
			for (String s : imgToDelete) {
				productImage.deleteImage(s);
				removeProductImage(s);
			}
			ProductImage lastImage = productImage.getLastProductImageByProductDetailId(pdId);

			// uploadImage
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				Integer index = lastImage.getPriority() + i + 1;
				if (!file.isEmpty()) {
					System.out.println("zo");
					String url = this.addToProduct(file, index);
					ProductImage newPi = new ProductImage(url, pdId, index);
					if (!productImage.addProductImage(newPi)) {
						redirectAttributes.addFlashAttribute("error", "Thêm ảnh thất bại");
						return "page/admin/handleProductDetail";
					}
				}
			}

			redirectAttributes.addFlashAttribute("success", "Thêm chi tiết sản phẩm thành công");
			return "redirect:/admin/products.htm";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("event", "update");
			model.addAttribute("error", "Xảy ra lỗi chưa xác định khi chỉnh sửa sản phẩm");
			return "page/admin/handleProductDetail";
		}
	}

	public String addToProduct(MultipartFile file, Integer index) {
		try {
			long currentTimeMillis = System.currentTimeMillis() + index;
			String fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
			Map<String, String> m = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type",
					"auto", "folder", "WebAoQuan/Products", "public_id", fileName + currentTimeMillis));
			String url = (String) m.get("secure_url");
			return url;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Boolean removeProductImage(String name) {
		try {
			// Extract public ID
			String publicId = extractPublicId(name);
			System.out.println("publicId "+publicId);
			cloudinary.uploader().destroy("WebAoQuan/Products/" + publicId, ObjectUtils.emptyMap());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static String extractPublicId(String url) {
		// Remove the base URL
		String baseUrl = "https://res.cloudinary.com/dqf9nmozd/image/upload/";
		String withoutBaseUrl = url.replace(baseUrl, "");

		// Remove the version number and the file extension
		int lastSlashIndex = withoutBaseUrl.lastIndexOf('/');
		int dotIndex = withoutBaseUrl.lastIndexOf('.');
		if (lastSlashIndex >= 0 && dotIndex > lastSlashIndex) {
			return withoutBaseUrl.substring(lastSlashIndex + 1, dotIndex);
		} else {
			return withoutBaseUrl;
		}
	}

}