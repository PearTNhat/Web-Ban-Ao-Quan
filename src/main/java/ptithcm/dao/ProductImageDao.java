package ptithcm.dao;


import java.util.List;


import ptithcm.entity.ProductImage;

public interface ProductImageDao {
	public Boolean addProductImage(ProductImage pi);
	public Integer countImageById(Integer productDetailId);
	public List<ProductImage> findImageByPC(Integer productColorId);
	public Boolean deleteImgByPDID(Integer pId);
	public ProductImage getLastProductImageByProductDetailId(Integer productColorId);
	public Boolean deleteImage(String image);
}
