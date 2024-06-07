package ptithcm.dao;


import java.util.List;


import ptithcm.entity.ProductImage;

public interface ProductImageDao {
	public Boolean addProductImage(ProductImage pi);
	public Integer countImageById(Integer productDetailId);
	public List<ProductImage> findImageByPD(String productDetailId);
}
