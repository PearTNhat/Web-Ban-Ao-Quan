package ptithcm.dao;

import java.util.List;

import ptithcm.entity.CartDetail;

public interface CartDao {
	public Boolean addCartDetail(CartDetail cartDetail);
	public Boolean deleteCartDetailById(Integer cartDetailId);
}
