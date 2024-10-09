package com.ms.jwt.service.customerService;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.jwt.models.Customer.Customer;

 
@Repository
public interface  CustomerServiceImpl extends  JpaRepository<Customer,Long> {

}
 
 