package com.ms.jwt.service.itinerary;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ms.jwt.models.itineraryentity.ItineraryPkg;
import com.ms.jwt.models.pkg.PackageInfo;

@Repository
public interface ItineraryServiceImpl extends JpaRepository<ItineraryPkg, Long> {

//	@Query(value="select * from itinerary_master where itinerary_master.destination_id = :did", nativeQuery = true)
	List<ItineraryPkg> findByDestinationId(Long did);

//	List<ItineraryPkg> findAllById(Collection<PackageInfo> itineraryIds);

}
