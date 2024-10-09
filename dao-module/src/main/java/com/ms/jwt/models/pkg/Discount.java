package com.ms.jwt.models.pkg;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Discount {
	private String type;
	private int value;
	private String conditions;

	@Embedded
	private Validity validity;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public Validity getValidity() {
		return validity;
	}

	public void setValidity(Validity validity) {
		this.validity = validity;
	}

}
