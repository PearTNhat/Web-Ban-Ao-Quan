package ptithcm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ptithcm.entity.Account;

public class ProfileInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("user");
		System.out.println("account profile: " + acc);
		if (acc == null) {
			response.sendRedirect(request.getContextPath() + "/.htm");
			return false;
		}

		return true;
	}
}
