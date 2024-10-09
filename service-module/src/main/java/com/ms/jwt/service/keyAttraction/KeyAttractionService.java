package com.ms.jwt.service.keyAttraction;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ms.jwt.models.KeyAttraction.KeyAttraction;
import com.ms.jwt.repository.keyAttraction.KeyAttractionRepo;

@Service
public class KeyAttractionService {
	@Autowired
	private KeyAttractionRepo keyattractionrepo;
	
	public KeyAttraction createKeyAttract(KeyAttraction keyattract)
	{
		
		       KeyAttraction keyatt= keyattractionrepo.save(keyattract);
		         
		     return keyatt;
		
	}
	
	public List<KeyAttraction> getallkeyattraction(){
		
		
		 
	          List<KeyAttraction>getlist=  keyattractionrepo.findAll();
		    
		return getlist;
		
	}
	 
	public Optional <KeyAttraction> getbyid(Long id)
	{
		  //  keyattractionrepo.findById(id);
		return keyattractionrepo.findById(id);
		
	} 
	public void deletebyid(Long id)
	{
		 keyattractionrepo.deleteById(id);
	}
	   
	
	

}
