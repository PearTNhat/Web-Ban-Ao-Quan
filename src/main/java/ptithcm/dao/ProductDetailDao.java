package ptithcm.dao;

import java.util.List;

import ptithcm.entity.ProductDetail;

public interface ProductDetailDao {
	public List<ProductDetail> getAllProductDetails();
	public Integer addProductDetail(ProductDetail pd);
}
