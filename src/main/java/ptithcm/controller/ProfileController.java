package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.bean.AddressBean;
import ptithcm.dao.AddressDao;
import ptithcm.entity.Account;
import ptithcm.entity.Address;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private AddressDao addressDao;
	
	@RequestMapping("/info")
	public String userInfo(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "page/profile/info";
	}
	//session
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
	
	@RequestMapping(value="/address/edit/{addressId}", method=RequestMethod.POST)
	public String editAddress(@PathVariable("addressId") Integer addressId, AddressBean addressForm, ModelMap model, HttpServletRequest request) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			Address address = new Address(addressId, addressForm.getAddressName(), addressForm.getRecipientName(), addressForm.getPhoneNumber(), user); 
			if (addressDao.editAddress(address) ) {
				List<Address> userAddress = addressDao.getAllAddress(user.getAccountId());
				model.addAttribute("user", user);
				model.addAttribute("userAddress", userAddress);
				return "page/profile/address";
			}			
		}
		model.addAttribute("editError", true);
		return "page/profile/address";
	}
	
	@RequestMapping(value="/address/add-address")
	public String addAddress(AddressBean addressForm, ModelMap model, HttpServletRequest request) {
		Account user = (Account) request.getAttribute("user");
		if (user != null) {
			Address address = new Address(addressForm.getAddressName(), addressForm.getRecipientName(), addressForm.getPhoneNumber(), user);
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
	public String deleteAddress(@PathVariable("addressId") Integer addressId, ModelMap model, HttpServletRequest request) {
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
