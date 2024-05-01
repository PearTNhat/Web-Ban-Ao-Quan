package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Address {
	@Id
	@Column(name = "addressId")
	private String addressid;
	
	@Column(name = "nameAddress")
	private String nameAddress;
	
	@Column(name = "recipientName")
	private String recipientname;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "Address")
	private Collection<OrderDetail>  orderDetails;

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getNameAddress() {
		return nameAddress;
	}

	public void setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
	}

	public String getRecipientname() {
		return recipientname;
	}

	public void setRecipientname(String recipientname) {
		this.recipientname = recipientname;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
