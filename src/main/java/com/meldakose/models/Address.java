package com.meldakose.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Target;

@Entity
@Table(name="address")
public class Address {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String street;
	
	private String avenue;
	
	private String city;
	
	private String district;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@Target(Customer.class)
	private Customer customer;
	
	public Address() {
		super();
	}
	
	public Address(Customer customer,String street,String avenue,String city,String district,String zipCode) {
		this.street=street;
		this.avenue=avenue;
		this.city=city;
		this.district=district;
		this.zipCode=zipCode;
		this.customer=customer;
	} 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAvenue() {
		return avenue;
	}

	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
