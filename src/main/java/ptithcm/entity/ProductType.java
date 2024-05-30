package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductType {
	@Id
	@Column(name = "typeId")
	private int typeId;
	

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
	private Collection<TypeDetail> types;
	
	public Collection<TypeDetail> getTypes() {
		return types;
	}
	public void setTypes(Collection<TypeDetail> types) {
		this.types = types;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
