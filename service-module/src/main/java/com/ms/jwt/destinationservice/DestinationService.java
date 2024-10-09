package com.ms.jwt.destinationservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.jwt.models.destination.Destination;
import com.ms.jwt.modelscountry.Country;
import com.ms.jwt.repository.country.CountryRepository;
import com.ms.jwt.repository.destination.DestinationRepository;

 @Service
public class DestinationService<Country> {
	
	@Autowired
	private DestinationRepository destinationrepository;
	
	@Autowired
	private CountryRepository countryrepository;
	
	
	public Destination createddestination( Destination destination){
		return destinationrepository.save(destination);
	}
	
	
	public List<Destination> getAllDestination(){
		return destinationrepository.findAll();
		
	}
	
	public Optional <Destination> getDestinationById(long id)	{
		return destinationrepository.findById(id);
	}
	
	public Optional<Destination> getDestinationByMasterKey(String masterKey) {
	        return destinationrepository.findByMasterkey(masterKey);
	 }
	
	public void deleteDestination(Long id)	{
		destinationrepository.deleteById(id);
	}
	
	 public Destination updateDestinationByid(Long id,Destination destination)
	 {
		
		  Optional<Destination> destiDetail=      destinationrepository.findById(id);
		  
		  {
			  
			  if(destiDetail.isPresent())
			  {
				   Destination destinationdetail=  destiDetail.get();
				 //  destinationdetail.setCountryName(destination.getCountryName());
				 //  destinationdetail.setStateName(destination.getStateName());
				   destinationdetail.setStatus(destination.getStatus());
				 //  destinationdetail.setKeyAttraction(destination.getKeyAttraction());
				   destinationdetail.setD_image(destination.getD_image());
				  // destinationdetail.setMasterkey(destination.getMasterkey());
				  // destinationdetail.setIpAddress(destination.getIpAddress());
				    return destinationrepository.save(destinationdetail);
			  }
			   else
			   {
				   new RuntimeException("Destination not found with id " + id);

			   }
				  

				  
		
		  }
		return destination;
	 }
	


}
