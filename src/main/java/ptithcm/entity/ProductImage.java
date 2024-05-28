package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductImage {
	@Id
	@Column(name = "image")
	private String image;

	@Column(name = "productId")
	private int productId;

	@Column(name = "priority")
	private int priority;

	public ProductImage(String image, int productId, int priority) {
		super();
		this.image = image;
		this.productId = productId;
		this.priority = priority;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

}
