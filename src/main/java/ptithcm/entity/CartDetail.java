package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class CartDetail {
	
	@Id
	@JoinColumn(name = "Cart")
	private String CartID;
	
	@Column(unique = true)
	@JoinColumn(name = "ProductSizeColor")
	private String productSizeColorID;
	
	@Column
	private int quantity;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cartDetail")
	private Collection<Cart>  carts;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cartDetail")
	private Collection<ProductSizeColor>  productSizeColors;

	public String getCartID() {
		return CartID;
	}

	public void setCartID(String cartID) {
		CartID = cartID;
	}

	public String getProductSizeColorID() {
		return productSizeColorID;
	}

	public void setProductSizeColorID(String productSizeColorID) {
		this.productSizeColorID = productSizeColorID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}

	public Collection<ProductSizeColor> getProductSizeColors() {
		return productSizeColors;
	}

	public void setProductSizeColors(Collection<ProductSizeColor> productSizeColors) {
		this.productSizeColors = productSizeColors;
	}


}
