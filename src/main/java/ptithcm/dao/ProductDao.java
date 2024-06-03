package ptithcm.dao;

import java.util.List;

import ptithcm.entity.Product;
import ptithcm.entity.ProductDetail;

public interface ProductDao {
	public List<Product> getProducts(int page, int pageSize, String search);
	public Boolean addProductDetail(ProductDetail pd);
	public Long countProducts(String search);
	public List<Product> getProductByType(String typeId);
}
