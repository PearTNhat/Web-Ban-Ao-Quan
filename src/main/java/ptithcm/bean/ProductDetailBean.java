package ptithcm.bean;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class ProductDetailBean {

	private Integer productId;

	private Integer sizeId;

	private String size;
	@NotBlank(message = "Vui lòng thêm màu sắc")
	private String color;
	
	private Integer colorId;
	@Min(value = 1, message = "Số lượng phải lớn hơn 0")
	@NotNull(message = "Vui lòng nhập số lượng")
	private Integer quantity=0;
	private ArrayList<String> templImg;
	private List<MultipartFile> files;

	public ProductDetailBean() {

	}

	

	public ArrayList<String> getTemplImg() {
		return templImg;
	}



	public void setTemplImg(ArrayList<String> templImg) {
		this.templImg = templImg;
	}



	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

}
