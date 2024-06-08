package ptithcm.dao;

import java.util.List;

import ptithcm.entity.ProductDetail;

public interface ProductDetailDao {
	public List<ProductDetail> getAllProductDetails();
	public Integer addProductDetail(ProductDetail pd);
	public List<ProductDetail> getProductDetails(int productId, int page, int pageSize);
	public ProductDetail getProductDetail(int productDetailId);
	public ProductDetail findProductDetailById(Integer id);
	public boolean updateProductDetail(ProductDetail pd);
}
