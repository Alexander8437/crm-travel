package com.ms.jwt.itinerarycontroller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ms.jwt.models.itineraryentity.ItineraryPkg;
import com.ms.jwt.modelscountry.Country;
import com.ms.jwt.service.itinerary.ItineraryService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("Motherson/crm/v1/itinerary")
public class ItineraryController {
	
	@Autowired
	private ItineraryService itineraryService;
	
	
	@GetMapping("/getAll")
	public List<ItineraryPkg> getAllItinerary(){
		return itineraryService.getAllItinerary();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<ItineraryPkg> getItineraryById(@PathVariable Long id){
		Optional<ItineraryPkg> iti = itineraryService.getItineraryById(id);
		return iti.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/getByDestinationId/{id}")
	public List<ItineraryPkg> getByDestinationID(@PathVariable Long id){
		return itineraryService.getDestinationById(id);
//		return iti.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
//	@PostMapping("/create")
//	public ResponseEntity<ItineraryPkg> addItinerary(@RequestBody ItineraryPkg  itinerary) {
//		ItineraryPkg createdItinerary = itineraryService.addItinerary(itinerary);
//		return ResponseEntity.ok(createdItinerary);
//
//}
	 public static String uploadDirectory=System.getProperty("user.dir") + "/src/main/image/countryimage";
		
		@PostMapping("/create")
		 public ItineraryPkg createitinerary(@ModelAttribute ItineraryPkg itinerarypkg,
	             @RequestParam("image") MultipartFile file) throws IOException {
	// Validate file type
	if (!isValidImage(file)) {
	throw new IllegalArgumentException("File must be a JPEG or PNG image.");
	}
	 
	String originalFilename = file.getOriginalFilename();
	Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
	Files.write(fileNameAndPath, file.getBytes());
	String imageUrl = "/image/" + originalFilename;
	   itinerarypkg.setI_image(imageUrl);
	   
	   //hotel.setModify_Dt(LocalDateTime.now());
	 
	return this.itineraryService.addItinerary(itinerarypkg);
	}
	 
	private boolean isValidImage(MultipartFile file) {
	// Get the file content type
	String contentType = file.getContentType();
	return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
	}
	 
			
	@PutMapping("/updateById/{id}")
	public ResponseEntity<ItineraryPkg> updateItinerary(@PathVariable Long id, @RequestBody ItineraryPkg itinerary){
		
		try
		{
			ItineraryPkg savedItinerary = itineraryService.updateItinerary(id, itinerary);
			return ResponseEntity.ok(savedItinerary);
		}
		catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
		}
	
		
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<ItineraryPkg> deleteItinerary(@PathVariable Long id){
		
		try
		{
			itineraryService.findById(id);
			itineraryService.deleteById(id);
	        return ResponseEntity.noContent().build();
			
		}
		
		finally
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
}
