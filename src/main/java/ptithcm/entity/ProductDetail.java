package ptithcm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import ptithcm.entity.composite.ProductDetailId;

@Entity
public class ProductDetail {
	@EmbeddedId
	private ProductDetailId compositeKey;

	@ManyToOne
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	private Product product;
	@Column(name = "color", insertable = false, updatable = false)
	private int color;
	@Column(name = "size", insertable = false, updatable = false)
	private int size;

	@Column(unique = true, name = "productDetailId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productDetailId;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Column(name = "soldQuantity")
	private int soldQuantity;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@Transient
	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public ProductDetailId getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(ProductDetailId compositeKey) {
		this.compositeKey = compositeKey;
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
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
