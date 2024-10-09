package com.ms.jwt.models.booking;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ms.jwt.models.destination.Destination;

@Entity
public class Booking {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String bookingStatus;
	
	private Long bookingByUserId;
	
	private String bookingByUserName;
	
	@Column(name="From_Destination",nullable=false)
	private String from_Destination;
	

	//private String todestination;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="destination_id", nullable=false)
	@JsonBackReference
	private Destination to_Destination;
	
	public String to_destination;
	
	public String getTo_destination() {
		return to_destination;
	}


	public void setTo_destination(String to_destination) {
		this.to_destination = to_destination;
	}


	public Long getBookingByUserId() {
		return bookingByUserId;
	}


	public void setBookingByUserId(Long bookingByUserId) {
		this.bookingByUserId = bookingByUserId;
	}


	public String getBookingByUserName() {
		return bookingByUserName;
	}


	public void setBookingByUserName(String bookingByUserName) {
		this.bookingByUserName = bookingByUserName;
	}


	public String getBookingStatus() {
		return bookingStatus;
	}
	


//	public Destination getDestination() {
//		return destination;
//	}
//
//
//	public void setDestination(Destination destination) {
//		this.destination = destination;
//	}




	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


//	@Column(name="customer_id_proof", nullable=false)
//	@ElementCollection
//	private List<String> customerIdProof;
	
	

	
	
	
	public String getFrom_Destination() {
		return from_Destination;
	}


	public void setFrom_Destination(String from_Destination) {
		this.from_Destination = from_Destination;
	}




//	public List<String> getCustomerIdProof() {
//		return customerIdProof;
//	}
//
//
//	public void setCustomerIdProof(List<String> customerIdProof) {
//		this.customerIdProof = customerIdProof;
//	}


	public Destination getTo_Destination() {
		return to_Destination;
	}


	public void setTo_Destination(Destination to_Destination) {
		this.to_Destination = to_Destination;
	}




	@Embedded
	private TravelDetails travelDetails;
	
	
	
	@Embedded
	private PaymentDetails paymentDetails;
	
	
	
	@Embedded
	private SpecialRequest specialRequest;
	
	
	
	private Long cust_Id;

	
  


	public Long getCust_Id() {
		return cust_Id;
	}


	public void setCust_Id(Long cust_Id) {
		this.cust_Id = cust_Id;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}



	public TravelDetails getTravelDetails() {
		return travelDetails;
	}


	public void setTravelDetails(TravelDetails travelDetails) {
		this.travelDetails = travelDetails;
	}


	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}


	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}


	public SpecialRequest getSpecialRequest() {
		return specialRequest;
	}


	public void setSpecialRequest(SpecialRequest specialRequest) {
		this.specialRequest = specialRequest;
	}


	}


	
	

	


	