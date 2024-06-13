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
import ptithcm.entity.ProductColor;
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
		Integer recordPerPage = 5;
		List<Product> products = productDao.getProducts(page, recordPerPage, search);
		Long totalProduct = productDao.countProducts(search);
		Integer totalPage = (int) Math.ceil((float) totalProduct / recordPerPage);
		model.addAttribute("products", products);
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("totalPage", totalPage);
		return "page/admin/products";
	}

	@RequestMapping("products/{productId}")
	public String getProductDetail(@PathVariable Integer productId, ModelMap model,
			@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(value = "search", defaultValue = "", required = false) String search) {
		Integer recordPerPage = 5;
		List<ProductDetail> productDetails = productDetailDao.getProductDetails(productId, page, recordPerPage);
		Long totalProductDetail = (long) productDetails.size();
		Integer totalPage = (int) Math.ceil((float) totalProductDetail / recordPerPage);
		model.addAttribute("productDetails", productDetails);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return "page/admin/productDetail";
	}

	@RequestMapping(value="/products/delete/{productId}")
	public String deleteProduct(RedirectAttributes redirectAttributes, @PathVariable Integer productId, ModelMap model) {
		Product deleteProduct = productDao.findProductById(productId);
		if (deleteProduct.getProductDetail() != null) {
			redirectAttributes.addFlashAttribute("cannotDelete", true);
		}
		
		if (productDao.deleteProduct(deleteProduct)) {
			redirectAttributes.addFlashAttribute("deleteSuccess", true);
		} else {
			redirectAttributes.addFlashAttribute("deleteError", true);
		}
		return "redirect:/admin/products.htm";
	}

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
			newP.setSoldQuantity(0);
			newP.setPrice(p.getPrice());
			newP.setDiscount(p.getDiscount());
			newP.setTypeDetailId(p.getTypeDetailId());
			newP.setDescription(p.getDescription());
			newP.setSoldQuantity(0);
			Boolean res = productDao.addProduct(newP);

			if (!res) {

				model.addAttribute("tsd", typesDetail);
				model.addAttribute("p", p);
				model.addAttribute("error", "Sản phẩm đã tồn tại");
				return "page/admin/handleProduct";
			}
			redirectAttributes.addFlashAttribute("success", "Thêm sản phẩm thành công");
			return "redirect:/admin/products/add-product.htm";
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
	public String productEditForm(Model model, @PathVariable Integer productId) {
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
		model.addAttribute("productId", Integer.toString(productId));
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
		List<Color> colors = colorDao.getAllColors();
		List<Size> sizes = sizeDao.getAllSizes();
		Product product = productDao.findProductById(productId);
		model.addAttribute("colors", colors);
		model.addAttribute("sizes", sizes);
		model.addAttribute("pd", new ProductDetailBean());
		model.addAttribute("productId", Integer.toString(productId));
		model.addAttribute("productName", product.getName());
		return "page/admin/handleProductDetail";
	}

	@RequestMapping(value = "/products/add-product-detail/{productId}", method = RequestMethod.POST)
	public String addProductDetail(@PathVariable Integer productId, ModelMap model,
			RedirectAttributes redirectAttributes, @Validated @ModelAttribute("pd") ProductDetailBean pd,
			BindingResult errors) {
		List<Color> colors = colorDao.getAllColors();
		List<Size> sizes = sizeDao.getAllSizes();
		Product product = productDao.findProductById(productId);
		try {
			model.addAttribute("colorErr", errors.hasFieldErrors("color"));
			model.addAttribute("quantityErr", errors.hasFieldErrors("quantity"));
			if (errors.hasFieldErrors("color") || errors.hasFieldErrors("quantity")) {
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("tempImage", pd.getTemplImg());
				model.addAttribute("productId", Integer.toString(productId));
				model.addAttribute("productName", product.getName());
				return "page/admin/handleProductDetail";
			}
			System.out.println("2");
			List<MultipartFile> files = pd.getFiles();
			System.out.println("zo");
			ProductColor newPC = new ProductColor();
			// Tim color
			Color color = colorDao.getColorByName(pd.getColor());
			if (color == null) {
				// K có thì thêm color
				color = new Color(pd.getColor());
				pd.setColorId(colorDao.insertColor(color));
			}
			System.out.println("3");
			pd.setColorId(color.getColorId());
			newPC.setProductId(productId);
			newPC.setColorId(pd.getColorId());

			ProductDetail newPd = new ProductDetail();

			newPd.setQuantity(pd.getQuantity());
			newPd.setSizeId(pd.getSizeId());
			Integer pcId = productDetailDao.findProductColor(productId, pd.getColorId());
			if (pcId == null) {
				pcId = productDetailDao.addProductColor(newPC);
			}
			newPd.setProductColorId(pcId);
			Integer res = productDetailDao.addProductDetail(newPd);
			if (res == -1) {
				System.out.println("zo -----");
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("productId", Integer.toString(productId));
				model.addAttribute("error", "Size đã tồn tại");
				model.addAttribute("productName", product.getName());
				return "page/admin/handleProductDetail";
			}
			// thêm ảnh
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				if (!file.isEmpty()) {
					String url = this.addToProduct(file, i);
					ProductImage pi = new ProductImage(url, pcId, i);
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

	@RequestMapping(value = "/products/edit-product-detail/{pcId}", method = RequestMethod.GET)
	public String editProductDetailForm(@PathVariable Integer pcId, ModelMap model) {
		List<Color> colors = colorDao.getAllColors();

		List<Size> sizes = sizeDao.getAllSizes();

		List<ProductImage> pi = productImage.findImageByPC(pcId);

		List<String> url = new ArrayList<String>();
		if (pi != null) {
			for (int i = 0; i < pi.size(); i++) {
				url.add(pi.get(i).getImage());
			}
		}
		ProductColor currPc = productDetailDao.findProductColorById(pcId);
		List<ProductDetail> currPd = productDetailDao.findProductDetailByPCId(currPc.getProductColorId());
		ProductDetailBean pd = new ProductDetailBean();
		pd.setProductId(currPc.getProductId());
		pd.setColor(currPc.getColor().getName());
		pd.setListPd(currPd);
		pd.setTemplImg(url);
		model.addAttribute("colors", colors);
		model.addAttribute("sizes", sizes);
		model.addAttribute("pd", pd);
		model.addAttribute("pdId", Integer.toString(pcId));

		model.addAttribute("productName", currPc.getProduct().getName());
		model.addAttribute("productId", Integer.toString(currPc.getProduct().getProductId()));

		model.addAttribute("event", "update");
		return "page/admin/handleProductDetail";
	}

	@RequestMapping(value = "/products/edit-product-detail/{pcId}", method = RequestMethod.POST)
	public String editProductDetail(@PathVariable Integer pcId, ModelMap model, RedirectAttributes redirectAttributes,
			@Validated @ModelAttribute("pd") ProductDetailBean pd, BindingResult errors) {
		List<Color> colors = colorDao.getAllColors();
		List<Size> sizes = sizeDao.getAllSizes();
		try {
			List<MultipartFile> files = pd.getFiles();
			model.addAttribute("colorErr", errors.hasFieldErrors("color"));
			model.addAttribute("quantityErr", errors.hasFieldErrors("quantity"));
			ProductColor currPc = productDetailDao.findProductColorById(pcId);
			String productId = Integer.toString(currPc.getProduct().getProductId());

			productDetailDao.updateProductDetail(pd.getListPd());

			List<ProductImage> pi = productImage.findImageByPC(pcId);
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
			if (errImg) {
				model.addAttribute("colors", colors);
				model.addAttribute("sizes", sizes);
				model.addAttribute("pd", pd);
				model.addAttribute("pdId", Integer.toString(pcId));
				model.addAttribute("productId", productId);
				model.addAttribute("productName", currPc.getProduct().getName());
				model.addAttribute("event", "update");

				model.addAttribute("error", "Ảnh không được rỗng");

				return "page/admin/handleProductDetail";
			}

			// xoa những ảnh đã bị xoá bỏ trong giao diện
			for (String s : imgToDelete) {
				productImage.deleteImage(s);
				removeProductImage(s);
			}
			ProductImage lastImage = productImage.getLastProductImageByProductDetailId(pcId);

			// uploadImage
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				Integer index = lastImage == null ? 0 :lastImage.getPriority() + i + 1;
				if (!file.isEmpty()) {
					String url = this.addToProduct(file, index);
					ProductImage newPi = new ProductImage(url, pcId, index);
					if (!productImage.addProductImage(newPi)) {
						redirectAttributes.addFlashAttribute("error", "Thêm ảnh thất bại");
						return "page/admin/handleProductDetail";
					}
				}
			}
			redirectAttributes.addFlashAttribute("success", "Thêm chi tiết sản phẩm thành công");
			return "redirect:/admin/products.htm";
		} catch (

		Exception e) {
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
		try { // Extract public ID
			String publicId = extractPublicId(name);
			System.out.println("publicId " + publicId);
			cloudinary.uploader().destroy("WebAoQuan/Products/" + publicId, ObjectUtils.emptyMap());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static String extractPublicId(String url) { // Remove the base URL
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
