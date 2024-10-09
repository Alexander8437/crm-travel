package com.ms.jwt.models.pkg;

import javax.persistence.Embeddable;

@Embeddable
public class PackagePrice {
	
	private long price;
	
	private long gst;
	
	private long total_price;

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getGst() {
		return gst;
	}

	public void setGst(long gst) {
		this.gst = gst;
	}

	public long getTotal_price() {
		return total_price;
	}

	public void setTotal_price(long total_price) {
		this.total_price = total_price;
	}
	
	
}
