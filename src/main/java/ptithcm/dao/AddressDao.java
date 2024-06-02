package ptithcm.dao;

import java.util.List;

import ptithcm.entity.Address;

public interface AddressDao {
	public Address getAddress(Integer addressId);
	public List<Address> getAllAddress(Integer accountId);
	public Boolean addAddress(Integer accountId, Address address);
	public Boolean editAddress(Address address);
	public Boolean deleteAddress(Address address);
}
