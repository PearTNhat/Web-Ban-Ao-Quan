package ptithcm.controller;

import ptithcm.bean.User;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.bean.User;

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
}
