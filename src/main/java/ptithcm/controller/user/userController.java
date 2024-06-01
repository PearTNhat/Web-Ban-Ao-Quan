package ptithcm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.Base64;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import ptithcm.bean.Image;
import ptithcm.bean.LoginBean;
import ptithcm.bean.UserBean;
import ptithcm.dao.AccountDao;
import ptithcm.dao.AddressDao;
import ptithcm.entity.Account;
import ptithcm.entity.Address;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private Cloudinary cloudinary;
	
	public Cookie readCookies(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					String decodedvalue = new String(Base64.getDecoder().decode(cookie.getValue()));
					cookie.setValue(decodedvalue);
					return cookie;
				}
			}
		}
		return null;
	}

	public Cookie createCookies(String name, String value, int days) {
		String encodedValue = Base64.getEncoder().encodeToString(value.getBytes());
		Cookie cookie = new Cookie(name, encodedValue);
		cookie.setMaxAge(days * 24 * 60 * 60);
		cookie.setPath("/");
		return cookie;

	}
	
	public void deleteCookies(String name) {
		this.createCookies(name, "", 0);
	}
	
	@RequestMapping("/login")
	public String loginForm(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		LoginBean newLogin = new LoginBean();
		Cookie cookieEmail = this.readCookies(request, "email");
		Cookie cookiePass = this.readCookies(request, "pass");
		
		if (cookieEmail != null) {
			newLogin.setEmail(cookieEmail.getValue());
			newLogin.setPassword(cookiePass.getValue());
		}
		model.addAttribute("user", newLogin);
		return "page/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(ModelMap model, @Validated @ModelAttribute("user") LoginBean user, BindingResult errors,
						RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response,
						HttpServletRequest request) {
		System.out.println(user);

		// has validation error
		if (errors.hasErrors()) {
			model.addAttribute("user", user);
			return "page/login";
		}
		
		Account loginUser = accountDao.findAccountByEmail(user.getEmail());
		
		if (loginUser != null && BCrypt.checkpw(user.getPassword(), loginUser.getPassword())) {
			// remember account using cookies
			if (user.getRememberMe()) {
				Cookie ckemail = this.createCookies("email", user.getEmail(), 30);
				Cookie ckpass = this.createCookies("pass", user.getPassword(), 30);

				response.addCookie(ckemail);
				response.addCookie(ckpass);

			} else {
				this.deleteCookies("email");
				this.deleteCookies("pass");
			}
			
			System.out.println("login successfully");
			
			// set user to Session
			session.setAttribute("user", loginUser);
			return "redirect:/.htm";
		}
		
		model.addAttribute("user", user);
		model.addAttribute("loginError", true);
		return "page/login";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String signupForm(ModelMap model) {
		UserBean user = new UserBean();
		model.addAttribute("user", user);
		model.addAttribute("submit", false);
		return "page/signup";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
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
			return "page/signup";
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
		
		if (isError) return "page/signup";
		
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
				return "page/signup";
			}
		}
		
		Account account = new Account(user.getFirstName(), 
									  user.getLastName(), 
									  false,
									  user.getEmail(),
									  BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()),
									  imageUrl);
		
		Account createdAccount = accountDao.createAccount(account);
		if (createdAccount != null) {
			if (user.getAddress() != null && !user.getAddress().trim().isEmpty()) {
				Address address = new Address(user.getAddress(), createdAccount.getFirstName() + ' ' + createdAccount.getLastName(), null, createdAccount);
				if (!addressDao.addAddress(createdAccount.getAccountId(), address)) {
					System.out.println("Error adding new address");
					return "page/signup";
				}
			}
			System.out.println("succesfully created account");
			session.setAttribute("user", createdAccount);
			redirectAttributes.addFlashAttribute("successMessage", "Account created successfully!");
			return "redirect:/.htm";
		}
		return "page/singup";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
        return "redirect:/user/login.htm";
	}
}
