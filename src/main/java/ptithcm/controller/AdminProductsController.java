package ptithcm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ptithcm.bean.Image;
import ptithcm.dao.ProductDao;
import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;

@Controller
@RequestMapping("/admin")
public class AdminProductsController {

	@Autowired
	private ProductDao productDao;

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

	@RequestMapping(value = "/products/add-product", method = RequestMethod.GET)
	public String productForm(Model model) {

		model.addAttribute("product-detail", new ProductDetail());
		return "page/admin/handleProductDetail";
	}

	@RequestMapping(value = "/products/add-product", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product-detail") ProductDetail pd,
			@RequestParam("files") List<MultipartFile> files) {

		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				System.out.println(file.getOriginalFilename());
			}
		}
		return "page/admin/handleProductDetail";

	}

}