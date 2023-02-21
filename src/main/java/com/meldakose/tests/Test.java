package com.meldakose.tests;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.meldakose.models.Account;
import com.meldakose.models.Address;
import com.meldakose.models.Customer;
import com.meldakose.models.Phone;
import com.meldakose.repositories.AccountRepository;
import com.meldakose.repositories.AddressRepository;
import com.meldakose.repositories.CustomerRepository;
import com.meldakose.repositories.PhoneRepository;

public class Test {
	public void add() {
		CustomerRepository customerRepo=new CustomerRepository();
		PhoneRepository phoneRepo=new PhoneRepository();
	    AddressRepository addressRepo=new AddressRepository();
	    AccountRepository accountRepo=new AccountRepository();
	    
		ArrayList<Customer> customer= new ArrayList<>();
		customer.add(new Customer("Melda","Köse","Kadın","meldakose99@gmail.com","153115151"));
		customer.add(new Customer("Example","Example2","Kadın","example@example.com","8455213"));
		
		ArrayList<Address> address= new ArrayList<>();
		address.add(new Address(customerRepo.get(1),"Sokak","Cadde","Şehir","Semt","512121"));
		address.add(new Address(customerRepo.get(1),"Manalapan St.","Garfield Ave","California","Alhambra","5312"));
		
		ArrayList<Phone> phone= new ArrayList<>();
		phone.add(new Phone(customerRepo.get(1),"+90","8525512222"));
		phone.add(new Phone(customerRepo.get(1),"+90","8845966215"));
		
		ArrayList<Account> account= new ArrayList<>();
		Timestamp date=new Timestamp(System.currentTimeMillis());
		account.add(new Account("TR14512210","TRY",1000.5,date,customerRepo.get(1)));
		account.add(new Account("TR86512021","TRY",3000,date,customerRepo.get(1)));
		
		
		for(Address a:address) {
			addressRepo.add(a);
		}
		for(Customer c:customer) {
			customerRepo.add(c);
		}
		
	
		for(Phone p:phone) {
			phoneRepo.add(p);
		}
		for(Account a:account) {
			accountRepo.add(a);
		}
		
	}
	
	public void update() {
		CustomerRepository customerRepo=new CustomerRepository();
		PhoneRepository phoneRepo=new PhoneRepository();
	    AddressRepository addressRepo=new AddressRepository();
	    AccountRepository accountRepo=new AccountRepository();
	    
	    Customer customer=customerRepo.get(1);
	    Phone phone=phoneRepo.get(2);
	    Account account=accountRepo.get(2);
	    Address address=addressRepo.get(2);
	    
	    customer.setName("Alya");
	    phone.setNumber("11111111");
	    account.setType("USD");
	    address.setStreet("Santa");
	    
	   
	    phoneRepo.update(phone);
	    accountRepo.update(account);
	    addressRepo.update(address);
	    customerRepo.update(customer);
	    
	}
	
	public void delete() {
		CustomerRepository customerRepo=new CustomerRepository();
		PhoneRepository phoneRepo=new PhoneRepository();
	    AddressRepository addressRepo=new AddressRepository();
	    AccountRepository accountRepo=new AccountRepository();
	    
	    Customer customer=customerRepo.get(2);
	    Phone phone=phoneRepo.get(1);
	    Account account=accountRepo.get(1);
	    Address address=addressRepo.get(1);
	   
	    phoneRepo.delete(phone);
	    accountRepo.delete(account);
	    addressRepo.delete(address);
	    customerRepo.delete(customer);
	    
	}
	
	public void getAll() {
		CustomerRepository customerRepo=new CustomerRepository();
		PhoneRepository phoneRepo=new PhoneRepository();
	    AddressRepository addressRepo=new AddressRepository();
	    AccountRepository accountRepo=new AccountRepository();
	    
	    List<Customer> customer=customerRepo.getAll();
	    List<Phone> phone=phoneRepo.getAll();
	    List<Account> account=accountRepo.getAll();
	    List<Address> address=addressRepo.getAll();
	    
	    for(Customer c:customer) {
	    	System.out.println(c.getName()+" "+c.getSurname()+" "+c.getEmail()+" "+c.getGender()+" "+c.getTc());
	    }
	    for(Phone c:phone) {
	    	System.out.println(c.getAreaCode()+" "+c.getNumber()+" "+c.getCustomer().getName());
	    }
	    for(Account c:account) {
	    	System.out.println(c.getIban()+" "+c.getBalance()+" "+c.getType()+" "+c.getCustomer().getName());
	    }
	    for(Address c:address) {
	    	System.out.println(c.getStreet()+" "+c.getAvenue()+" "+c.getDistrict()+" "+c.getCity()+" "+c.getZipCode()+" "+c.getCustomer().getName());
	    }
	}
	
	
}
