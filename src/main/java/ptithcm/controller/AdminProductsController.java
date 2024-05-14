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
public class AdminProductsController {

	@Autowired
	SessionFactory factory;
	private int page;
	private int sizeItems;
	private String search;
	@RequestMapping("products")
	public String getAllAccounts(ModelMap model, HttpServletRequest request) {
		int limit = 10;
		search =request.getParameter("search") == null ? "":request.getParameter("search") ;
		page =request.getParameter("page")== null ? 1 :Integer.parseInt(request.getParameter("page"));
		Session session = factory.getCurrentSession();
		//total pages
		String hqlTotal = "SELECT count(name) FROM Product a WHERE LOWER(REPLACE(name, ' ', '')) LIKE LOWER(REPLACE('%'+:search+'%', ' ', ''))";
		Query queryTotal = session.createQuery(hqlTotal); 
		queryTotal.setParameter("search", search);
		Long total = (Long) queryTotal.uniqueResult();
		 int pages =(int) Math.ceil((float)total/limit);
		int skip = (page - 1 ) * limit;
		// lấy ra kết quả cuối cùng sau khi tính toán phân trang
		String hql = "FROM Product WHERE LOWER(REPLACE(name, ' ', '')) LIKE LOWER(REPLACE('%'+:search+'%', ' ', ''))";
		Query query = session.createQuery(hql);
		query.setFirstResult(skip); 
		query.setMaxResults(limit); // Fetch the next 5 rows after skipping
		query.setParameter("search", search);
		//
		List<Product> list = query.list();
		sizeItems = list.size();
		model.addAttribute("products", list);
		model.addAttribute("pages",pages);
		model.addAttribute("page",page);
		model.addAttribute("limit",limit);
		return "page/admin/products";
	}

	@RequestMapping(value = "delete/{productId}", params = "btnDelete")
	public String deletProductId(RedirectAttributes redirectAttributes, @PathVariable("productId") Integer productId) {
		// tính năng xoá xong vẫn ở trang hiện tại
		Integer result = this.deleteProduct(productId);
		if (result == 1) {
			redirectAttributes.addFlashAttribute("message", "Xoá sản phẩm thành công");
			if (page > 1 && sizeItems == 1) {
				page = page - 1;
			}

		} else {
			redirectAttributes.addFlashAttribute("message", "Xoá sản phẩm thất bại");
		}
		return "redirect:/admin/products.htm?page=" + page + "&search=" + search;

	}
	public Integer deleteProduct(Integer productId) {
	    Session session = factory.openSession();
	    Transaction t = session.beginTransaction();

	    try {
	  
	        Product product = (Product) session.get(Product.class, productId);
	        if (product != null) {
	           session.delete(product);
	        }
	        t.commit();
	    } catch (Exception e) {
	        t.rollback();
	        System.out.println("Error deleting products: " + e.getMessage());
	        return 0;
	    } finally {
	        session.close();
	    }
	    return 1;
	}

/*	public Product getProductById(String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product where productId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("productId", id);
		Product list = (Product) query.list().get(0);
		return list;
	*/
}
