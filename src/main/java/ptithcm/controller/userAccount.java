package ptithcm.controller;

import ptithcm.bean.User;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.bean.User;

// Ctrl + shift + M -> import thư viện trên đầu file
@Controller
@RequestMapping("/profile/")
public class userAccount {
	@RequestMapping(value="info",method=RequestMethod.GET)
	public String showForm() {
		return "page/profile/info";
	}
	
	@RequestMapping(value = "info",method = RequestMethod.POST)
	public String updateData(HttpServletRequest request) {
		String firstname = request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		
		request.setAttribute("firstname", firstname);
		request.setAttribute("lastname", lastname);
		
		return "page/profile/info";
	}
	@RequestMapping("user")
	public String info(ModelMap model) {
		User user = new User("Duong", "Phi","phi@gmail.com","0123456789");
		model.addAttribute("user", user);;
		return "page/profile/info";
	}
}
