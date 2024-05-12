package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptithcm.entity.Account;
import ptithcm.entity.Product;

@Transactional
@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	SessionFactory factory;

	// product
	@RequestMapping("products")
	public String getAllProucts(ModelMap model) {

		Session session = factory.getCurrentSession();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		model.addAttribute("products", list);

		return "page/admin/manageProducts";
	}

	// account
	@RequestMapping("accounts")
	public String getAllAccounts(ModelMap model, HttpServletRequest request) {
		String search =request.getParameter("search") == null ? "":request.getParameter("search") ;
		int page =request.getParameter("page")== null ? 1 :Integer.parseInt(request.getParameter("page"));
		int limit =2;
		Session session = factory.getCurrentSession();
		//total pages
		String hqlTotal = "SELECT count(firstName) FROM Account a WHERE LOWER(REPLACE(CONCAT(firstName, ' ', lastName), ' ', '')) LIKE LOWER(REPLACE('%'+:search+'%', ' ', ''))";
		Query queryTotal = session.createQuery(hqlTotal); 
		queryTotal.setParameter("search", search);
		Long total = (Long) queryTotal.uniqueResult();
		int pages =(int) Math.ceil((float)total/limit);
		int skip = (page - 1 ) * limit;
		// lấy ra kết quả cuối cùng sau khi tính toán phân trang
		String hql = "FROM Account a WHERE LOWER(REPLACE(CONCAT(firstName, ' ', lastName), ' ', '')) LIKE LOWER(REPLACE('%'+:search+'%', ' ', ''))";
		Query query = session.createQuery(hql);
		query.setFirstResult(skip); 
		query.setMaxResults(limit); // Fetch the next 5 rows after skipping
		query.setParameter("search", search);
		//
	
		List<Account> list = query.list();
		model.addAttribute("accounts", list);
		model.addAttribute("pages",pages);
		model.addAttribute("page",page);
		return "page/admin/account";
	}

	@RequestMapping(value = "delete/{accountId}", params = "btnDelete")
	public String deletAccount(RedirectAttributes redirectAttributes, @PathVariable("accountId") String accountId) {
		System.out.println(accountId);
		Integer result = this.deleteAccountById(this.getAccountById(accountId));
		if (result == 1) {
			redirectAttributes.addFlashAttribute("message", "Xoá tài khoản thành công");
		} else {
			redirectAttributes.addFlashAttribute("message", "Xoá tài khoản thất bại");
		}
		return "redirect:/admin/accounts.htm";

	}

	public Integer deleteAccountById(Account account) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(account);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error delete " + e.getMessage());
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Account getAccountById(String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Account where accountId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Account list = (Account) query.list().get(0);
		return list;
	}
}
