package ptithcm.dao;

import ptithcm.entity.Address;

public interface AddressDao {
	public Boolean addAddress(Integer accountId, Address address);
}
