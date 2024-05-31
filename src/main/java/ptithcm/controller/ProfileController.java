package ptithcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.entity.Account;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@RequestMapping("/info")
	public String userInfo(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/profile/info";
	}
	
	@RequestMapping("/order")
	public String profileOrder(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/profile/order";
	}
	
	@RequestMapping("/address")
	public String profileAddress(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/profile/address";
	}
}
