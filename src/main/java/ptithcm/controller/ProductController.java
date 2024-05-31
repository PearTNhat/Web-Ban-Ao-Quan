package ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ProductController {
	
	@RequestMapping("/product")
	public String getProduct() {
		return "listProduct";
	}
	
}
