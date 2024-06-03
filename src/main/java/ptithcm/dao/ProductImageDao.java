package ptithcm.dao;

import ptithcm.entity.ProductImage;

public interface ProductImageDao {
	public Boolean addProductImage(ProductImage pi);
	public Integer countImageById(Integer productDetailId);
}
