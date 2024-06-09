package ptithcm.entity;

import java.sql.Date;
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

@Entity
public class Order {
	@Id
	@Column(name = "orderId",insertable = false,updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String orderId;
	
	@Column(name = "purchaseTime")
	private Date pruchaseTime;
	
	@Column(name = "totalPrice")
	private int totalPrice;
	
	@Column(name = "addressId")
	private int addressId;
	
	@ManyToOne
	@JoinColumn(name = "addressId",insertable = false, updatable = false)
	private Address address;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	

	public Date getPruchaseTime() {
		return pruchaseTime;
	}

	public void setPruchaseTime(Date pruchaseTime) {
		this.pruchaseTime = pruchaseTime;
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


}