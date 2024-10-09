package com.ms.jwt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.jwt.models.booking.Booking;
import com.ms.jwt.models.pkg.PackageInfo;
import com.ms.jwt.modelshotel.Hotel;
import com.ms.jwt.pkg.PackageRepository;
import com.ms.jwt.repository.hotel.HotelServiceImpl;
import java.util.Comparator;





@Service
public class BookingService {

	
	@Autowired
	private BookingServiceImpl bookingServiceImpl;
	
	@Autowired
	private PackageRepository packageRepository;
	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
//	public  Booking addBooking(Booking booking) {
//		return bookingServiceImpl.save(booking);
//
//}

	public Booking updateBooking(Long id, Booking booking) {
		// TODO Auto-generated method stub
		return bookingServiceImpl.findById(id)
				
				.map(existingBooking -> {
		
		
		
		if(booking.getTravelDetails() != null) {
			existingBooking.setTravelDetails(booking.getTravelDetails());	
		}
		
		
		
		if(booking.getPaymentDetails() != null) {
			existingBooking.setPaymentDetails(booking.getPaymentDetails());
        }
		
		
		
		if(booking.getSpecialRequest() != null) {
			existingBooking.setSpecialRequest(booking.getSpecialRequest());
		}
		
		

		return bookingServiceImpl.save(existingBooking);
		})
				
				.orElseThrow(() -> new RuntimeException("Booking not Found"));
	

				
				
		
	
		}

	public void findById(Long id) {
		bookingServiceImpl.deleteById(id);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return bookingServiceImpl.findAll();
	}

	public Optional<Booking> getBookingById(Long id) {
		 //TODO Auto-generated method stub
		return bookingServiceImpl.findById(id);
}

	public List<Booking> findBookingsByUserId(Long bookingByUserId) {
    return bookingServiceImpl.findByBookingByUserId(bookingByUserId);
		
		//return bookingServiceImpl.findBookingByUserId(bookingByUserId);
    
	//@SuppressWarnings("rawtypes")
	//public Booking<Booking> getBookingById(Long id) {
		// TODO Auto-generated method stusb
		//return bookingServiceImpl.findById(id);
		//.orElseThrow(()   -> new RuntimeException("Booking Not Find"));
	
	
	}
	
	public List<Booking> getConfirmedBookingsByUserId(Long bookingByUserId) {
        return bookingServiceImpl.findByBookingByUserIdAndBookingStatusIgnoreCase(bookingByUserId, "Confirmed");
}
	
//	public List<Booking> getPendingBookings(Long bookingByUserId) {
//        return bookingServiceImpl.findByBookingByUserIdAndBookingStatus(bookingByUserId, "Pending");
//}}
	
	
	public List<Booking> getPendingBookingsByUserId(Long bookingByUserId) {
		return bookingServiceImpl.findByBookingByUserIdAndBookingStatusIgnoreCase(bookingByUserId, "Pending");
}

	
	
	public List<Booking> getCancleBookiByUserId(Long bookingByUserId) {
		return bookingServiceImpl.findByBookingByUserIdAndBookingStatusIgnoreCase(bookingByUserId, "Cancle");
	}
	
	
	
//	public List<Booking> getAllConfirmedBookings() {
//        return bookingServiceImpl.findByBookingStatusIgnoreCase("Confirmed");
//	}
//        
//	
//	
//	public List<Booking> getAllPendingBookings() {
//        return bookingServiceImpl.findByBookingStatusIgnoreCase("Pending");
//	}
	
	
	public List<Booking> getAllCancleBooking(String name){
		return bookingServiceImpl.findByBookingStatus(name);
		
	}

	public List<PackageInfo> getPackagesByDestinationId(Long destinationId) {
		return packageRepository.findByDestinationId(destinationId);
	}
	
	public List<Hotel> gethotelByDestinationIdAndRating(Long destinationId, String rating) {
		return hotelServiceImpl.findByDestinationIdAndRating(destinationId, rating);
	}

	public Booking createBooking(Booking booking) {
		return bookingServiceImpl.save(booking);
	}

	public Map<String, Long> getTopConfirmedDestinations(Long userId, int limit) {
	    List<Booking> confirmedBookings = bookingServiceImpl.findByBookingStatusAndBookingByUserId("Confirmed", userId);
 
	    // Count bookings by destination
	    Map<String, Long> to_destinationCount = confirmedBookings.stream()
	            .collect(Collectors.groupingBy(b -> b.getTo_destination(), Collectors.counting()));
 
	    // Sort and get the top destinations based on the limit
	    return to_destinationCount.entrySet().stream()
	            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
	            .limit(limit)  // Use the limit provided by the user
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}}
 
	  
 
	// By max destination
	

	
