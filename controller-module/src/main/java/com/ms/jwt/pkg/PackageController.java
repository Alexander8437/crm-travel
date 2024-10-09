package com.ms.jwt.pkg;


import com.ms.jwt.models.booking.Booking;
import com.ms.jwt.models.pkg.*;
import com.ms.jwt.request_response.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("Motherson/crm/v1/package")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/getAllPkg")
    public List<PackageInfo> getAllPackages() {
        return packageService.getAllPackages();
    }

    @GetMapping("/getpkg/{id}")
    public ResponseEntity<PackageInfo> getPackageById(@PathVariable String id) {
        Optional<PackageInfo> holidayPackage = packageService.getPackageById(id);
        return holidayPackage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
//    @GetMapping("/getByDestinationId/{id}")
//    public ResponseEntity<List<PackageInfo>> getPackageByDestinationId(@PathVariable long id) {
//        ResponseEntity<List<PackageInfo>> packageresult =  packageService.getPackagesByDestinationId(id);
//        return packageresult;
////        		holidayPackage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
    
//    @GetMapping("/getByDestinationId/{id}")
//    public ResponseEntity<List<PackageInfo>> getPackageByDestinationId(@PathVariable Long id) {
//        Query query;
//		try {
//			query = EntityManager.createQuery("SELECT b FROM Booking b WHERE b.customerId = :id");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        query.setParameter("id", id);
//        
//        List<Booking> bookings = query.getResultList();
//        
//        if (bookings.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no bookings found
//        }
//
//        return new ResponseEntity<>(bookings, HttpStatus.OK); // Return the list of bookings
//    }

//    @PostMapping("/createpkg")
//    public ResponseEntity<?> createPackage(@Valid  @RequestBody Root product) {
//    
//    	 PackageInfo packageInfo = product.getPackageInfo();
//    	 Optional<PackageInfo> updatedPackage =packageService.getPackageById(packageInfo.getId());;
//         System.out.println(updatedPackage);
//    	 if (updatedPackage.isEmpty()) {
//    		 packageService.createPackage(packageInfo);
//        	
//         }else {
//        	 return ResponseEntity.ok().body(new MessageResponse("Data already exist!", 403, HttpStatus.FORBIDDEN));
//         }
//        return  ResponseEntity.ok().body(new MessageResponse("Data successfully inserted!", 204, HttpStatus.ACCEPTED));
//    }
//    @PostMapping("/createpkg")
//    public ResponseEntity<?> createPackage(@Valid @RequestBody Root product) {
//        // Extract PackageInfo and itinerary IDs from the Root object
//        PackageInfo packageInfo = product.getPackageInfo();
//        List<Long> itineraryIds = product.getItineraryIds(); // Extracting itinerary IDs
//
//        // Check if the package already exists by ID
//        Optional<PackageInfo> existingPackage = packageService.getPackageById(packageInfo.getId());
//
//        if (existingPackage.isEmpty()) {
//            // If it doesn't exist, set the itinerary IDs in the PackageInfo
//            packageInfo.setItineraryIdList(itineraryIds);
//
//            // Save the package
//            packageService.createPackage(packageInfo);
//
//            return ResponseEntity.ok().body(new MessageResponse("Data successfully inserted!", 204, HttpStatus.ACCEPTED));
//        } else {
//            return ResponseEntity.ok().body(new MessageResponse("Data already exists!", 403, HttpStatus.FORBIDDEN));
//        }
//    }
    @PostMapping("/create")
    public ResponseEntity<?> createPackage(@Valid @RequestBody Root product) {
        PackageInfo packageInfo = product.getPackageInfo();
        
        // Set the itinerary IDs from Root to PackageInfo
        packageInfo.setItineraryIdList(product.getItineraryIds());

        // Check if the package already exists
        Optional<PackageInfo> updatedPackage = packageService.getPackageById(packageInfo.getId());
        
        if (updatedPackage.isEmpty()) {
            packageService.createPackage(packageInfo);
        } else {
            return ResponseEntity.ok().body(new MessageResponse("Data already exists!", 403, HttpStatus.FORBIDDEN));
        }

        return ResponseEntity.ok().body(new MessageResponse("Data successfully inserted!", 204, HttpStatus.ACCEPTED));
    }
    
    @PutMapping("/updatepkg/{id}")
    public ResponseEntity<PackageInfo> updatePackage(@PathVariable String id, @RequestBody PackageInfo holidayPackage) {
    	PackageInfo updatedPackage = packageService.updatePackage(id, holidayPackage);
        if (updatedPackage != null) {
            return ResponseEntity.ok(updatedPackage);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletepkg/{id}")
    public ResponseEntity<?> deletePackage(@PathVariable String id) {
        packageService.deletePackage(id);
       
        return  ResponseEntity.ok().body(new MessageResponse("Data successfully deleted!", 204, HttpStatus.ACCEPTED));
    }
}
