package ptithcm.bean;

import java.util.List;

import ptithcm.entity.CartDetail;

public class CartBean {
	private Integer quantity;
	private Integer accountId;
	private Integer productDetailId;
	private Integer sizeId;
	private String typeDetailId;
	private List<CartDetail> listCartD;
	public CartBean() {
	
	}
	
	
	public List<CartDetail> getListCartD() {
		return listCartD;
	}


	public void setListCartD(List<CartDetail> listCartD) {
		this.listCartD = listCartD;
	}


	public String getTypeDetailId() {
		return typeDetailId;
	}


	public void setTypeDetailId(String typeDetailId) {
		this.typeDetailId = typeDetailId;
	}


	public Integer getProductDetailId() {
		return productDetailId;
	}


	public void setProductDetailId(Integer productDetailId) {
		this.productDetailId = productDetailId;
	}


	public Integer getSizeId() {
		return sizeId;
	}


	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}


	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getProductColorId() {
		return productDetailId;
	}
	public void setProductColorId(Integer productColorId) {
		this.productDetailId = productColorId;
	}
	
	
}
