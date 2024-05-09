package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	@Column(name = "CartId")
	private	String CartID;
	
	@Column(name = "userID")
	private String userID;
	public Cart(String cartID, String userID) {
		CartID = cartID;
		this.userID = userID;
	}
	public String getCartID() {
		return CartID;
	}
	public void setCartID(String cartID) {
		CartID = cartID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
