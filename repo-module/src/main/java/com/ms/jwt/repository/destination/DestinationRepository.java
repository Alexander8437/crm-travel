package com.ms.jwt.repository.destination;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.jwt.models.destination.Destination;
//import com.ms.jwt.modelscountry.Country;
@Repository

public interface DestinationRepository extends JpaRepository<Destination,Long > {

	   Optional<Destination> findByMasterkey(String masterkey);
	   
}
