package ptithcm.entity;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CartDetail", uniqueConstraints = @UniqueConstraint(columnNames = { "productDetailId", "accountId" }))
public class CartDetail {
	@Id
	@Column(name = "cartDetailId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartDetailId;

	@Column(name = "productDetailId")
	private int productDetailId;

	@Column(name = "accountId")
	private int accountId;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "productDetailId", insertable = false, updatable = false)
	private ProductDetail productDetail;

	@ManyToOne
	@JoinColumn(name = "accountId", insertable = false, updatable = false)
	private Account account;

	public CartDetail() {

	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public Integer getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(Integer cartDetailId) {
		this.cartDetailId = cartDetailId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
