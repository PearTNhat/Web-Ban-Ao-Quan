package ptithcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.dao.ProductDao;
import ptithcm.entity.Product;

@Controller
<<<<<<< HEAD
@RequestMapping("/admin")
=======
@RequestMapping("/admin/products/")
>>>>>>> 5f22a41db42750422c1c1ac2a21a5ae94437b308
public class AdminProductsController {
	
	@Autowired
<<<<<<< HEAD
	private ProductDao productDao;
	
	@RequestMapping("/products")
	public String getProducts(
		@RequestParam(value="page", defaultValue="1", required=false) Integer page,
		@RequestParam(value="search", defaultValue="", required=false) String search,
		ModelMap model
	) {
		Integer recordPerPage = 2;
		List<Product> products = productDao.getProducts(page, recordPerPage, search);
		Long totalProduct = productDao.countProducts(search);
		Integer totalPage = (int) Math.ceil((float)totalProduct / recordPerPage);
		model.addAttribute("products", products);
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("totalPage", totalPage);
		
=======
	SessionFactory factory;
	private int page;
	private int sizeItems;
	private String search;
	@RequestMapping("")
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
>>>>>>> 5f22a41db42750422c1c1ac2a21a5ae94437b308
		return "page/admin/products";
	}
	
<<<<<<< HEAD
	@RequestMapping("/handle-product")
	public String productForm() {
=======
	@RequestMapping("handle-product")
	public String handleProduct() {
>>>>>>> 5f22a41db42750422c1c1ac2a21a5ae94437b308
		return "page/admin/handleProduct";
	}
}
