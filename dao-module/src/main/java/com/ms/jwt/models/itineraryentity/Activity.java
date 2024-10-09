package com.ms.jwt.models.itineraryentity;

import javax.persistence.Embeddable;

@Embeddable
public class Activity {
	
	
	private Long activityId;
	private String activityName;
	
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	

}
