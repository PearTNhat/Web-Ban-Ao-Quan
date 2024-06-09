package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductTypeDao;
import ptithcm.entity.Account;
import ptithcm.entity.Product;
import ptithcm.entity.ProductType;

@Controller
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
		List<Product> hotProductt = productDao.getBestSaleProduct();
		List<Product> newProduct = productDao.getNewProduct();
		model.addAttribute("pts", productTypes);
		model.addAttribute("hotProduct",hotProductt);
		model.addAttribute("newProduct",newProduct);
		return "page/home";
	}

	@RequestMapping("/admin-account")
	public String accountAdmin() {
		return "page/admin/adminAccount";
	}

	@RequestMapping("/listProduct")
	public String Footer() {
		return "page/listProduct";
	}

	@RequestMapping("/forgot-password")
	public String forgotPassword() {
		return "page/forgotPassword/sentMail";
	}

	@RequestMapping("/cart-checkout")
	public String cartCheckout(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/cart-checkout";
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
