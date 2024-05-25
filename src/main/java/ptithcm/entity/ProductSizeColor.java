package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductSizeColor {
	@Id
	@Column(unique = true, name = "productSizeColorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productSizeColorId;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	@Column(name="size")
	private String size;
	
	@Column(name="soldQuantity")
	private int soldQuantity;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private float price;
	
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}


	public int getProductSizeColorId() {
		return productSizeColorId;
	}

	public void setProductSizeColorId(int productSizeColorId) {
		this.productSizeColorId = productSizeColorId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
}
