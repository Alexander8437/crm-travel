package com.ms.jwt.models.pkg;

import javax.persistence.Embeddable;

@Embeddable
public class Description {
    private String en;

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

     
}
