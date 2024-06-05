package ptithcm.dao;

import java.util.List;

import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;

public interface ProductDao {
	public List<Product> getProducts(int page, int pageSize, String search);
	public Boolean addProduct(Product product);
	public Long countProducts(String search);
	public List<Product> getProductByType(String typeId);
	public List<ProductDetail> getProductDetails(int productId, int page, int pageSize);
}
