package com.ms.jwt.controller.KeyAttraction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.jwt.models.KeyAttraction.KeyAttraction;
import com.ms.jwt.service.keyAttraction.KeyAttractionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("Motherson/crm/v1")
public class KeyAttractionController {
	
	@Autowired
	private KeyAttractionService keyattractionservice;
	
	@PostMapping("/keyattractioncreate")
	
	public ResponseEntity<?>createKeyAttraction( @RequestBody KeyAttraction keyattraction,BindingResult bindingresult){
		
		     
		if(bindingresult.hasErrors())
    	{
    		Map<String,String> errors=new HashMap<>();
    		bindingresult.getFieldErrors().forEach( error->{
    			
    			errors.put(error.getField(), error.getDefaultMessage());
    		});
    		
    		     return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    	}
		     KeyAttraction keyser=  keyattractionservice.createKeyAttract(keyattraction);  
		     
		   return new ResponseEntity<>("keyAttraction created sucessfully",HttpStatus.CREATED);
		
	}
	@GetMapping("/keyattractionget")
	public ResponseEntity<List<KeyAttraction>> getallkeyattraction()
	{
		            List<KeyAttraction> keyattractionget=   keyattractionservice.getallkeyattraction();
		           return ResponseEntity.ok(keyattractionget);
		
	}
	 @GetMapping("/keyattractiongetbyid/{id}")
	public Optional<KeyAttraction>getbyid(@PathVariable Long id)
	{
		    Optional<KeyAttraction> getid=    keyattractionservice.getbyid(id); 
		
		      return getid;
		
	}
	 @DeleteMapping("/keyattractiondeletebyid/{id}")
	public void deletebyid(@PathVariable Long id)
	{
		 
		keyattractionservice.deletebyid(id);
	}

}
