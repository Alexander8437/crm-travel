package com.ms.jwt.models.pkg;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Validity {

    @Temporal(TemporalType.DATE)
    private Date discount_startDate;

    @Temporal(TemporalType.DATE)
    private Date discount_endDate;

	public Date getDiscount_startDate() {
		return discount_startDate;
	}

	public void setDiscount_startDate(Date discount_startDate) {
		this.discount_startDate = discount_startDate;
	}

	public Date getDiscount_endDate() {
		return discount_endDate;
	}

	public void setDiscount_endDate(Date discount_endDate) {
		this.discount_endDate = discount_endDate;
	}

	

     
}