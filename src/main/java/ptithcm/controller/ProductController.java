package ptithcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.dao.ProductDao;
import ptithcm.entity.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;

	@RequestMapping("/products/{typeId}")
	public String getProduct(@PathVariable("typeId") String typeId, ModelMap model) {
//		pst : products type
		List<Product> listProduct = productDao.getProductByType(typeId);
		model.addAttribute("pst", listProduct);

		return "page/listProduct";
	}

}
