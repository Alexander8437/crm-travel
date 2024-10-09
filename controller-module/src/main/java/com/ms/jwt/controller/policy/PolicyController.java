package com.ms.jwt.controller.policy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.jwt.models.policy.Policy;
import com.ms.jwt.service.policy.PolicyService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("Motherson/crm/v1")
public class PolicyController {

	 @Autowired
	 
	private  PolicyService policyservice;
	 
	 @PostMapping("/createpolicy")
	public ResponseEntity<?> createPolicy(@Valid @RequestBody Policy policy,BindingResult bindingResult)
	{
		 
		  if(bindingResult.hasErrors())
   	   {
   		   Map<String,String> errors = new HashMap<>();
   		   
   		    // Loop through each error and store the field and its message in the map
              bindingResult.getFieldErrors().forEach(error -> {
                  errors.put(error.getField(), error.getDefaultMessage());
              });
              
           // Return the map of errors with a BAD_REQUEST status
              return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
          }
        Policy policyser=  policyservice.createpolicy(policy);
        
		return new ResponseEntity<>("policy is created",HttpStatus.CREATED);
        
    }
	 
	 @GetMapping("/getpolicybyid/{id}")
	 
	public Optional<Policy> getallpolicybyid(@PathVariable Long id)
	{
		        Optional<Policy> policyserid=    policyservice.getpolicyById(id); 
		        
		     return policyserid;
		
	}
	 
	 @GetMapping("/getmaster/{masterKey}")
	 public Optional<Policy> getmasterkey(@PathVariable String masterKey)
	 { 
		            Optional<Policy> masterpoli=   policyservice.getmasterkeyby(masterKey); 
		       return masterpoli;
		 
	 }
	 
	 @GetMapping("/getallpolicy")
	 public ResponseEntity<List<Policy>>getallpolicy()
	 {
		        List<Policy>getallpolicyser=  policyservice.getallpolicyser();
		return ResponseEntity.ok(getallpolicyser);
		 
	 }
	 
	 @PutMapping("/updated/{id}")
	 
	 public ResponseEntity<Policy> updatepolicy( @PathVariable Long id,@RequestBody Policy policyDet)
	 {
		 
		 
		   if(policyDet !=null)
		   {
			   Policy policy=new Policy();
			   policy.setId(id);
			   policy.setPolicyName(policyDet.getPolicyName());
		        policy.setPolicyDescription(policyDet.getPolicyDescription());
		       // policy.setPolicyContent(policyDet.getPolicyContent());
		        policy.setStatus(policyDet.getStatus());
		       // policy.setTags(policyDet.getTags());
		        policy.setEffectiveDate(policyDet.getEffectiveDate());
		        policy.setPolicyDescription(policyDet.getPolicyDescription());
		        policy.setLastUpdated(LocalDateTime.now());
		       // policy.setVersion(policy.getVersion() + 1);
		        policy.setCreatedBy(policyDet.getCreatedBy());
		       // return policyrepository.save(policy);
		     //   System.out.println(policy);
		        policyservice.updatepolicy(id, policy);
		        
		          return ResponseEntity.ok(policy);
		   }
		   //return ResponseEntity.ok(policy);
		   else
		   {
			   return ResponseEntity.notFound().build();
		   }
		        
		          
		 
	 }
	 @DeleteMapping("/delete/{id}")
	 public void deletebyid(@PathVariable Long id)
	 {
		   policyservice.Deletebyid(id);
	 }
	 
	 
}
