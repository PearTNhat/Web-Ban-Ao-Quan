package ptithcm.dao;

import java.util.List;

import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;

public interface ProductDao {
	public List<Product> getProducts(int page, int pageSize, String search);

	public Boolean addProduct(Product product);

	public Long countProducts(String search);

	public Product findProductById(Integer productId);

	public List<Product> getProductByType(String typeId);
	
	public Product getProductById(int productId);
	
	public Boolean updateProduct(Product product);
	
	public List<Product> getBestSaleProduct();
	
	public List<Product> getNewProduct();
	
	public Boolean deleteProduct(Product product);
}
