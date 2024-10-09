package com.ms.jwt.models.booking;

import javax.persistence.Embeddable;

@Embeddable
public class SpecialRequest {
	
	
	//private String specialRequests;
	private Boolean additionalService;
	private Boolean travelInsurance;
	
//	public String getSpecialRequests() {
//		return specialRequests;
//	}
//	public void setSpecialRequests(String specialRequests) {
//		this.specialRequests = specialRequests;
//	}
	public Boolean getAdditionalService() {
		return additionalService;
	}
	public void setAdditionalService(Boolean additionalService) {
		this.additionalService = additionalService;
	}
	public Boolean getTravelInsurance() {
		return travelInsurance;
	}
	public void setTravelInsurance(Boolean travelInsurance) {
		this.travelInsurance = travelInsurance;
	}
}
	
	
	