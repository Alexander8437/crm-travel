package com.ms.jwt.destinationcontroller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ms.jwt.destinationservice.DestinationService;
import com.ms.jwt.models.User;
import com.ms.jwt.models.destination.Destination;
import com.ms.jwt.modelscountry.Country;
import com.ms.jwt.modelscountry.State;
import com.ms.jwt.repository.country.CountryRepository;
import com.ms.jwt.repository.country.StateRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("Motherson/crm/v1/destination")
public class DestinationController {
	@Autowired
	private DestinationService destinationservice;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository staterepository;
	
	
	
//	@PostMapping("/create")
//	public ResponseEntity <Destination> created(@Valid @RequestBody Destination destination)
//	{
//		
//		System.out.print("--------------------xxxxxxxxxxxxxxxxxxxxxxxxxxx--------------");
//		 // Process each key attraction to add a master k	       Destination created= destinationservice.createddestination(destination);
//		return ResponseEntity.ok(created);
//		
//	}
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/image/countryimage";

	@PostMapping("/createdestination")
	public Destination createstate(@ModelAttribute Destination destination, @RequestParam("image") MultipartFile file)
			throws IOException {
// Validate file type
	  Country country = countryRepository.findByMasterKey("COUNTRY-IN-190fd2a9-d89d-4558-ac06-9f9f42b74750").orElse(null);
		destination.setCountry(country);
//		
		   State state = staterepository.findByMasterKey("STATE-HR-4e6ed346-f83c-49ed-a4e4-9cdf3d7facc5").orElse(null);
//		     
		   destination.setState(state);
		   
		
		if (!isValidImage(file)) {
			throw new IllegalArgumentException("File must be a JPEG or PNG image.");
		}

		String originalFilename = file.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
		Files.write(fileNameAndPath, file.getBytes());
		String imageUrl = "/image/" + originalFilename;
		destination.setD_image(imageUrl);

		// hotel.setModify_Dt(LocalDateTime.now());

		return this.destinationservice.createddestination(destination);
	}

	private boolean isValidImage(MultipartFile file) {
// Get the file content type
		String contentType = file.getContentType();
		return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Destination>> getAlldestination() {
		List<Destination> destinationdt = destinationservice.getAllDestination();
		return ResponseEntity.ok(destinationdt);

	}

	@GetMapping("/getbyid/{id}")
	public Optional<Destination> getDestinationById(@PathVariable Long id) {
		Optional<Destination> destinationid = destinationservice.getDestinationById(id);

		return destinationid;

	}

	@GetMapping("/getmasterkey/{masterkey}")
	public Optional<Destination> getMasterKey(@PathVariable String masterkey) {
		Optional<Destination> destinationmaster = destinationservice.getDestinationByMasterKey(masterkey);
		return destinationmaster;

	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteById(@PathVariable Long id) {
		destinationservice.deleteDestination(id);
	}

	@PutMapping("/updateall/{id}")
	public Destination updated(@PathVariable Long id, @RequestBody Destination dts) {

		Destination updatedestination = destinationservice.updateDestinationByid(id, dts);

		return updatedestination;

	}

}
