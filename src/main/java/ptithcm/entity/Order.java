package ptithcm.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "[Order]")
public class Order {
	@Id
	@Column(name = "orderId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@Column(name = "purcharseTime", insertable = false, updatable = false)
	private Date purcharseTime;

	@Column(name = "totalPrice")
	private int totalPrice;

	@Column(name = "addressId")
	private int addressId;

	@ManyToOne
	@JoinColumn(name = "addressId", insertable = false, updatable = false)
	private Address address;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<OrderDetail> orderDetail = new HashSet<OrderDetail>();

	public int getOrderId() {
		return orderId;
	}

	public Order() {
	}

	public Order(int totalPrice, int addressId) {
		super();
		this.totalPrice = totalPrice;
		this.addressId = addressId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getPurcharseTime() {
		return purcharseTime;
	}

	public void setPurcharseTime(Date purcharseTime) {
		this.purcharseTime = purcharseTime;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

}
