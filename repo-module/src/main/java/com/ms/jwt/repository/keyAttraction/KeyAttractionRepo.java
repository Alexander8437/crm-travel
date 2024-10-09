package com.ms.jwt.repository.keyAttraction;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.jwt.models.KeyAttraction.KeyAttraction;

@Repository
public interface KeyAttractionRepo extends JpaRepository<KeyAttraction,Long>{
	
	//Optional<KeyAttraction>findBymasterkey(String masterkey);

	KeyAttraction save(KeyAttraction keyattract);

}
