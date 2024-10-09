package com.ms.jwt.pkg;



import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.jwt.models.itineraryentity.ItineraryPkg;
import com.ms.jwt.models.pkg.PackageInfo;
import com.ms.jwt.service.itinerary.ItineraryServiceImpl;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public List<PackageInfo> getAllPackages() {
        return packageRepository.findAll();
    }

    public Optional<PackageInfo> getPackageById(String id) {
        return packageRepository.findById(id);
    }

//    public PackageInfo createPackage(PackageInfo holidayPackage) {
//        return packageRepository.save(holidayPackage);
//   }
    public PackageInfo createPackage(PackageInfo packageInfo) {
        // Save the package along with the itinerary IDs
        return packageRepository.save(packageInfo);
    }
    
   
    public PackageInfo updatePackage(String id, PackageInfo holidayPackage) {
        if (packageRepository.existsById(id)) {
            
            return packageRepository.save(holidayPackage);
        }
        return null;
    }

    public void deletePackage(String id) {
        packageRepository.deleteById(id);
    }

//	public ResponseEntity<List<PackageInfo>> getPackagesByDestinationId(long id) {
//		return packageRepository.findByDestinationId(id);
//	}
	
	@Autowired
	private PackageRepository packageInfoRepository;    
	// Method to retrieve all packages for a specific destination ID

	public	List<PackageInfo> getPackagesByDestinationId (Long destinationId) {        
		return	packageInfoRepository.findByDestinationId(destinationId); 
	}
}
