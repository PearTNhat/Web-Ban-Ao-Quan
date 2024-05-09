package ptithcm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.entity.Account;


@Controller
public class Index {

	@RequestMapping("/")
	public String index(ModelMap model) {
		return "page/home";	
	}
<<<<<<< HEAD
	@RequestMapping("/dashboard")
=======
	@RequestMapping("/order")
	public String dashBoard1() {
		return "page/order";
	}
	@RequestMapping("/dash-board")
>>>>>>> 9b92fac908d6cf34cd60e34f35142d1127e92e09
	public String dashBoard() {
		return "page/admin/dashBoard";
	}
	@RequestMapping("/admin-account")
	public String accountAdmin  () {
		return "page/admin/adminAccount";
	}
	@RequestMapping("/manage-product")
	public String manageProduct  () {
		return "page/admin/manageProducts";
	}
	@RequestMapping("/handle-product")
	public String handleProduct  () {
		return "page/admin/handleProduct";
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

}
