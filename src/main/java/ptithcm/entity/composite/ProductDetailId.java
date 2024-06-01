package ptithcm.entity.composite;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductDetailId implements Serializable  {
	private static final long serialVersionUID = 1L;
	private Integer productId;
    private String size;
    private String color;

    // Default constructor
    public ProductDetailId() {}

    // Constructor
    public ProductDetailId(Integer productId, String size, String color) {
        this.productId = productId;
        this.size = size;
        this.color = color;
    }

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



   
}
