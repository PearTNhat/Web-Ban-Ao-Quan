package ptithcm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Size {
	@Id
	@Column(name = "sizeId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sizeId;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    private List<ProductDetail> productDetail;
    
	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
