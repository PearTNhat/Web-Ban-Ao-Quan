package ptithcm.dao;

import java.util.List;

import ptithcm.entity.Product;

public interface ProductDao {
	public List<Product> getProducts(int page, int pageSize, String search);
	public Long countProducts(String search);
}
