package com.ms.jwt.pkg;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ms.jwt.models.pkg.PackageInfo;
import com.ms.jwt.modelshotel.Hotel;


@Repository
public interface PackageRepository  extends JpaRepository<PackageInfo, String> {

//	@Query(value = "Select * from packages_master u where u.destination_id = :id", nativeQuery = true)
//	ResponseEntity<List<PackageInfo>> getPackagesByDestinationId(long id);

	//ResponseEntity<List<PackageInfo>> findByDestinationId(long destinationId); 
	List<PackageInfo> findByDestinationId(Long destinationId);

	 
}
