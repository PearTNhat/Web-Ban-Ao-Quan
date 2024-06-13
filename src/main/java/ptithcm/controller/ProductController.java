package ptithcm.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptithcm.bean.CartBean;
import ptithcm.bean.ProductBean;
import ptithcm.bean.ProductDetailBean;
import ptithcm.dao.AccountDao;
import ptithcm.dao.AddressDao;
import ptithcm.dao.CartDao;
import ptithcm.dao.OrderDao;
import ptithcm.dao.OrderDetailDao;
import ptithcm.dao.ProductDao;
import ptithcm.dao.ProductDetailDao;
import ptithcm.dao.TypeDetailDao;
import ptithcm.entity.Account;
import ptithcm.entity.Address;
import ptithcm.entity.CartDetail;
import ptithcm.entity.Order;
import ptithcm.entity.OrderDetail;
import ptithcm.entity.Product;
import ptithcm.entity.ProductColor;
import ptithcm.entity.ProductDetail;
import ptithcm.entity.ProductImage;
import ptithcm.entity.Size;
import ptithcm.entity.TypeDetail;

@Transactional
@Controller
public class ProductController {
	@Autowired
	SessionFactory factory;
	@Autowired
	ProductDao productDao;

	@Autowired
	ProductDetailDao productDetailDao;

	@Autowired
	TypeDetailDao typeDetailDao;

	@Autowired
	CartDao cartDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;

	@RequestMapping("/cart/detete/{cartDetailId}")
	public String addToCart(RedirectAttributes redirectAttributes, ModelMap model, HttpServletRequest request,
			@PathVariable("cartDetailId") Integer cartDetailId) {
		try {
			HttpSession session = request.getSession();
			Account user = (Account) session.getAttribute("user");
			if (user == null) {
				redirectAttributes.addFlashAttribute("error", "Bạn cần đăng nhập");
				return "redirect:/user/login.htm";
			}
			if (!cartDao.deleteCartDetailById(cartDetailId)) {
				redirectAttributes.addFlashAttribute("error", "Xoá thất bại");
				return "redirect:/.htm";
			}

			redirectAttributes.addFlashAttribute("success", "Xoá thành công");
			return "redirect:/.htm";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Xảy ra lỗi k xác định");
			return "redirect:/.htm";
		}
	}
	@RequestMapping(value = "/products/add-to-cart", params = "addToCheckOut")
	public String addToCheckOut(RedirectAttributes redirectAttributes, ModelMap model, HttpServletRequest request,
			@ModelAttribute("cartB") CartBean cartB) {
		try {
			HttpSession session = request.getSession();
			Account user = (Account) session.getAttribute("user");
			if (user == null) {
				redirectAttributes.addFlashAttribute("error", "Bạn cần đăng nhập");
				return "redirect:/.htm";
			}
			ProductDetail pd = productDetailDao.findProductDetailBySizePC(cartB.getSizeId(), cartB.getProductColorId());
			if (pd.getQuantity() < cartB.getQuantity()) {
				redirectAttributes.addFlashAttribute("error", "Số lượng sản phẩm phải <=" + pd.getQuantity());
				return "redirect:/products/" + cartB.getTypeDetailId() + "/" + cartB.getProductColorId() + ".htm";
			}
			CartDetail cart = new CartDetail();
			cart.setAccountId(user.getAccountId());
			cart.setProductDetailId(pd.getProductDetailId());
			cart.setQuantity(cartB.getQuantity());
			Boolean res = cartDao.addCartDetail(cart);
			if (!res) {
				redirectAttributes.addFlashAttribute("error", "Sản phẩm dã có trong giỏ hàng");
				return "redirect:/products/" + cartB.getTypeDetailId() + "/" + cartB.getProductColorId() + ".htm";
			}
			redirectAttributes.addFlashAttribute("success", "Thêm sản phẩm vào giỏ hàng thành công");
			return "redirect:/products/cart-checkout.htm";
			
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Xảy ra lỗi k xác định");
			return "redirect:/products/" + cartB.getTypeDetailId() + "/" + cartB.getProductColorId() + ".htm";
		}

	}
	@RequestMapping(value = "/products/add-to-cart", params = "addToCart")
	public String addToCart(RedirectAttributes redirectAttributes, ModelMap model, HttpServletRequest request,
			@ModelAttribute("cartB") CartBean cartB) {
		try {
			HttpSession session = request.getSession();
			Account user = (Account) session.getAttribute("user");
			if (user == null) {
				redirectAttributes.addFlashAttribute("error", "Bạn cần đăng nhập");
				return "redirect:/.htm";
			}
			ProductDetail pd = productDetailDao.findProductDetailBySizePC(cartB.getSizeId(), cartB.getProductColorId());
			if (pd.getQuantity() < cartB.getQuantity()) {
				redirectAttributes.addFlashAttribute("error", "Số lượng sản phẩm phải <=" + pd.getQuantity());
				return "redirect:/products/" + cartB.getTypeDetailId() + "/" + cartB.getProductColorId() + ".htm";
			}
			CartDetail cart = new CartDetail();
			cart.setAccountId(user.getAccountId());
			cart.setProductDetailId(pd.getProductDetailId());
			cart.setQuantity(cartB.getQuantity());
			Boolean res = cartDao.addCartDetail(cart);
			if (!res) {
				redirectAttributes.addFlashAttribute("error", "Sản phẩm dã có trong giỏ hàng");
				return "redirect:/products/" + cartB.getTypeDetailId() + "/" + cartB.getProductColorId() + ".htm";
			}
			redirectAttributes.addFlashAttribute("success", "Thêm sản phẩm vào giỏ hàng thành công");
			return "redirect:/products/" + cartB.getTypeDetailId() + "/" + cartB.getProductColorId() + ".htm";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Xảy ra lỗi k xác định");
			return "redirect:/products/" + cartB.getTypeDetailId() + "/" + cartB.getProductColorId() + ".htm";
		}

	}

