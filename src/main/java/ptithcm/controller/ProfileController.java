package ptithcm.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import ptithcm.bean.AddressBean;
import ptithcm.bean.Image;
import ptithcm.bean.User;
import ptithcm.dao.AccountDao;
import ptithcm.dao.AddressDao;
import ptithcm.dao.impl.AccountDaoImpl;
import ptithcm.entity.Account;
import ptithcm.entity.Address;
import ptithcm.utils.UploadImage;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private Cloudinary cloudinary;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private AccountDao accountDao;

	@RequestMapping("/info")
	public String userInfo(HttpServletRequest request, ModelMap model,BindingResult errors) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			System.out.println(user.getAvatar());
			model.addAttribute("user", user);
		}
		return "page/profile/info";
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String updateUser(RedirectAttributes redirectAttributes,@Validated @ModelAttribute("user") User formUser, BindingResult errors,
			HttpServletRequest request, ModelMap model) throws IOException {
		Account user = (Account) request.getAttribute("user");
		String imageUrl = null;
		model.addAttribute("fnameError", false);
		model.addAttribute("flastError", false);
		model.addAttribute("emailError", false);
		model.addAttribute("updateSuccess", false);
		if (user != null) {

			if (!formUser.getFile().isEmpty()) {
			
				try {
					@SuppressWarnings("unchecked")
					Map<String, String> m = cloudinary.uploader().upload(formUser.getFile().getBytes(),
							ObjectUtils.asMap("resource_type", "auto", "folder", "WebAoQuan/Users","public_id", formUser.getFile().getOriginalFilename()+user.getAccountId()));
					imageUrl = (String) m.get("secure_url");
				} catch (Exception e) {
					System.out.println("Error upload image " + e.getMessage());
				}
				
				System.out.println(imageUrl);
				/*
				 * if (imageUrl == null) { model.addAttribute("user", user);
				 * model.addAttribute("imageError", true); return "page/profile/info"; }
				 */
			}
			Account account = new Account(user.getAccountId(), formUser.getFirstName(), formUser.getLastName(),
					user.getIsAdmin(), formUser.getEmail(), user.getPassword(), user.getAvatar());
			if (errors.hasErrors()) {
				if (account.getFirstName() == "") {
					System.out.println("k vào");
					model.addAttribute("fnameError", true);
				}
				if (account.getLastName() == "") {
					model.addAttribute("flastError", true);
				}
				if (account.getEmail() == "") {
					model.addAttribute("emailError", true);
				}
				model.addAttribute("message", "");
				model.addAttribute("user", account);
				System.out.println("123");
				System.out.println(formUser.getFirstName());
				System.out.println(formUser.getLastName());
				System.out.println(formUser.getEmail());
				
				return "page/profile/info";
			}
			account.setAvatar(imageUrl);
			accountDao.updateAccount(account);
			model.addAttribute("user", account);
			model.addAttribute("updateSuccess", true);
		}

		System.out.println(formUser.getFirstName());
		System.out.println(formUser.getLastName());
		System.out.println(formUser.getEmail());
		model.addAttribute("success", "Thanh cong");
		return "page/profile/info";
	}

	// session
	@RequestMapping("/order")
	public String profileOrder(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/profile/order";
	}

	@RequestMapping("/address")
	public String profileAddress(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			List<Address> userAddress = addressDao.getAllAddress(user.getAccountId());
			model.addAttribute("user", user);
			model.addAttribute("userAddress", userAddress);
		}
		return "page/profile/address";
	}

	@RequestMapping(value = "/address/edit/{addressId}", method = RequestMethod.POST)
	public String editAddress(@PathVariable("addressId") Integer addressId, AddressBean addressForm, ModelMap model,
			HttpServletRequest request) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			Address address = new Address(addressId, addressForm.getAddressName(), addressForm.getRecipientName(),
					addressForm.getPhoneNumber(), user);
			if (addressDao.editAddress(address)) {
				List<Address> userAddress = addressDao.getAllAddress(user.getAccountId());
				model.addAttribute("user", user);
				model.addAttribute("userAddress", userAddress);
				return "page/profile/address";
			}
		}
		model.addAttribute("editError", true);
		return "page/profile/address";
	}

	@RequestMapping(value = "/address/add-address")
	public String addAddress(AddressBean addressForm, ModelMap model, HttpServletRequest request) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			Address address = new Address(addressForm.getAddressName(), addressForm.getRecipientName(),
					addressForm.getPhoneNumber(), user);
			if (addressDao.addAddress(user.getAccountId(), address)) {
				List<Address> userAddress = addressDao.getAllAddress(user.getAccountId());
				model.addAttribute("user", user);
				model.addAttribute("userAddress", userAddress);
				return "page/profile/address";
			}
		}
		model.addAttribute("addError", true);
		return "page/profile/address";
	}

	@RequestMapping("/address/delete/{addressId}")
	public String deleteAddress(@PathVariable("addressId") Integer addressId, ModelMap model,
			HttpServletRequest request) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			Address address = addressDao.getAddress(addressId);
			if (address != null && addressDao.deleteAddress(address)) {
				List<Address> userAddress = addressDao.getAllAddress(user.getAccountId());
				model.addAttribute("user", user);
				model.addAttribute("userAddress", userAddress);
				return "page/profile/address";
			}
		}
		model.addAttribute("deleteError", true);
		return "page/profile/address";
	}
}
