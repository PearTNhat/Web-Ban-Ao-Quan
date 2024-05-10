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

	@ManyToOne
	@JoinColumn(name = "colorId")
	private Color color;

	@ManyToOne
	@JoinColumn(name = "sizeId")
	private Size size;
	
	@Column(name="quantity")
	private int quantity;

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	


}