	@RequestMapping("/products/cart-checkout")
	public String cartCheckout(HttpServletRequest request, ModelMap model) {
		Account user = (Account) request.getAttribute("user");

		List<Address> userAddress = addressDao.getAllAddress(user.getAccountId());
		model.addAttribute("userLogin", user);
		model.addAttribute("userAddress", userAddress);

		List<CartDetail> cartDetails = cartDao.findCardDetailByAccountId(user.getAccountId());
		CartBean cartB = new CartBean();
		cartB.setListCartD(cartDetails);
		model.addAttribute("cartB", cartB);
		return "page/cart-checkout";
	}

	@RequestMapping(value = "/cart/update", method = RequestMethod.POST)
	public String cartCheckout(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelMap model,
			@ModelAttribute("cartB") CartBean cartB) {
		try {
			for (CartDetail cartDetail : cartB.getListCartD()) {
				System.out.println(cartDetail.getQuantity());
			}
			cartDao.updateCartDetail(cartB.getListCartD());
			redirectAttributes.addFlashAttribute("success", "Cập số lượng thành công");
			return "redirect:/products/cart-checkout.htm";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("success", "Cập số lượng thất bại");
			return "redirect:/products/cart-checkout.htm";
		}
	}

	@RequestMapping("/products/{typeId}")
	public String getProduct(@PathVariable("typeId") String typeId, ModelMap model, HttpServletRequest request) {
//		pst : products type
		HttpSession session1 = request.getSession();
		Account user = (Account) session1.getAttribute("user");
		//
		List<Product> hotProduct = productDao.getBestSaleProduct();
		int limit = 3;
		Integer page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Session session = factory.getCurrentSession();
		// total pages
		String hqlTotal = "SELECT count(*) FROM Product WHERE typeDetailId=:typeId ";
		Query queryTotal = session.createQuery(hqlTotal);
		queryTotal.setParameter("typeId", typeId);
		Long total = (Long) queryTotal.uniqueResult();
		int pages = (int) Math.ceil((float) total / limit);
		int skip = (page - 1) * limit;
		// lấy ra kết quả cuối cùng sau khi tính toán phân trang
		String hql = "FROM Product WHERE typeDetailId=:typeId";
		Query query = session.createQuery(hql);
		query.setFirstResult(skip);
		query.setMaxResults(limit); // Fetch the next 5 rows after skipping
		query.setParameter("typeId", typeId);
		//
		List<Product> listProduct = query.list();
		model.addAttribute("pst", listProduct);
		model.addAttribute("pages", pages);
		model.addAttribute("page", page);
		model.addAttribute("userLogin", user);
		model.addAttribute("limit", limit);
		model.addAttribute("typeId", typeId);
		;
		model.addAttribute("hotProduct", hotProduct);
		return "page/listProduct";
	}

