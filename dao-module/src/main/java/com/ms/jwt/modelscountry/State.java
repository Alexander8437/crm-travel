package com.ms.jwt.modelscountry;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//3import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import net.minidev.json.annotate.JsonIgnore;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "state_master")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "state name is required")
	@Size(min = 2, max = 30, message = "state name must be between 2 and 30 characters")
	@Column(name = "state_Name", nullable = false)
	private String stateName;

	@NotBlank(message = "State code is required")
	@Pattern(regexp = "^[A-Z]{2,3}$", message = "State code must be 2 to 3 uppercase letters")
	private String code;
	
	
	private String status;

	@NotBlank(message = "Ipaddress is required")
	// @Pattern(regexp = "^([0-9]{1,3}\\.){3}[0-9]{1,3}$", message = "Invalid IP
	// address format")
	private String ipAddress;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "country_id", nullable = false)
	// @JsonBackReference
// @JsonIgnore
	
	// @JsonIgnore
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	@JsonBackReference
	private Country country;

	//@ElementCollection

	// @Column(name="state_image")
	private String s_image;

	
//	public List<String> getS_image() {
//		return s_image;
//	}
//
//	public void setS_image(List<String> s_image) {
//		this.s_image = s_image;
//	}

	@Column(name = "master_key", unique = true)
	private String masterKey;

	// Constructors, Getters, and Setters

	public String getS_image() {
		return s_image;
	}

	public void setS_image(String s_image) {
		this.s_image = s_image;
	}

	@PrePersist
	public void generateMasterKey() {
		this.masterKey = "STATE-" + this.code + "-" + UUID.randomUUID().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getMasterKey() {
		return masterKey;
	}

	public void setMasterKey(String masterKey) {
		this.masterKey = masterKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
