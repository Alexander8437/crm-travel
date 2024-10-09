package com.ms.jwt.models.destination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.List;
//import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
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
import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
//import javax.persistence.PostPersist;
//import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ms.jwt.models.KeyAttraction.KeyAttraction;
import com.ms.jwt.models.booking.Booking;
import com.ms.jwt.models.itineraryentity.ItineraryPkg;
import com.ms.jwt.modelscountry.Country;
import com.ms.jwt.modelscountry.State;

//import com.ms.jwt.modelscountry.Country;

//import com.ms.jwt.modelscountry.Country;

//import com.ms.jwt.modelscountry.Country;

@Entity
@Table(name="Destination_master")
@JsonIgnoreProperties(value = {  
		})
public class Destination {
   
	private static final String code = null;
	 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Destination is required")
	@Size(max=300,message = "Destination should not exceed 300 characters")
	@Column(name="destination_name")
	private String destinationName;

	@NotBlank(message="descripation is required")
	@Size(max=300,message = "Description should not exceed 300 characters")
	@Column(name="Descripation")
	private String descripation;
	
	
	
 
 
	// @ElementCollection
	// @NotEmpty(message= "atlest one keyAttraction is required")
	
	// @CollectionTable(name = "destination_key_attractions", joinColumns = @JoinColumn(name = "destination_id"))
	// @MapKeyColumn(name = "key_attraction")
	   // @Column(name = "master_key")
	//   @Column(name = "key_attraction")
	
	
	
	@NotBlank(message="status is required")
	@Column(name="Status")
	private String status;
	
//	@ElementCollection
//    @CollectionTable(name = "destination_images", joinColumns = @JoinColumn(name = "destination_id"))
//    @Column(name = "image_url")
	@NotEmpty(message="atlest one image url is required")
	private String d_image;
	
	
	
 
public String getD_image() {
		return d_image;
	}

	public void setD_image(String d_image) {
		this.d_image = d_image;
	}

	//	@ManyToOne(fetch = FetchType.LAZY)
	// @JsonIgnore
//	   	@JsonBackReference
	@JoinColumn(name = "country_id", nullable = false)
	    @ManyToOne(fetch = FetchType.EAGER)
	    private Country country;
	
	   	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
	   	@JsonManagedReference
	    private List< KeyAttraction >keyAttractions;
 
	
//	 @ManyToOne(fetch = FetchType.LAZY, optional = false)  // Foreign key reference to State
	    @JoinColumn(name = "s_id", nullable = false)  // This will be the foreign key column in the Destination table
	    @ManyToOne(fetch = FetchType.EAGER)
	    private State state;
	    
	    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JsonManagedReference
	    private List<ItineraryPkg> itineraries;
	    
	    @OneToMany(mappedBy = "to_Destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JsonManagedReference
	    private List<Booking> booking;
	    
	    public List<ItineraryPkg> getItineraries() {
			return itineraries;
		}

		public void setItineraries(List<ItineraryPkg> itineraries) {
			this.itineraries = itineraries;
		}

		

	
 
	
 
	public List<Booking> getBooking() {
			return booking;
		}

		public void setBooking(List<Booking> booking) {
			this.booking = booking;
		}

	public State getState() {
		return state;
	}
 
	public void setState(State state) {
		this.state = state;
	}
 
	public List<KeyAttraction> getKeyAttractions() {
	return keyAttractions;
	}
 
	public void setKeyAttractions(List<KeyAttraction> keyAttractions) {
		this.keyAttractions = keyAttractions;
	}
 
	public Country getCountry() {
		return country;
	}
 
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
//   public void addKeyAttraction(String keyAttraction) {
//        String masterKey = "KA-" + UUID.randomUUID().toString();
//       this.keyAttraction.add(masterKey + ": " + keyAttraction);
//    }
 
	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	private String masterkey;
	  @PrePersist
	    public void generateMasterKey() {
	        this.masterkey = "STATE-" + this.code+ "-" + UUID.randomUUID().toString();
	    }
 
//	public List<String> getKeyAttraction() {
//		return keyAttraction;
//	}
 
//	public void setKeyAttraction(List<String> keyAttraction) {
//		this.keyAttraction = keyAttraction;
//	}
 
	
 
//	public Map<String, String> getKeyAttractionsWithMasterKey() {
//		return keyAttractionsWithMasterKey;
//	}
//
//	public void setKeyAttractionsWithMasterKey(Map<String, String> keyAttractionsWithMasterKey) {
//		this.keyAttractionsWithMasterKey = keyAttractionsWithMasterKey;
//	}
 
	public String getMasterkey() {
		return masterkey;
	}
 
	public void setMasterkey(String masterkey) {
		this.masterkey = masterkey;
	}
 
	public static String getCode() {
		return code;
	}
 
	
 
	
	
	
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	
 
	public String getDescripation() {
		return descripation;
	}
 
	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}
 
	
	
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
	
 
	
	
	
 
}
 
 

