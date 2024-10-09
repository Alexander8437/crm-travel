package com.ms.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ms.jwt.models.booking.Booking;


//import com.ms.jwt.entity.BookingByUser;

//import com.ms.jwt.entity.Booking;

@Repository
public interface BookingServiceImpl extends JpaRepository<Booking, Long> {

	
	
	
   List<Booking> findByBookingByUserId(Long bookingByUserId);
   
   
  // List<Booking> findByBookingByUserIdAndBooking_Status(Long bookingByUserId, String booking_Status);


List<Booking> findByBookingByUserIdAndBookingStatusIgnoreCase(Long bookingByUserId, String bookingStatus);



@Query("SELECT u FROM Booking u WHERE u.bookingStatus = :bookingStatus")
List<Booking> findByBookingStatus(String bookingStatus);


List<Booking> findByBookingStatusAndBookingByUserId(String string, Long userId);




//List<Booking> findAllConfirmedBookings();
//
//
//
////List<Booking> findByBookingStatus(String bookingStatus);
//@Query("SELECT u FROM Booking u WHERE u.bookingStatus = 'Pending'")
//List<Booking> findAllPendingBookings();
//
//
//
//@Query("SELECT u FROM Booking u WHERE u.bookingStatus = 'Cancle'")
//List<Booking> findAllCancleBookings();
//	
//	
}