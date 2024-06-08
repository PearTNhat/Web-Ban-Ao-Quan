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
@Table(name = "ProductDetail", uniqueConstraints = @UniqueConstraint(columnNames = { "productColorId", "sizeId" }))
public class ProductDetail {
	@Id
	@Column(name = "productDetailId",insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productDetailId;
	
	@Column(name="productColorId")
	private Integer productColorId;
	
	@Column(name="sizeId")
	private Integer sizeId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="soldQuantity")
	private Integer soldQuantity;
	
	@ManyToOne
	@JoinColumn(name = "productColorId", insertable = false, updatable = false)
	private ProductColor productColor;
	
	@ManyToOne
	@JoinColumn(name = "sizeId", insertable = false, updatable = false)
	private Size size;
	
	public ProductDetail() {
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(Integer soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

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
