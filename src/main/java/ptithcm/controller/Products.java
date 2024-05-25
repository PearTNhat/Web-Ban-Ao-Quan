package ptithcm.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Products {

	@Autowired
	SessionFactory factory;
	
	@RequestMapping("products")
	public String getProduct() {
		return "listProduct";
	}
	
}
