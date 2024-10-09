package com.ms.jwt.models.pkg;
import javax.persistence.Embeddable;

@Embeddable
public class CustomField {
	private String promoCode;
	private String specialInstructions;

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

}
