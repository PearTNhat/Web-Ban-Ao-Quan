package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "OrderDetail", uniqueConstraints = @UniqueConstraint(columnNames = { "orderId", "productColorId" }))
public class OrderDetail {

	@Id
	@Column(name = "orderDetailId",insertable = false,updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String orderDetailId;

	@Column(name = "orderId")
	private int orderId;

	@Column(name = "productDetailId")
	private int productDetailId;

	@Column(name = "quantityBought")
	private int quantityBought;

	@ManyToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "productColorId", insertable = false, updatable = false)
	private Order productColor;
	
	public OrderDetail(int orderId, int productDetailId, int quantityBought) {
		super();
		this.orderId = orderId;
		this.productDetailId = productDetailId;
		this.quantityBought = quantityBought;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetaiId(int productDetaiId) {
		this.productDetailId = productDetaiId;
	}

	public Integer getQuantityBought() {
		return quantityBought;
	}

	public void setQuantityBought(Integer quantityBought) {
		this.quantityBought = quantityBought;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getProductColor() {
		return productColor;
	}

	public void setProductColor(Order productColor) {
		this.productColor = productColor;
	}
	
}
