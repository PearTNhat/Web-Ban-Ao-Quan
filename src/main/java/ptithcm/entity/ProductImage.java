package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ProductImage {
	@Id
	@Column(name = "image")
	private String image;

	@Column(name = "productColorId")
	private int pcId;

	@Column(name = "priority")
	private int priority;

	@ManyToOne
	@JoinColumn(name = "productColorId", insertable = false, updatable = false)
	private ProductColor productImage;

	public ProductImage() {	
	}

	public ProductImage(String image, int pcId, int priority) {
		this.image = image;
		this.pcId = pcId;
		this.priority = priority;
	}

	public int getPdId() {
		return pcId;
	}

	public void setPdId(int pdId) {
		this.pcId = pdId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPcId() {
		return pcId;
	}

	public void setPcId(int pcId) {
		this.pcId = pcId;
	}

	public ProductColor getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductColor productImage) {
		this.productImage = productImage;
	}
}
