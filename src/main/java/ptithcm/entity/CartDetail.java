//package ptithcm.entity;
//
//import java.util.Collection;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//@Entity
//public class CartDetail {
//	
//	@Id
//	@JoinColumn(name = "Cart")
//	private String CartID;
//	
//	@Column(unique = true)
//	@JoinColumn(name = "ProductSizeColor")
//	private String productSizeColorID;
//	
//	@Column(name="quantity")
//	private int quantity;
//	
//	@ManyToOne
//	@JoinColumn(name = "cartId")
//	private Cart cart;
//	
//	@ManyToOne
//	@JoinColumn(name = "cartId")
//	private ProductSizeColor productSizeColor;
//	
//
//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//	public ProductSizeColor getProductSizeColor() {
//		return productSizeColor;
//	}
//
//	public void setProductSizeColor(ProductSizeColor productSizeColor) {
//		this.productSizeColor = productSizeColor;
//	}
//
//	public String getCartID() {
//		return CartID;
//	}
//
//	public void setCartID(String cartID) {
//		CartID = cartID;
//	}
//
//	public String getProductSizeColorID() {
//		return productSizeColorID;
//	}
//
//	public void setProductSizeColorID(String productSizeColorID) {
//		this.productSizeColorID = productSizeColorID;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//
//
//
//}
