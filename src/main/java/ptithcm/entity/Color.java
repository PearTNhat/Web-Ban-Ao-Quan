package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Color {
	@Id
	@Column(name = "ColorId")
	private String colorId;
	

	@Column
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
