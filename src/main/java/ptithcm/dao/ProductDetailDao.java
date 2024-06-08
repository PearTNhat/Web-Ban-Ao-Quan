package ptithcm.dao;

import java.util.List;

import ptithcm.entity.ProductColor;
import ptithcm.entity.ProductDetail;

public interface ProductDetailDao {
	public List<ProductDetail> getAllProductDetails();
	public Integer addProductColor(ProductColor pc);
	public List<ProductDetail> getProductDetails(int productId, int page, int pageSize);
	public ProductColor findProductColorById(Integer id);
	public boolean updateProductDetail(List<ProductDetail> list);
	public Integer addProductDetail(ProductDetail pd);
	public Integer findProductColor(Integer productId, Integer colorId);
	public List<ProductDetail> findProductDetailByPCId(Integer productDetailId);
}
