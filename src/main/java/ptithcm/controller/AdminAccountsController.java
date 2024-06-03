package ptithcm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import ptithcm.bean.Image;
import ptithcm.bean.UserBean;
import ptithcm.dao.AccountDao;
import ptithcm.dao.AddressDao;
import ptithcm.dao.impl.AccountDaoImpl;
import ptithcm.entity.Account;
import ptithcm.entity.Address;
import ptithcm.entity.Product;

@Transactional
@Controller
@RequestMapping("/admin/accounts")
public class AdminAccountsController {

	@Autowired
	SessionFactory factory;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private Cloudinary cloudinary;
	
	private int page;
	private int sizeItems;
	private String search;
	// account
	@RequestMapping("")
	public String getAllAccounts(ModelMap model, HttpServletRequest request) {
		int limit = 4;
		search =request.getParameter("search") == null ? "":request.getParameter("search") ;
		page =request.getParameter("page")== null ? 1 :Integer.parseInt(request.getParameter("page"));
		Session session = factory.getCurrentSession();
		//total pages
		String hqlTotal = "SELECT count(firstName) FROM Account a WHERE LOWER(REPLACE(CONCAT(firstName, ' ', lastName), ' ', '')) LIKE LOWER(REPLACE('%'+:search+'%', ' ', ''))";
		Query queryTotal = session.createQuery(hqlTotal); 
		queryTotal.setParameter("search", search);
		Long total = (Long) queryTotal.uniqueResult();
		 int pages =(int) Math.ceil((float)total/limit);
		int skip = (page - 1 ) * limit;
		// lấy ra kết quả cuối cùng sau khi tính toán phân trang
		String hql = "FROM Account a WHERE LOWER(REPLACE(CONCAT(firstName, ' ', lastName), ' ', '')) LIKE LOWER(REPLACE('%'+:search+'%', ' ', ''))";
		Query query = session.createQuery(hql);
		query.setFirstResult(skip); 
		query.setMaxResults(limit); // Fetch the next 5 rows after skipping
		query.setParameter("search", search);
		//
		List<Account> list = query.list();
		sizeItems = list.size();
		model.addAttribute("accounts", list);
		model.addAttribute("pages",pages);
		model.addAttribute("page",page);
		model.addAttribute("limit",limit);
		return "page/admin/account";
	}

	@RequestMapping(value = "/{accountId}", params = "btnDelete")
	public String deletAccount(RedirectAttributes redirectAttributes, @PathVariable("accountId") Integer accountId) {
		System.out.println( accountId);
		Integer result = accountDao.deleteAccount(accountDao.getAccountById(accountId));
		if (result == 1) {
			redirectAttributes.addFlashAttribute("message", "Xoá tài khoản thành công");
			if (page > 1 && sizeItems == 1) {
				page = page - 1;
			}

		} else {
			redirectAttributes.addFlashAttribute("message", "Xoá tài khoản thất bại");
		}
		return "redirect:/admin/accounts.htm?page=" + page + "&search=" + search;
	}
	
	@RequestMapping("/admin-register")
	public String register(ModelMap model) {
		UserBean user = new UserBean();
		model.addAttribute("user", user);
		model.addAttribute("submit", false);
		return "page/admin/admin-register";
	}
	
	@RequestMapping(value="/admin-register", method=RequestMethod.POST)
	public String signup(ModelMap model, @Validated @ModelAttribute("user") UserBean user, BindingResult errors, RedirectAttributes redirectAttributes, HttpSession session) {
		// Remove redundant spaces
		user.setFirstName(user.getFirstName().trim().replaceAll("\\s+", " "));
        user.setLastName(user.getLastName().trim().replaceAll("\\s+", " "));
		
		System.out.println(user);
		
		// Check for error boolean
		model.addAttribute("submit", true);
		model.addAttribute("firstNameErr", errors.hasFieldErrors("firstName"));
		model.addAttribute("lastNameErr", errors.hasFieldErrors("lastName"));
		model.addAttribute("addressErr", errors.hasFieldErrors("address"));
		model.addAttribute("emailErr", errors.hasFieldErrors("email"));
		model.addAttribute("passwordErr", errors.hasFieldErrors("password"));
		model.addAttribute("confirmPasswordErr", errors.hasFieldErrors("confirmPassword"));
		
		// has validation error
		if (errors.hasErrors()) {
			model.addAttribute("user", user);
			return "page/admin/admin-register";
		}
		
		// check for [password not match] and [email already exist]
		boolean isError = false;
		
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			isError = true;
			model.addAttribute("user", user);
			model.addAttribute("passwordNotMatch", true);		
		}

		if (accountDao.findAccountByEmail(user.getEmail()) != null) {
			isError = true;
			model.addAttribute("user", user);
			model.addAttribute("accountError", true);
		}
		
		if (isError) return "page/admin/admin-register";
		
		String imageUrl = null;
		// continue to process if image field is not empty
		if (!user.getAvatar().isEmpty()) {
			Image image = new Image();
			image.setFile(user.getAvatar());
			
			try {
				@SuppressWarnings("unchecked")
				Map<String, String> m = cloudinary.uploader().upload(image.getFile().getBytes(),
						ObjectUtils.asMap("resource_type", "auto", "folder", "WebAoQuan/Products","public_id", image.getFile().getOriginalFilename()));
				imageUrl = (String) m.get("secure_url");
			} catch (Exception e) {
				System.out.println("Error upload image " + e.getMessage());
			}
			
			if (imageUrl == null) {
				model.addAttribute("user", user);
				model.addAttribute("imageError", true);
				return "page/admin/admin-register";
			}
		}
		
		Account account = new Account(user.getFirstName(), 
									  user.getLastName(), 
									  true,
									  user.getEmail(),
									  BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()),
									  imageUrl);
		
		Account createdAccount = accountDao.createAccount(account);
		if (createdAccount != null) {
			if (user.getAddress() != null && !user.getAddress().trim().isEmpty()) {
				Address address = new Address(user.getAddress(), createdAccount.getFirstName() + ' ' + createdAccount.getLastName(), null, createdAccount);
				if (!addressDao.addAddress(createdAccount.getAccountId(), address)) {
					System.out.println("Error adding new address");
					return "page/admin/admin-register";
				}
			}
			System.out.println("succesfully created account");
			session.setAttribute("user", createdAccount);
			redirectAttributes.addFlashAttribute("successMessage", "Account created successfully!");
			return "redirect:/admin/dashboard.htm";
		}
		return "page/admin/admin-register";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
        return "redirect:/user/login.htm";
	}
}
