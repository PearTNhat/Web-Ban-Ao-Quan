package ptithcm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

import ptithcm.bean.Image;
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
	
	@RequestMapping("/login")
	public String login() {
		return "page/login";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String singup(ModelMap model) {
		UserBean user = new UserBean();
		model.addAttribute("user", user);
		model.addAttribute("submit", false);
		return "page/signup";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String signup(ModelMap model, @Validated @ModelAttribute("user") UserBean user, BindingResult errors, RedirectAttributes redirectAttributes) {
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
			if (user.getAddress() != null) {
				Address address = new Address(user.getAddress(), createdAccount.getFirstName() + ' ' + createdAccount.getLastName(), null, createdAccount);
				if (!addressDao.addAddress(createdAccount.getAccountId(), address)) {
					System.out.println("Error adding new address");
					return "page/signup";
				}
			}
			System.out.println("succesfully created account");
			redirectAttributes.addFlashAttribute("successMessage", "Account created successfully!");
			return "redirect:/.htm";
		}
		return "page/singup";
	}
}
