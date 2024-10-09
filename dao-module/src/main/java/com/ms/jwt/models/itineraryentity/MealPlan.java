package com.ms.jwt.models.itineraryentity;

import javax.persistence.Embeddable;

@Embeddable
public class MealPlan {
	
	private String breakfast;
	private String lunch;
	private String dinner;
	
	
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public String getBunch() {
		return lunch;
	}
	public void setBunch(String lunch) {
		this.lunch = lunch;
	}
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
}
	
	