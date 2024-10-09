package com.ms.jwt.modelshotel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ms.jwt.models.destination.Destination;

//import com.ms.jwt.models.destination

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String hotel_name;
	
	private String countryname;
	
	@ElementCollection
	private List<String> image;
	
	private String state_name;
	
	private String city_name;
	
	private String room_type;
	
	private String room_size;
	
	private String bed_type;
	
	private String hotel_address;
	
	private Long pin_Code;
	
	private String rating;
	
	private String contact_number;
	
	private String email;
	
	private String description;
	
	private String amenities;
	
	private String ip_address;
	
	private boolean status;
	
//	private String destination_Name;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Destination destination;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getHotel_name() {
		return hotel_name;
	}


	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getCountryname() {
		return countryname;
	}


	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}


	public List<String> getImage() {
		return image;
	}


	public void setImage(List<String> image) {
		this.image = image;
	}



	public String getState_name() {
		return state_name;
	}


	public void setState_name(String state_name) {
		this.state_name = state_name;
	}


	public String getCity_name() {
		return city_name;
	}


	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}


	public String getRoom_type() {
		return room_type;
	}


	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}


	public String getRoom_size() {
		return room_size;
	}


	public void setRoom_size(String room_size) {
		this.room_size = room_size;
	}


	public String getBed_type() {
		return bed_type;
	}


	public void setBed_type(String bed_type) {
		this.bed_type = bed_type;
	}


	public String getHotel_address() {
		return hotel_address;
	}


	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}


	public Long getPin_Code() {
		return pin_Code;
	}


	public void setPin_Code(Long pin_Code) {
		this.pin_Code = pin_Code;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getContact_number() {
		return contact_number;
	}


	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAmenities() {
		return amenities;
	}


	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}


	public String getIp_address() {
		return ip_address;
	}


	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


//	public String getDestination_Name() {
//		return destination_Name;
//	}
//
//
//	public void setDestination_Name(String destination_Name) {
//		this.destination_Name = destination_Name;
//	}


	public Destination getDestination() {
		return destination;
	}


	public void setDestination(Destination destination) {
		this.destination = destination;
	}

			}