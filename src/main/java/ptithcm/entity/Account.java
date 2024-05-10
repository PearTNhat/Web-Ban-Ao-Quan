package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	@Id
	@Column(name = "accountId")
	private String accountId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "isAdmin")
	private boolean isAdmin;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "addressId")
	private String addressId;
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Cart cart;
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

//	public Collection<Orders> getOrderss() {
//		return orderss;
//	}
//
//	public void setOrderss(Collection<Orders> orderss) {
//		this.orderss = orderss;
//	}
//
//	public Collection<Address> getAddresss() {
//		return addresss;
//	}
//
//	public void setAddresss(Collection<Address> addresss) {
//		this.addresss = addresss;
//	}
//
//	public Collection<Cart> getCarts() {
//		return carts;
//	}
//
//	public void setCarts(Collection<Cart> carts) {
//		this.carts = carts;
//	}
//	
	
}
