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

import ptithcm.dao.AccountDao;
import ptithcm.dao.impl.AccountDaoImpl;
import ptithcm.entity.Account;
import ptithcm.entity.Product;

@Transactional
@Controller
@RequestMapping("/admin/")
public class AdminAccountsController {

	@Autowired
	SessionFactory factory;
	@Autowired
	private AccountDao accountDao;
	private int page;
	private int sizeItems;
	private String search;
	// account
	@RequestMapping("accounts")
	public String getAllAccounts(ModelMap model, HttpServletRequest request) {
		int limit = 2;
		search =request.getParameter("search") == null ? "":request.getParameter("search") ;
		page =request.getParameter("page")== null ? 1 :Integer.parseInt(request.getParameter("page"));
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
		sizeItems = list.size();
		model.addAttribute("accounts", list);
		model.addAttribute("pages",pages);
		model.addAttribute("page",page);
		model.addAttribute("limit",limit);
		return "page/admin/account";
	}

	@RequestMapping(value = "accounts/{accountId}", params = "btnDelete")
	public String deletAccount(RedirectAttributes redirectAttributes, @PathVariable("accountId") Integer accountId) {
		System.out.println( accountId);
		// tính năng xoá xong vẫn ở trang hiện tại
		Integer result = accountDao.deleteAccount(accountDao.getAccountById(accountId));
		if (result == 1) {
			redirectAttributes.addFlashAttribute("message", "Xoá tài khoản thành công");
			if (page > 1 && sizeItems == 1) {
				page = page - 1;
			}

		} else {
			redirectAttributes.addFlashAttribute("message", "Xoá tài khoản thất bại");
		}
		return "redirect:/admin/accounts.htm?page=" + page + "&search=" + search;

	}

}
