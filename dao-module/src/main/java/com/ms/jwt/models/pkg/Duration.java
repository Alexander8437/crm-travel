package com.ms.jwt.models.pkg;

import javax.persistence.Embeddable;
@Embeddable
public class Duration {
    private int days;
    private int nights;
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getNights() {
		return nights;
	}
	public void setNights(int nights) {
		this.nights = nights;
	}

    
}