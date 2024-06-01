package ptithcm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ptithcm.dao.AccountDao;
import ptithcm.dao.ProductTypeDao;
import ptithcm.entity.Account;
import ptithcm.entity.ProductType;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ProductTypeDao productTypeDao;
	
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
		
		// Add product type list to session
		List<ProductType> listProductType = productTypeDao.getAllProductType();
		session.setAttribute("listProductType", listProductType);
		return true;
	}
}
