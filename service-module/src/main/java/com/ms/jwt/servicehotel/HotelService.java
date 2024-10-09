package com.ms.jwt.servicehotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.jwt.modelshotel.Hotel;
import com.ms.jwt.repository.hotel.HotelServiceImpl;




@Service
public class HotelService {
	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	public Hotel addHotel(Hotel hotel) {
		
		return hotelServiceImpl.save(hotel);
	}

	public Hotel updateHotels(Hotel h) {
		// TODO Auto-generated method stub
		
		return hotelServiceImpl.save(h);
		
		
		
	}

	public Hotel findById(long id) {
		// TODO Auto-generated method stub
		return null ;
		
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		hotelServiceImpl.deleteById(id);
		
	}

	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelServiceImpl.findAll();
	}

	public List<Hotel> getHotelByDestinationId(Long destinationId) {
		// TODO Auto-generated method stub
		return hotelServiceImpl.findByDestinationId(destinationId);
	}

	public Optional<Hotel> getHotelById(Long id) {
		return hotelServiceImpl.findById(id);
	}

	//private Hotel hotelServiceImpl(Hotel h) {
		// TODO Auto-generated method stub
		//return null;
	}


