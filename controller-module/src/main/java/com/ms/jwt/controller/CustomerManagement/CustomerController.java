package com.ms.jwt.controller.CustomerManagement;


import java.util.List;

import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ms.jwt.models.Customer.Customer;
import com.ms.jwt.service.customerService.CustomerService;
 

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Motherson/crm/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
 
	@GetMapping("/getAllcust")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
		Optional<Customer> C = customerService.getCustomerById(id);

		return C.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

	}
 
	@PostMapping("/create")
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);
}


	@PutMapping("/updateById/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id , @RequestBody Customer customer ){
		if(customer != null)

		{

			Customer c = new Customer();

			c.setId(id);

			c.setCust_Name(customer.getCust_Name());

			c.setCust_Email(customer.getCust_Email());

			c.setCust_Phone(customer.getCust_Phone());

			c.setReg_No(customer.getReg_No());

			c.setStatus(customer.isStatus());

			c.setCust_Address(customer.getCust_Address());

			c.setEmergency_Contact(customer.getEmergency_Contact());

			c.setMarital_Status(customer.getMarital_Status());

			c.setLead_Source(customer.getLead_Source());

			customerService.updateCustomer(c);

			return ResponseEntity.ok(c);

		}

		else

		{

			return ResponseEntity.notFound().build();

		}
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Customer> deleteCustomer(@PathVariable long id){
			try
			{

			customerService.findById(id);

			customerService.deletedById(id);

			return ResponseEntity.noContent().build();

			}

			finally

			{

				return ResponseEntity.notFound().build();

			}

}}
 