package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ProductColor", uniqueConstraints = @UniqueConstraint(columnNames = { "productId", "colorId" }))
public class ProductDetail {
	@Id
	@Column(name = "productDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productDetailId;
	
	@Column(name="productColorId")
	private Integer productColorId;
	
	@Column(name="sizeId")
	private Integer sizeId;
	
	@ManyToOne
	@JoinColumn(name = "productColorId", insertable = false, updatable = false)
	private ProductColor productColor;
	
	@ManyToOne
	@JoinColumn(name = "sizeId", insertable = false, updatable = false)
	private Size size;

	public Integer getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(Integer productDetailId) {
		this.productDetailId = productDetailId;
	}

	public Integer getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(Integer productColorId) {
		this.productColorId = productColorId;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public ProductColor getProductColor() {
		return productColor;
	}

	public void setProductColor(ProductColor productColor) {
		this.productColor = productColor;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	
	
	
}
