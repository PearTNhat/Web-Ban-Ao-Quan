package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Color {
	@Id
	@Column(name = "colorId")
	private String colorId;
	@Column(name="name")
	private String name;
	public String getColorId() {
		return colorId;
	}
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
