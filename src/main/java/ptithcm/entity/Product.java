package ptithcm.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@Column(name = "productId")
	private String productId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;


	@Column(name = "discount")
	private float discount ;

	@Column(name = "createdAt")
	private Date createdAt;
	
//	bên nhiều join column để lấy 1 type
	// type detail 
	// 
	@ManyToOne
	@JoinColumn(name = "typeDetailId")
	private TypeDetail type;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<ProductDetail> productDeatil;
	
	public Collection<ProductDetail> getProductDeatil() {
		return productDeatil;
	}

	public void setProductDeatil(Collection<ProductDetail> productDeatil) {
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
