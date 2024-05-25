package ptithcm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
//https://localhost:8080/DemoSpingMVC/
	@RequestMapping("/")
	public String index(ModelMap model) {
		return "page/home";	
	}
	
	public String dashBoard() {
		return "page/admin/dashBoard";
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
