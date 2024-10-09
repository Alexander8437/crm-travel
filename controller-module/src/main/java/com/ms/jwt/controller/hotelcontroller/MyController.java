package com.ms.jwt.controller.hotelcontroller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ms.jwt.modelshotel.Hotel;
import com.ms.jwt.servicehotel.HotelService;

//import com.HotelApi.HotelApi.entity.Hotel;
//import com.HotelApi.HotelApi.services.HotelService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("Motherson/crm/v1/hotel")
public class MyController {
	
	@Autowired
	private HotelService hotelService;
	
	
	@GetMapping("/getAll")
	public List<Hotel> getAllHotel(){
		return hotelService.getAllHotel();
	}
	
	
	@GetMapping("/destination/{id}")
	public List<Hotel> getHotelByDestinationId(@PathVariable Long id){
		return hotelService.getHotelByDestinationId(id);
	}
	
	@GetMapping("/getbyid/{id}")
	public Optional<Hotel> getHotelById(@PathVariable Long id){
		return hotelService.getHotelById(id);
	}
	

	
	private String timestamp;
	 
	public static String uploadDirectory=System.getProperty("user.dir") + "/src/main/we/image";
		
		@PostMapping("/create")
		 public Hotel saveHotel(@ModelAttribute Hotel hotel,
	             @RequestParam("image") MultipartFile[] files) throws IOException {
			List<String> imageUrls = new ArrayList<>();
			
			
			 Path uploadPath = Paths.get(uploadDirectory);
		        if (!Files.exists(uploadPath)) {
		            Files.createDirectories(uploadPath);
		        
		        }
			for(MultipartFile  file : files) {
				
	// Validate file type
	if (!isValidImage(file)) {
	throw new IllegalArgumentException("File must be a JPEG or PNG image.");
	}
	 
	
	// Generate a unique file name
	 
	 
	String uniqueFilename = generateUniqueFilename(file.getOriginalFilename());
	//String uniqueFilename = uploadDate + "_" + originalFilename; // e.g., "14-12-2024_image.jpg"
	Path fileNameAndPath = Paths.get(uploadDirectory, uniqueFilename);
	Files.write(fileNameAndPath, file.getBytes());
	 
	 
	String imageUrl = "/image/" +  uniqueFilename;;
	imageUrls.add(imageUrl);
		}
		
	hotel.setImage(imageUrls);
	 
	return this.hotelService.addHotel(hotel);
	}
	 
	private boolean isValidImage(MultipartFile file) {
	// Get the file content type
	String contentType = file.getContentType();
	return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
	}
	 
		
	 
	private String generateUniqueFilename(String originalFilename) {
	    // Extract the file extension
	    String extension = "";
	    if (originalFilename != null && originalFilename.lastIndexOf('.') > 0) {
	        extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
	    }
	    
	    // Set the current time stamp
	    
	  String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm-ss"));
	  //DateTimeFormatter timestamp = DateTimeFormatter.ofPattern("HHmm");
	 
	    // Generate a UUID
	    String uniqueID = UUID.randomUUID().toString();
	 
	    // Create a unique filename
	    
	    
	    return timestamp + "_" + uniqueID + extension;
	}
	 
	 
	
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Hotel> updateHotels(@PathVariable long id , @RequestBody Hotel hotel){
		if(hotel !=null)
		{
			Hotel h=new Hotel();
			
		h.setId(id);	
		h.setHotel_name(hotel.getHotel_name());
		h.setState_name(hotel.getState_name());
		h.setCountryname(hotel.getCountryname());
		h.setImage(hotel.getImage());
		h.setCity_name(hotel.getCity_name());
		h.setRoom_type(hotel.getRoom_type());
		h.setRoom_size(hotel.getRoom_size());
		h.setBed_type(hotel.getBed_type());
		h.setHotel_address(hotel.getHotel_address());
		h.setPin_Code(hotel.getPin_Code());
		h.setRating(hotel.getRating());
		h.setContact_number(hotel.getContact_number());
		h.setEmail(hotel.getEmail());
		h.setDescription(hotel.getDescription());
		h.setAmenities(hotel.getAmenities());
		h.setIp_address(hotel.getIp_address());
		h.setStatus(hotel.isStatus());
//		h.setDestination_Name(hotel.getDestination_Name());
		
		hotelService.updateHotels(h);
		return ResponseEntity.ok(h);
		
		}
		
		else
		{
			return ResponseEntity.notFound().build();
		}}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Hotel> deleteHotels(@PathVariable  long id){
			
			try
			{
				hotelService.findById(id);
				hotelService.deleteById(id);
				return ResponseEntity.noContent().build();
			}
			finally
			{
				return ResponseEntity.notFound().build();
			}
			
		}
}


