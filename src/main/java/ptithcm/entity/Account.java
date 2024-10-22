package ptithcm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Account {
	@Id
	@Column(unique = true, name = "accountId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	
	@Column(name = "firstName")
	@NotBlank(message = "Không được để trống!")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "isAdmin")
	private boolean isAdmin;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "avatar")
	private String avatar;
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private Set<CartDetail> cartDetail = new HashSet<>();

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String firstName, String lastName, boolean isAdmin, String email, String password, String avatar) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
	}
	

	public Account(Integer accountId, String firstName, String lastName, boolean isAdmin, String email, String password,
			String avatar) {
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set<CartDetail> getCartDetail() {
		return cartDetail;
	}

	public void setCartDetail(Set<CartDetail> cartDetail) {
		this.cartDetail = cartDetail;
	}

	@Override
	public String toString() {
		return "Account " + firstName + " " + lastName + " - ID: " + accountId;
	}
}
