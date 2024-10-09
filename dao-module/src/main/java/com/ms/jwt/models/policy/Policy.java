package com.ms.jwt.models.policy;

import java.time.LocalDateTime;
//import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Policy {
	
	@Id
	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	 
	@Column(nullable=false)
	@NotBlank(message="policy name is required")
	@Size(max=100,message="policy name should not exceed 100 characters")
	private String policyName;
	
	//@Column(nullable=false)
	//@Lob 
	@NotBlank(message="policy description is required")
	 @Column(columnDefinition = "TEXT")
	private String policyDescription;
	//@Lob   //use to store large content 
	
//	@Column(nullable=false)
//	private String policyContent;
	
	 @NotBlank(message="created by is required")
	private String  createdBy;
	
	private LocalDateTime lastUpdated;
	
	@NotBlank(message= "status is required")
	private String status;
	
	//private int version;
	
//	@ElementCollection
//	private List<String>tags;
	
	private LocalDateTime effectiveDate;
	 
	private String masterKey;
	
	public String getMasterKey() {
		return masterKey;
	}

	public void setMasterKey(String masterKey) {
		this.masterKey = masterKey;
	}

	@PrePersist
	public void generateMasterKey()
	{
		this.masterKey= "MK-" + UUID.randomUUID().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyDescription() {
		return policyDescription;
	}

	public void setPolicyDescription(String policyDescription) {
		this.policyDescription = policyDescription;
	}

//	public String getPolicyContent() {
//		return policyContent;
//	}
//
//	public void setPolicyContent(String policyContent) {
//		this.policyContent = policyContent;
//	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}

//	public List<String> getTags() {
//		return tags;
//	}
//
//	public void setTags(List<String> tags) {
//		this.tags = tags;
//	}

	public LocalDateTime getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDateTime effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	
	
	
	

}
