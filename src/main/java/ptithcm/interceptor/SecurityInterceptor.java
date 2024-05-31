package ptithcm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ptithcm.dao.AccountDao;
import ptithcm.entity.Account;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("Session user: " + session.getAttribute("user"));
		Account user = (Account) session.getAttribute("user");
		if (user != null) {
			 Account account = accountDao.findAccountByEmail(user.getEmail());
			 if (account != null) {
				 request.setAttribute("user", account);
			 }
		}
		return true;
	}
}
