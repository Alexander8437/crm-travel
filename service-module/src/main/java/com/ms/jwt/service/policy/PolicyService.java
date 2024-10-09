package com.ms.jwt.service.policy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.jwt.models.policy.Policy;
import com.ms.jwt.repository.policy.policyRepository;

@Service
public class PolicyService {
	  @Autowired
	  private policyRepository policyrepository;

	  public Policy createpolicy(Policy policy)
	  {
		//  policy.setLastUpdated(LocalDateTime.now());
		  policy.setLastUpdated(LocalDateTime.now());

		          Policy policyrepo =  policyrepository.save(policy);
		  
		return policyrepo;
		  
	  }
	  
	  public Optional<Policy> getpolicyById(Long id)
	  {
		  
		return policyrepository.findById(id);
		       
		     
	 }
	  public List<Policy> getallpolicyser()
	  {
		List<Policy>getpolicyre=      policyrepository.findAll();
		
		return getpolicyre;
		  
	  }
	  
	  public Optional< Policy >getmasterkeyby(String masterkey)
	  {
		       Optional<Policy> master=   policyrepository.findBymasterKey(masterkey);
		       
		       return master;
		  
	  }
	  
	  
	  public Policy updatepolicy(Long id ,Policy policyDetails)
	  {
		  //  Optional<Policy> policy=  policyrepository.findById(id);
		  
		   return policyrepository.save(policyDetails);
		  
	  }
	  public void Deletebyid( Long id)
	  {
		 policyrepository.deleteById(id); 
	  }
}
