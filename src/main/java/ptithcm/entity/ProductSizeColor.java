package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class ProductSizeColor {
	@Id
	@Column(name = "ProductID")
	private String productID;
	
	@Id
	@Column(name = "IdSize")
	private String idSize;
	
	
	@Column(unique = true, name = "ProductSizeColorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productSizeColorId;
	
	
	@Column
	private int quantity;
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Image")
	private String image;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "productSizeColor")
	private Collection<Product>  products;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "productSizeColor")
	private Collection<Color>  colors;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "productSizeColor")
	private Collection<Image>  images;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "productSizeColor")
	private Collection<Size>  sizes;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getIdSize() {
		return idSize;
	}

	public void setIdSize(String idSize) {
		this.idSize = idSize;
	}

	public int getProductSizeColorId() {
		return productSizeColorId;
	}

	public void setProductSizeColorId(int productSizeColorId) {
		this.productSizeColorId = productSizeColorId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Collection<Color> getColors() {
		return colors;
	}

	public void setColors(Collection<Color> colors) {
		this.colors = colors;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public Collection<Size> getSizes() {
		return sizes;
	}

	public void setSizes(Collection<Size> sizes) {
		this.sizes = sizes;
	}


	
	
}
