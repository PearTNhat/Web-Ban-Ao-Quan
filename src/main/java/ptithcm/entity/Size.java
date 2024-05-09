package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Size {
	@Id
	@Column(name = "sizeId")
	private String sizeId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
	private Collection<ProductSizeColor> size;

	public String getSizeId() {
		return sizeId;
	}

	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<ProductSizeColor> getSize() {
		return size;
	}

	public void setSize(Collection<ProductSizeColor> size) {
		this.size = size;
	}

}
