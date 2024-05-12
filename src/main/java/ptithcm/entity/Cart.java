//package ptithcm.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Cart {
//	@Id
//	@Column(name = "cartId")
//	private	String cartId;
//	
//	@Column(name = "userID")
//	private String userID;
//	
//	
//	@ManyToOne
//	@JoinColumn(name = "accountId")
//	private Account account;
//
//
//	public String getCartId() {
//		return cartId;
//	}
//
//
//	public void setCartId(String cartId) {
//		this.cartId = cartId;
//	}
//
//
//	public String getUserID() {
//		return userID;
//	}
//
//
//	public void setUserID(String userID) {
//		this.userID = userID;
//	}
//
//
//	public Account getAccount() {
//		return account;
//	}
//
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//	
//
//}
