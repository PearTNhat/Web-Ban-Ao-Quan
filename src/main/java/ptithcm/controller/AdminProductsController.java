package ptithcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.dao.ProductDao;
import ptithcm.entity.Product;

@Controller
@RequestMapping("/admin")
public class AdminProductsController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/products")
	public String getProducts(
		@RequestParam(value="page", defaultValue="1", required=false) Integer page,
		@RequestParam(value="search", defaultValue="", required=false) String search,
		ModelMap model
	) {
		Integer recordPerPage = 2;
		List<Product> products = productDao.getProducts(page, recordPerPage, search);
		Long totalProduct = productDao.countProducts(search);
		Integer totalPage = (int) Math.ceil((float)totalProduct / recordPerPage);
		model.addAttribute("products", products);
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("totalPage", totalPage);
		return "page/admin/products";
	}
	
	@RequestMapping("/handle-product")
	public String productForm() {
		return "page/admin/handleProduct";
	}
}
