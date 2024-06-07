package ptithcm.bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class ProductBean {
	@NotBlank(message="Tên không được để trống")
	private String name;
	
	@Min(value = 1, message = "Giá phải lớn hơn hoặc bằng 1")
	@NotNull(message = "Không được để trống giá")
	private Integer price;
	
	@DecimalMin(value = "0.0", message = "Giảm giá phải lớn hơn hoặc bằng 0")
	@DecimalMax(value = "1.0", message = "Giảm giá phải nhỏ hơn hoặc bằng 1")
	@NotNull(message = "Không được để trống giảm giá")
	private Float discount;
	
	@NotBlank(message = "Không được để trống mô tả")
	private String description;
	
	private String typeDetailId;
	
	public ProductBean() {

	}
	
	public String getTypeDetailId() {
		return typeDetailId;
	}

	public void setTypeDetailId(String typeDetailId) {
		this.typeDetailId = typeDetailId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
