package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class OrderDetail {
	@Id
	@Column(name = "OrderId")
	private String orderId;
	
	@Id
	@Column(name = "productSizeColorId")
	private int productSizeColorId;
	
	@Column(name = "quantityBought")
	private int quantityBought;
	
	
	public Collection<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}

	@Column(name = "price")
	private int price;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "OrderDetail")
	private Collection<ProductSizeColor>  productSizeColors;

	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "OrderDetail")
	private Collection<Orders>  orders;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getProductSizeColorId() {
		return productSizeColorId;
	}

	public void setProductSizeColorId(int productSizeColorId) {
		this.productSizeColorId = productSizeColorId;
	}

	public int getQuantityBought() {
		return quantityBought;
	}

	public void setQuantityBought(int quantityBought) {
		this.quantityBought = quantityBought;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Collection<ProductSizeColor> getProductSizeColors() {
		return productSizeColors;
	}

	public void setProductSizeColors(Collection<ProductSizeColor> productSizeColors) {
		this.productSizeColors = productSizeColors;
	}
	
	
	
	
}
