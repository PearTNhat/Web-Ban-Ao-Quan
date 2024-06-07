package ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashBoardController {

	@RequestMapping("/")
	public String dashBoard() {
		return "page/admin/dashBoard";
	}
}
