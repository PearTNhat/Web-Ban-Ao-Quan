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
	private Integer addressid;
	
	@Column(name = "addressName")
	private String addressName;
	
	@Column(name = "recipientName")
	private String recipientname;
	
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
		this.recipientname = recipientname;
		this.phoneNumber = phoneNumber;
		this.account = account;
	}



	public Integer getAddressid() {
		return addressid;
	}


	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getRecipientname() {
		return recipientname;
	}

	public void setRecipientname(String recipientname) {
		this.recipientname = recipientname;
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