	@RequestMapping("/products/{typeDetailId}/{productColorId}")
	public String getProductDetail(@PathVariable("typeDetailId") String typeDetailId,
			@PathVariable("productColorId") Integer productColorId, ModelMap model, HttpServletRequest request) {
		ProductColor productColor = productDetailDao.findProductColorById(productColorId);
		TypeDetail typeDetail = typeDetailDao.getTypeDetail(typeDetailId);
		HttpSession session1 = request.getSession();
		Account user = (Account) session1.getAttribute("user");
		Set<Size> listSize = new HashSet<>();
		for (ProductDetail productDetail : productColor.getProductDetail()) {
			listSize.add(productDetail.getSize());
		}
		Set<ProductImage> setImage = new HashSet<>();
		for (ProductImage image : productColor.getImage()) {
			setImage.add(image);
		}
		model.addAttribute("setImage", setImage);
		model.addAttribute("cartB", new CartBean());
		model.addAttribute("productColor", productColor);
		model.addAttribute("productColorId", productColorId);
		model.addAttribute("typeDetail", typeDetail);
		model.addAttribute("userLogin", user);
		model.addAttribute("typeDetailId", typeDetailId);
		model.addAttribute("listSize", listSize);
		return "page/product/product-detail";
	}
	
	@RequestMapping("/products/cart-submit.htm")
	public String submitCart(RedirectAttributes redirectAttributes, @RequestParam("address") Integer addressId, Model model, HttpServletRequest request) {
		Account user = (Account) request.getAttribute("user");
		model.addAttribute("userLogin", user);
		Set<CartDetail> cartDetail = user.getCartDetail();
		Address address = addressDao.getAddress(addressId);
		
	    int totalPayment = 0;

	    for (CartDetail cartDetailItem : cartDetail) {
	        int price = cartDetailItem.getProductDetail().getProductColor().getProduct().getPrice();
	        float discount = cartDetailItem.getProductDetail().getProductColor().getProduct().getDiscount();
	        int quantity = cartDetailItem.getQuantity();

	        int discountedPrice = (int) (price - (price * discount));

	        totalPayment += discountedPrice * quantity;
	    }
		
	    Order newOrder = new Order(totalPayment, addressId);
	    Order createdOrder = orderDao.addOrder(newOrder);
	    if (createdOrder != null) {
	    	System.out.println("Add order successfully");
	    	for (CartDetail cartDetailItem : cartDetail) {
	    		OrderDetail orderDetail = new OrderDetail(createdOrder.getOrderId(), cartDetailItem.getProductDetailId(), cartDetailItem.getQuantity());
	    		if (orderDetailDao.addOrderDetail(orderDetail)) {
	    				
	    		} else {
	    			model.addAttribute("errorOrderDetail", true);
	    			redirectAttributes.addFlashAttribute("error", "Thêm chi tiết order thất bại, vui lòng đặt lại đơn hàng");
	    			return "redirect:/products/cart-checkout.htm";
	    		}
	    	}
	    } else {
	    	model.addAttribute("errorOrder", true);
	    	redirectAttributes.addFlashAttribute("error", "Thêm order thất bại, vui lòng đặt lại đơn hàng");
	    	return "redirect:/products/cart-checkout.htm";
	    }
	    for (CartDetail cartDetailItem : cartDetail) {	    	
	    	cartDao.deleteCartDetailById(cartDetailItem.getCartDetailId());
	    }
	    redirectAttributes.addFlashAttribute("success", "Đặt hàng thành công, xin cám ơn");
		return "redirect:/.htm";
	}
}
