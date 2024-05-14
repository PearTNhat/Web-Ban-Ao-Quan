package ptithcm.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@Column(name = "productId")
	private String productId;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private float price = 0;

	@Column(name = "type")
	private String type;

	@Column(name = "discount")
	private float discount = 0;

	@Column(name = "soldQuantity")
	private int soldQuantity=0;

	@Column(name = "createdAt")
	private Date createdAt;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<ProductSizeColor> productSizeColor;
	
	public Collection<ProductSizeColor> getProductSizeColor() {
		return productSizeColor;
	}

	public void setProductSizeColor(Collection<ProductSizeColor> productSizeColor) {
		this.productSizeColor = productSizeColor;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
