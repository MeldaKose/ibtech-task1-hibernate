package com.meldakose.repositories;

import com.meldakose.models.Phone;

public class PhoneRepository extends HibernateBaseRepo<Phone> {

	public PhoneRepository() {
		super(Phone.class);
		// TODO Auto-generated constructor stub
	}

}
