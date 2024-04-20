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

@Transactional
@Controller
public class Index {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("/")
	public String index(ModelMap model) {
		List<Account> list = getListAccounts();
		model.addAttribute("accounts", list);
		String serverName = "PHUONG-HPLAP";
//		String serverName = "NHAT-PC\\SERVER01";
        String portNumber = "1433";
        String databaseName = "QLSV";
        String username = "sa";
        String password = "kc";
//        String password = "12";
        String connectionUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";" + "databaseName="
                + databaseName + ";username=" + username + ";password=" + password + ";";

        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	Connection con = DriverManager.getConnection(connectionUrl);
        	model.addAttribute("connStatus", "Connected to database!");
        } catch (SQLException | ClassNotFoundException e) {
			model.addAttribute("connStatus", "Cannot connect to SQL Server =((");
			e.printStackTrace();
		}
		return "page/home";	
	}
	@RequestMapping("/handleProduct")
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
	
	public List<Account> getListAccounts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Account";
		Query query = session.createQuery(hql);
		List<Account> list = query.list();
		return list;
	}
}
