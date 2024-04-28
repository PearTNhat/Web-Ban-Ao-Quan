package ptithcm.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class Product {
	@Id
	@Column(name = "ProductId")
	private String productId;
	


	@Column
	private String name;
	
	@Column
	private int quantity;
	
	@Column
	private String description;

	@Column
	private int Money;
	
	@Column
	private String type;
	
	@Column
	private float discount;
	
	@Column
	private int soldQuantity;
	
	@Column
	private Date createdAt;
	


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		Money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
