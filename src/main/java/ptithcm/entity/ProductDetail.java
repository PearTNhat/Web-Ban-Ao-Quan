package ptithcm.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "ProductDetail", uniqueConstraints = @UniqueConstraint(columnNames = { "productId", "sizeId",
		"colorId" }))
public class ProductDetail {
	@Id
	@Column(name = "productDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productDetailId;

	@Column(name = "productId", nullable = false)
	private Integer productId;
	@Column(name = "colorId", nullable = false)
	private Integer colorId;
	@Column(name = "sizeId", nullable = false)
	private Integer sizeId;

	@Column(name = "soldQuantity")
	private int soldQuantity;

	@Column(name = "quantity")
	private int quantity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sizeId", insertable = false, updatable = false)
	private Size size;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "colorId", insertable = false, updatable = false)
	private Color color;
	
	@ManyToOne
	@JoinColumn(name = "productId",insertable = false, updatable = false)
	private Product product;

	
	@OneToMany(mappedBy = "productImage", fetch = FetchType.EAGER)
	private List<ProductImage> image;
	

	public ProductDetail() {
	}

	// Getters and setters...
	
	public Integer getProductDetailId() {
		return productDetailId;
	}

	public List<ProductImage> getImage() {
		return image;
	}

	public void setImage(List<ProductImage> image) {
		this.image = image;
	}

	public void setProductDetailId(Integer productDetailId) {
		this.productDetailId = productDetailId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
