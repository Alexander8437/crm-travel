package com.ms.jwt.models.booking;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.ms.jwt.models.destination.Destination;

@Embeddable
public class TravelDetails {
	
	
	//private Long packageId;
	
	
	@Column(name="packageName",nullable=false)
	private String packageName;
	
	
	
	@Column(name="StartDate", nullable=false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;
	
	@Column(name="EndDate", nullable=false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;
	
	@Column(name="NumberOfDays", nullable=false)
	private Integer numberOfDays;
	
	
	@Column(name="NumberOfNights", nullable=false)
	private Integer numberOfNights;
	
	
	@Column(name="NumberOfGuests", nullable=false)
	private Integer numberOfGuests;
	
	@Column(name="NumberOfRoom", nullable=false)
	private Integer numberOfRoom;
	
	
	private boolean flight;


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	



	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public Integer getNumberOfDays() {
		return numberOfDays;
	}


	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}


	public Integer getNumberOfNights() {
		return numberOfNights;
	}


	public void setNumberOfNights(Integer numberOfNights) {
		this.numberOfNights = numberOfNights;
	}


	public Integer getNumberOfGuests() {
		return numberOfGuests;
	}


	public void setNumberOfGuests(Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}


	public Integer getNumberOfRoom() {
		return numberOfRoom;
	}


	public void setNumberOfRoom(Integer numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}


	public boolean isFlight() {
		return flight;
	}


	public void setFlight(boolean flight) {
		this.flight = flight;
	}


	public Object getTo_Destination() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
	
	
	
	
}