package com.ms.jwt.models.pkg;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class TravelDate {

   
    private LocalDate startDte;
    private LocalDate endDte;
    private boolean available;

   

   

    public LocalDate getStartDte() {
		return startDte;
	}

	public void setStartDte(LocalDate startDte) {
		this.startDte = startDte;
	}

	public LocalDate getEndDte() {
		return endDte;
	}

	public void setEndDte(LocalDate endDte) {
		this.endDte = endDte;
	}

	public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
