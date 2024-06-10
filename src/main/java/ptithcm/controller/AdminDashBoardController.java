package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.dao.AccountDao;
import ptithcm.dao.ProductDao;
import ptithcm.entity.Account;
import ptithcm.entity.Product;

@Controller
@RequestMapping("/admin")
public class AdminDashBoardController {
	@Autowired
	SessionFactory factory;

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ProductDao productDao;

	private int page;
	private int sizeItems;
	private String search;

	@RequestMapping("/dashboard")
	public String dashBoard(ModelMap model, HttpServletRequest request) {
		List<Account> list = accountDao.findNonAdminAccounts();
		System.out.println(list.size());
		model.addAttribute("quantity_user", list.size());
		List<Product> listProduct = productDao.getAllProducts();
		int totalMoney = 0;
		int totalBought = 0;
		for (int i = 0; i < listProduct.size(); i++) {
			totalMoney += listProduct.get(i).getSoldQuantity()*listProduct.get(i).getPrice();
			totalBought += listProduct.get(i).getSoldQuantity();
		}
		model.addAttribute("totalBought", totalBought);
		model.addAttribute("totalMoney", totalMoney);
		return "page/admin/dashBoard";
	}
}
