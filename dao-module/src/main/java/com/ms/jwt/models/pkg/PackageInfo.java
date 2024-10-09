package com.ms.jwt.models.pkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ms.jwt.models.destination.Destination;
import com.ms.jwt.models.itineraryentity.ItineraryPkg;

@Entity
@Table(name = "packages_Master")
public class PackageInfo {

    @Id
    private String id;

    private String name;
    private String code;

    @Embedded
    private Description description;

    @Embedded
    private Duration duration;

   // @OneToMany(mappedBy = "packageInfo", cascade = CascadeType.ALL)
   // @JsonManagedReference
//    @ElementCollection
//    private List<ItineraryPkg> itinerary;
// 
     
    private String inclusions;
    
    private String exclusions;

    @Embedded
    private Discount discount;
    
    
    @Embedded
    private PackagePrice packagePrice;
    
    @OneToMany(mappedBy = "packageInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public List<Medium> media;

    @Embedded
    private Metadata metadata;
    
    @Embedded
    private TravelDate travelDates;
    
    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private Destination destination;

   
    @Column(name = "itinerary_ids")
    private String itineraryIds;
    
   
public String getItineraryIds() {
		return itineraryIds;
	}

	public void setItineraryIds(String itineraryIds) {
		this.itineraryIds = itineraryIds;
	}
	 // Helper method to convert List<Long> to a comma-separated string
//    public void setItineraryIds(List<Long> itineraryIdList) {
//        this.itineraryIds = itineraryIdList.stream()
//                                           .map(String::valueOf)
//                                           .collect(Collectors.joining(","));
//    }
//
//    // Helper method to convert comma-separated string to List<Long>
//    public List<Long> getItineraryIdList() {
//        if (this.itineraryIds != null && !this.itineraryIds.isEmpty()) {
//            return Arrays.stream(this.itineraryIds.split(","))
//                         .map(Long::valueOf)
//                         .collect(Collectors.toList());
//        }
//        return null;
//    }

	//    // One-to-Many relationship with ItineraryPkg
//    @OneToMany(mappedBy = "packageInfo", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ItineraryPkg> itineraryPkgs;
//	
//	   public List<Long> getItineraryIdList() {
//	        return itineraryIds != null ? Arrays.stream(itineraryIds.split(","))
//	                .map(Long::parseLong)
//	                .toList() : null;
//	    }
//
//	    // Method to set itinerary IDs from List<Long>
//	    public void setItineraryIdList(List<Long> itineraryIdList) {
//	        this.itineraryIds = itineraryIdList.stream()
//	                .map(String::valueOf)
//	                .reduce((a, b) -> a + "," + b)
//	                .orElse(null);
//	    }
	 public List<Long> getItineraryIdList() {
	        return itineraryIds != null ? Arrays.stream(itineraryIds.split(","))
	                .map(Long::parseLong)
	                .toList() : List.of(); // Return an empty list instead of null
	    }

	    // Method to set itinerary IDs from List<Long>
	    public void setItineraryIdList(List<Long> itineraryIdList) {
	        if (itineraryIdList != null) {
	            this.itineraryIds = itineraryIdList.stream()
	                    .map(String::valueOf)
	                    .reduce((a, b) -> a + "," + b)
	                    .orElse(null); // This could also be an empty string if needed
	        } else {
	            this.itineraryIds = null; // Handle the null case if the input list is null
	        }
	    }
	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

//	public List<ItineraryPkg> getItinerary() {
//		return itinerary;
//	}

//	public void setItinerary(List<ItineraryPkg> itinerary) {
//	    this.itinerary = itinerary;
//	    if (itinerary != null) {
//	        for (ItineraryPkg it : itinerary) {
//	            it.setPackageInfo(this);
//	        }
//	    }
//	}

	 

	public List<Medium> getMedia() {
		return media;
	}

	public void setMedia(List<Medium> media) {
		this.media = media;
		if(media!=null) {
			for (Medium it : media) {
	            it.setPackageInfo(this);
	        }
		}
	}

	public String getInclusions() {
		return inclusions;
	}

	public void setInclusions(String inclusions) {
		this.inclusions = inclusions;
	}

	public String getExclusions() {
		return exclusions;
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

//	@Override
//	public String toString() {
//		return "PackageInfo [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description
//				+ ", duration=" + duration + ", itinerary=" + itinerary + ", inclusions=" + inclusions + ", exclusions="
//				+ exclusions + ", discount=" + discount + ", metadata=" + metadata + ", getId()=" + getId()
//				+ ", getName()=" + getName() + ", getCode()=" + getCode() + ", getDescription()=" + getDescription()
//				+ ", getDuration()=" + getDuration() + ", getItinerary()=" + getItinerary() + ", getInclusions()="
//				+ getInclusions() + ", getExclusions()=" + getExclusions() + ", getDiscount()=" + getDiscount()
//				+ ", getMetadata()=" + getMetadata() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
//				+ ", toString()=" + super.toString() + "]";
//	}

	public TravelDate getTravelDates() {
		return travelDates;
	}

	public void setTravelDates(TravelDate travelDates) {
		this.travelDates = travelDates;
	}

	public PackagePrice getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(PackagePrice packagePrice) {
		this.packagePrice = packagePrice;
	}
	
	

    
}
