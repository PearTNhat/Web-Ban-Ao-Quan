package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.entity.Product;

@Transactional
@Controller
@RequestMapping("/admin")
public class Admin {

	@Autowired
	SessionFactory factory;

	@RequestMapping("manage-product")
	public String getAllProuct(ModelMap model) {

		Session session = factory.getCurrentSession();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		model.addAttribute("products", list);
		System.out.println(list);

		return "page/admin/manageProducts";
	}
}
