package com.amazon.dao;

import com.amazon.model.Address;

public interface IAddressDAO {
	
	
	int addAddress(Address address);
	Address getAddressById(int id);
	
}
