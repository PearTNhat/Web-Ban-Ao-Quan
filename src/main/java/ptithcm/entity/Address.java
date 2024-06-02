package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	@Column(name = "addressId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	@Column(name = "addressName")
	private String addressName;
	
	@Column(name = "recipientName")
	private String recipientName;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Address(String addressName, String recipientname, String phoneNumber, Account account) {
		super();
		this.addressName = addressName;
		this.recipientName = recipientname;
		this.phoneNumber = phoneNumber;
		this.account = account;
	}

	public Address(Integer addressId, String addressName, String recipientName, String phoneNumber, Account account) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
		this.recipientName = recipientName;
		this.phoneNumber = phoneNumber;
		this.account = account;
	}


	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressid(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientname(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
