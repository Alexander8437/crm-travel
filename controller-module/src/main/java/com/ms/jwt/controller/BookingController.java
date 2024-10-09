package com.ms.jwt.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ms.jwt.models.booking.Booking;
import com.ms.jwt.models.pkg.PackageInfo;
import com.ms.jwt.modelshotel.Hotel;
import com.ms.jwt.service.BookingService;





@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Motherson/crm/v1/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	

//	@GetMapping("/api/bookings/topDestinations")
//    public List<Map<String, Object>> getTopTo_Destinations(@RequestParam(defaultValue = "2") int limit) {
//        return bookingService.getTopTo_Destinations(limit);	
//	
//	
//	}
	
	
	@GetMapping("/getAll/{name}")
	public List<Booking> getAllCancleBooking(@PathVariable String name){
		return bookingService.getAllCancleBooking(name);
	}
	
	
	 
//	@GetMapping("/getAllPending")
//    public List<Booking> getAllPendingBookings() {
//        return bookingService.getAllPendingBookings();
//    }
//	
//	
//	@GetMapping("/getAllConfirmed")
//    public List<Booking> getAllConfirmedBookings() {
//        return bookingService.getAllConfirmedBookings();
//    }
//	
	//@Autowiredprivate
	//private BookingService bookingService;    
	// API endpoint to get all packages for a specific destination ID
	@GetMapping("/packages/by-destination/{destinationId}")public
	ResponseEntity<?> getPackagesByDestinationId(@PathVariable Long destinationId)
	{        
		List<PackageInfo> packages = bookingService.getPackagesByDestinationId(destinationId);        
	if	(packages.isEmpty()) {            
		return ResponseEntity.ok("No packages found for this destination."); 
	}
	return 	ResponseEntity.ok(packages); 
	}
	
	@GetMapping("/cancle/{bookingByUserId}")
	public List<Booking> getCancleBookings(@PathVariable Long bookingByUserId){
	return bookingService.getCancleBookiByUserId(bookingByUserId);
}
	
	
	@GetMapping("/pending/{bookingByUserId}")
    public List<Booking> getPendingBookings(@PathVariable Long bookingByUserId) {
        return bookingService.getPendingBookingsByUserId(bookingByUserId);
	}
	
	@PostMapping("/findByDestinationIdAndRating")
	public List<Hotel> getByDestinationIdAndRating(@RequestBody Long destinationId, String rating){
		return bookingService.gethotelByDestinationIdAndRating(destinationId, rating);
	}
 
	
