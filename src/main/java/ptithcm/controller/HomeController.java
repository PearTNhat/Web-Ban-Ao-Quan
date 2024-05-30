package ptithcm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductTypeDao;
import ptithcm.entity.ProductType;

@Controller
public class HomeController {
//https://localhost:8080/DemoSpingMVC/

	@Autowired
	private ProductTypeDao productTypeDao;
	
	@RequestMapping("/")
	public String index(ModelMap model) {
		
		  List<ProductType> productTypes= productTypeDao.getAllProductType();
		  model.addAttribute("pts", productTypes);
		 
		return "page/home";	
	}
	
	@RequestMapping("/admin-account")
	public String accountAdmin  () {
		return "page/admin/adminAccount";
	}

	@RequestMapping("/listProduct")
	public String Footer  () {
		return "page/listProduct";
	}
	@RequestMapping("/forgot-password")
	public String forgotPassword() {
		return "page/forgotPassword/sentMail";
	}
	
	@RequestMapping("/cart-checkout")
	public String cartCheckout() {
		return "page/cart-checkout";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "page/login";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "page/signup";
	}
	
	@RequestMapping("/choose-size") 
	public String chooseSize() {
		return "page/topbar/chooseSize";
	}
	
	@RequestMapping("/for-vip-user")
	public String vipUser() {
		return "page/topbar/vipUser";
	}
	
	@RequestMapping("/introduce")
	public String introduce() {
		return "page/topbar/introduce";
	}
	
	@RequestMapping("/product/id")
	public String productDetail() {
		return "page/product/product-detail";
	}
}
