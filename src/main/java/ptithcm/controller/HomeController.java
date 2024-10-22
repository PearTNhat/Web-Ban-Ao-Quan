package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductTypeDao;
import ptithcm.entity.Account;
import ptithcm.entity.Product;
import ptithcm.entity.ProductColor;
import ptithcm.entity.ProductType;

@Controller
@Transactional
public class HomeController {
//https://localhost:8080/DemoSpingMVC/

	@Autowired
	private ProductTypeDao productTypeDao;
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String index(ModelMap model, HttpServletRequest request) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		List<ProductType> productTypes = productTypeDao.getAllProductType();
		 List<Product> hotProduct = productDao.getBestSaleProduct(); 
		List<Product> newProduct = productDao.getNewProduct();
		model.addAttribute("pts", productTypes);
		model.addAttribute("hotProduct",hotProduct);
		model.addAttribute("newProduct",newProduct);
		model.addAttribute("userLogin", user);
		return "page/home";
	}

	@RequestMapping("/choose-size")
	public String chooseSize(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/topbar/chooseSize";
	}

	@RequestMapping("/for-vip-user")
	public String vipUser(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/topbar/vipUser";
	}

	@RequestMapping("/introduce")
	public String introduce(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/topbar/introduce";
	}

	@RequestMapping("/product/id")
	public String productDetail(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/product/product-detail";
	}
}
