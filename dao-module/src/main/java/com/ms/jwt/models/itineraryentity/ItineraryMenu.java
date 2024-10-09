package com.ms.jwt.models.itineraryentity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Id;

@Embeddable
public class ItineraryMenu {
	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long itineraryId;
	
	private String title;
	
	private String startCity;
	
	private String destinationCity;
	
	private Integer day;	
	
	private String description;
	
	
//	@Embedded
//	private Activity activity;
//
//	@Embedded
//	private MealPlan mealPlan;
//	
//	@Embedded
//	private Transport transport;

	
	
	
//	public Long getItineraryId() {
//		return itineraryId;
//	}
//	public void setItineraryId(Long itineraryId) {
//		this.itineraryId = itineraryId;
//	}
	
	
	
//	public Activity getActivity() {
//		return activity;
//	}
//	public Long getItineraryId() {
//		return itineraryId;
//	}
//	public void setItineraryId(Long itineraryId) {
//		this.itineraryId = itineraryId;
//	}
//	public void setActivity(Activity activity) {
//		this.activity = activity;
//	}
//	public MealPlan getMealPlan() {
//		return mealPlan;
//	}
//	public void setMealPlan(MealPlan mealPlan) {
//		this.mealPlan = mealPlan;
//	}
//	public Transport getTransport() {
//		return transport;
//	}
//	public void setTransport(Transport transport) {
//		this.transport = transport;
//	}
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}