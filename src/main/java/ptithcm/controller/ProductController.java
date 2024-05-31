package ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ProductController {
	
	@RequestMapping("/product/{type}")
	public String getProduct() {
		return "page/listProduct";
	}
	
}
