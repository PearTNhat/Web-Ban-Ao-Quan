package ptithcm.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Orders {
	@Id
	@Column(name = "orderId")
	private String orderId;
	
	@Column(name = "idAccount")
	private String idAccount;
	
	@Column(name = "purchaseTime")
	private Date pruchaseTime;
	
	@Column(name = "totalPrice")
	private int totalPrice;
	
	@Column(name = "addressId")
	private int addressId;
	
	@Column(name = "statusId")
	private String statusId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
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

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

}
