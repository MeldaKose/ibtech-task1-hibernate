package com.meldakose.repositories;

import com.meldakose.models.Address;

public class AddressRepository extends HibernateBaseRepo<Address>  {

	public AddressRepository() {
		super(Address.class);
		// TODO Auto-generated constructor stub
	}

}
