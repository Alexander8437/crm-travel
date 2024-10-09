package com.ms.jwt.repository.country;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.jwt.modelscountry.Country;

@Repository

public interface CountryRepository extends JpaRepository<Country,Long> {



	
	    

  // Country  findByKey(String masterKey);
	




 Optional <Country> findByMasterKey(String masterKey);
	


}
