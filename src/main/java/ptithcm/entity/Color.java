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
public class Color {
	@Id
	@Column(name = "colorId", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer colorId;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
	private List<ProductColor> productDetail;

	public Color() {
	};

	public Color(String name) {
		this.name = name;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
