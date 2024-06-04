package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class TypeDetail {
	@Id
	@Column(name = "typeDeatilId")
	private String typeDeatilId;

	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String desc;

	//typeProduct
	@ManyToOne
	@JoinColumn(name="typeId")
	private ProductType type;
	
	//product
	@OneToMany(mappedBy="type", fetch=FetchType.EAGER) // mappedBy = ten bien ben product  (1 - n)
	private Collection<Product> product;

	public Collection<Product> getProduct() {
		return product;
	}

	public void setProduct(Collection<Product> product) {
		this.product = product;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getTypeDeatilId() {
		return typeDeatilId;
	}

	public void setTypeDeatilId(String typeDeatilId) {
		this.typeDeatilId = typeDeatilId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
