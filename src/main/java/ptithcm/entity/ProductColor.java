package ptithcm.entity;

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
@Table(name = "ProductColor", uniqueConstraints = @UniqueConstraint(columnNames = { "productId", "colorId" }))
public class ProductColor {
	@Id
	@Column(name = "productColorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productColorId;

	@Column(name = "productId", nullable = false)
	private Integer productId;
	@Column(name = "colorId", nullable = false)
	private Integer colorId;

	@ManyToOne
	@JoinColumn(name = "colorId", insertable = false, updatable = false)
	private Color color;

	@ManyToOne
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	private Product product;

	@OneToMany(mappedBy = "productImage", fetch = FetchType.EAGER)
	private List<ProductImage> image;
	


	public ProductColor() {
	}

	// Getters and setters...

	public List<ProductImage> getImage() {
		return image;
	}

	public void setImage(List<ProductImage> image) {
		this.image = image;
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

	
	public Integer getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(Integer productColorId) {
		this.productColorId = productColorId;
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
