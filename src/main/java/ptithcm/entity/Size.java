package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Size {
	
	@Id
	@Column(name = "SizeId")
	private String sizeId;
	
	@Column(name = "Name")
	private String name;

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
}