//	@GetMapping("/pending/{bookingByUserId}")
//    public List<Booking> getPendingBookingsByUserId(@PathVariable Long bookingByUserId) {
//        return bookingService.getPendingBookingsByUserId(bookingByUserId);
//	}
	
	
	@GetMapping("/Confirmed/{bookingByUserId}")
    public List<Booking> getConfirmedBookingsByUserId(@PathVariable Long bookingByUserId) {
        return bookingService.getConfirmedBookingsByUserId(bookingByUserId);
	}
	
	@GetMapping("/getAllbookingList")
	public List<Booking> getAllBooking(){
		return bookingService.getAllBooking();
		
	}
	
	@GetMapping("/user/{bookingByUserId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long bookingByUserId) {
        return bookingService.findBookingsByUserId(bookingByUserId);
	}
        
        
	@GetMapping("/getBookingById/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
		Optional<Booking>  B = bookingService.getBookingById(id);
		return B.map(ResponseEntity ::ok).orElseGet(()  -> ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/top-destinations/{userId}")
    public Map<String, Long> getTopConfirmedDestinations(@PathVariable Long userId,
                                                          @RequestParam(defaultValue = "Error") int limit) {
        return bookingService.getTopConfirmedDestinations(userId, limit);
	}
 
	
	
	private String timestamp;

//	public static String uploadDirectory=System.getProperty("user.dir") + "/src/main/upload/images";
//		
//		@PostMapping("/createbooking")
//		 public Booking saveBooking(@ModelAttribute Booking booking,
//	             @RequestParam("image") MultipartFile[] files) throws IOException {
//			List<String> imageUrls = new ArrayList<>();
//			
//			//String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HHmm"));
//			//String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmm"));
//			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");// for date
//			
//			 Path uploadPath = Paths.get(uploadDirectory);
//		        if (!Files.exists(uploadPath)) {
//		            Files.createDirectories(uploadPath);
//		        }
//			
//			for(MultipartFile  file : files) {
//				
//	// Validate file type
//	if (!isValidImage(file)) {
//	throw new IllegalArgumentException("File must be a JPEG or PNG image.");
//	}

	
	//// Get the upload date formatted
	//String uploadDate = LocalDate.now().format(formatter);
	//String originalFilename = file.getOriginalFilename();

	// Generate a unique file name

	//String uniqueFilename = generateUniqueFilename(uploadDate, originalFilename, timestamp);
//	String uniqueFilename = generateUniqueFilename(file.getOriginalFilename());
//	//String uniqueFilename = uploadDate + "_" + originalFilename; // e.g., "14-12-2024_image.jpg"
//	Path fileNameAndPath = Paths.get(uploadDirectory, uniqueFilename);
//	Files.write(fileNameAndPath, file.getBytes());
//
//
//
//	//String originalFilename = file.getOriginalFilename();
//	//Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
//	//Files.write(fileNameAndPath, file.getBytes());
//	String imageUrl = "/image/" +  uniqueFilename;; 
//	imageUrls.add(imageUrl);
//		}
//		
//	booking.setCustomerIdProof(imageUrls);
//
//	return this.bookingService.addBooking(booking);
//	}
	
	@PostMapping("/create")
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingService.createBooking(booking);
	}

	//private String generateUniqueFilename(String uploadDate, String originalFilename) {
			// TODO Auto-generated method stub
			//return null;
		//}

	//private boolean isValidImage(List<MultipartFile> file) {
		
//	private boolean isValidImage(MultipartFile file) {
//	// Get the file content type
//	String contentType = file.getContentType();
//	return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
//	}

		

//	private String generateUniqueFilename(String originalFilename) {
//	    // Extract the file extension
//	    String extension = "";
//	    if (originalFilename != null && originalFilename.lastIndexOf('.') > 0) {
//	        extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
//	    }
//	    
//	    // Set the current time stamp
//	    
//	  String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm-ss"));
//	  //DateTimeFormatter timestamp = DateTimeFormatter.ofPattern("HHmm");
//
//	    // Generate a UUID
//	    String uniqueID = UUID.randomUUID().toString();
//
//	    // Create a unique filename
//	    
//	    //return timestamp + "_" + uniqueID + extension;
//	   //return uploadDate + "_" + uniqueID + extension; // e.g., "14-12-2024_123e4567-e89b-12d3-a456-426614174000.jpg"
//	    return timestamp + "_" + uniqueID + extension;
//	}
//	
//	//@PostMapping("/booking")
//	//public Booking addBooking(@RequestBody Booking booking){
//		//System.out.print("Booking detais"+booking);
//		//return bookingService.addBooking(booking);
//		
//	//}
	
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking){
		
		
		try
		{
			
			Booking  savedBooking = bookingService.updateBooking(id, booking);
			return ResponseEntity.ok(savedBooking);
			
		}
		
		catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
			
		}}
		
		@DeleteMapping("deleteById/{id}")
		public ResponseEntity<Booking> deleteBooking(@PathVariable Long id){
			
			try
			{
				bookingService.findById(id);
				bookingService.deleteById(id);
				return ResponseEntity.noContent().build();
				
			}
			
			finally
			{
				
				return ResponseEntity.notFound().build();
			
			
				
			}
		}
		
	}


