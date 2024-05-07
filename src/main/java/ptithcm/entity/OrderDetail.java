package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class OrderDetail {
	@Id
	@Column(name = "OrderId")
	private String orderId;
	
	@Column(name = "productSizeColorId")
	private int productSizeColorId;
	
	@Column(name = "quantityBought")
	private int quantityBought;

	@Column(name = "price")
	private int price;

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

	
	
	
	
}
