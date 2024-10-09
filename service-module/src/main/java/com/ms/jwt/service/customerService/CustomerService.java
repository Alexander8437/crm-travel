package com.ms.jwt.service.customerService;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.jwt.models.Customer.Customer;
 
 
 
 
@Service
public class CustomerService {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	public Customer addCustomer(Customer customer) {
		return customerServiceImpl.save(customer);
	}
 
	public Customer updateCustomer(Customer c) {
		
		return  customerServiceImpl.save(c);
		
	}
 
	public void deletedById(long id) {
		
		customerServiceImpl.deleteById(id);
		
	}
 
 
	public List<Customer> getAllCustomer() {
		
		
		return customerServiceImpl.findAll();
	}
 
	public Optional<Customer> getCustomerById(Long id) {
		
		return customerServiceImpl.findById(id);
	}

	public void findById(long id) {
		// TODO Auto-generated method stub
		
	}
	}
 