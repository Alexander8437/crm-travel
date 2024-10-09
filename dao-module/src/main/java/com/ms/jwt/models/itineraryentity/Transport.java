package com.ms.jwt.models.itineraryentity;

import javax.persistence.Embeddable;
  
@Embeddable
public class Transport {

	
	private String transportType;
	
	
	public String getTrsnportType() {
		return transportType;
	}

	public void setTrsnportType(String trsnportType) {
		this.transportType = trsnportType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	private String details;
	
}
