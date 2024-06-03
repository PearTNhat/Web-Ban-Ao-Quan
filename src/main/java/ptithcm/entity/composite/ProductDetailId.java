package ptithcm.entity.composite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductDetailId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "productId", nullable = false)
	private Integer productId;

	@Column(name = "size", nullable = false)
	private String size;

	@Column(name = "color", nullable = false)
	private String color123;

	// Default constructor
	public ProductDetailId() {
	}

	// Constructor
	public ProductDetailId(Integer productId,  String color123,String size) {
		this.productId = productId;
		this.color123 = color123;
		this.size = size;
	}

	// Getters and setters...

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor123() {
		return color123;
	}

	public void setColor123(String color123) {
		this.color123 = color123;
	}

}
