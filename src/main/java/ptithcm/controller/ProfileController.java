package ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@RequestMapping("/info")
	public String userInfo() {
		return "page/profile/info";
	}
	
	@RequestMapping("/order")
	public String profileOrder() {
		return "page/profile/order";
	}
	
	@RequestMapping("/address")
	public String profileAddress() {
		return "page/profile/address";
	}
}
