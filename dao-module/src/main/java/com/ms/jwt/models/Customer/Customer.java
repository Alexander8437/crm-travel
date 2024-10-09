package com.ms.jwt.models.Customer;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 

 
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	@Column(name="Cust_Name",nullable=false)
	private String cust_Name;
	
	
	private String cust_Email;
	
	@Column(name="Cust_Phone",nullable=false)
	private String cust_Phone;
	
	//@Column(name="StateName",nullable=false)
	private String reg_No;
 
	private boolean status;
	
	
	@Column(name="Cust_Address",nullable=false)
	private String cust_Address;
	
	private String emergency_Contact;
	
	private String marital_Status;
	
	private String lead_Source;
 
	public long getId() {
		return id;
	}
 
	public void setId(long id) {
		this.id = id;
	}
 
	public String getCust_Name() {
		return cust_Name;
	}
 
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
 
	public String getCust_Email() {
		return cust_Email;
	}
 
	public void setCust_Email(String cust_Email) {
		this.cust_Email = cust_Email;
	}
 
	public String getCust_Phone() {
		return cust_Phone;
	}
 
	public void setCust_Phone(String cust_Phone) {
		this.cust_Phone = cust_Phone;
	}
 
	public String getReg_No() {
		return reg_No;
	}
 
	public void setReg_No(String reg_No) {
		this.reg_No = reg_No;
	}
 
	public boolean isStatus() {
		return status;
	}
 
	public void setStatus(boolean status) {
		this.status = status;
	}
 
	public String getCust_Address() {
		return cust_Address;
	}
 
	public void setCust_Address(String cust_Address) {
		this.cust_Address = cust_Address;
	}
 
	public String getEmergency_Contact() {
		return emergency_Contact;
	}
 
	public void setEmergency_Contact(String emergency_Contact) {
		this.emergency_Contact = emergency_Contact;
	}
 
	public String getMarital_Status() {
		return marital_Status;
	}
 
	public void setMarital_Status(String marital_Status) {
		this.marital_Status = marital_Status;
	}

	public String getLead_Source() {
		return lead_Source;
	}

	public void setLead_Source(String lead_Source) {
		this.lead_Source = lead_Source;
	}
 
	
 
}
 