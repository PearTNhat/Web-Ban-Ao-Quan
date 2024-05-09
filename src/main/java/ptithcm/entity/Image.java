package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Image {
	@Id
	@Column(unique = true, name = "ProductSizeColorId")
	private int productSizeColorId;
	
	
	@Column(name = "Image")
	private String image;
	
	@Column(name = "Priority")
	private int priority;
	
	public int getProductSizeColorId() {
		return productSizeColorId;
	}

	public void setProductSizeColorId(int productSizeColorId) {
		this.productSizeColorId = productSizeColorId;
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
