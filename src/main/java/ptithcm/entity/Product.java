package ptithcm.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@Column(name = "productId",insertable = false,updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
	
	@Column(name = "discount")
	private float discount;
	
	@Column(name = "typeDetailId")
	private String typeDetailId;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "soldQuantity")
	private Integer soldQuantity;
	
	@Column(name = "createdAt")
	private Date createdAt;

//	bên nhiều join column để lấy 1 type
	// typeDetail
	//
	@ManyToOne
	@JoinColumn(name = "typeDetailId",insertable = false, updatable = false)
	private TypeDetail type;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<ProductDetail> productDeatil;

	public Product () {};
	

	public String getTypeDetailId() {
		return typeDetailId;
	}

	public void setTypeDetailId(String typeDetailId) {
		this.typeDetailId = typeDetailId;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setSoldQuantity(Integer soldQuantity) {
		this.soldQuantity = soldQuantity;
	}





	public List<ProductDetail> getProductDeatil() {
		return productDeatil;
	}

	public void setProductDeatil(List<ProductDetail> productDeatil) {
		this.productDeatil = productDeatil;
	}

	public TypeDetail getType() {
		return type;
	}

	public void setType(TypeDetail type) {
		this.type = type;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
