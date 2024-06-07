package ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminDashBoardController {

	@RequestMapping("/admin")
	public String dashBoard() {
		return "page/admin/dashBoard";
	}
}
