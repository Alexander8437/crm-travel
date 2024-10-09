package com.ms.jwt.models.KeyAttraction;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ms.jwt.models.destination.Destination;

//import com.ms.jwt.destinationmodels.Destination;

@Entity
@Table(name="Key_attraction")
public class KeyAttraction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	//@Column(name="Name")
	//private String name;
	//@Column(name="keyattration")
	// @ElementCollection
	@Column(name="key_attraction_name")
	@NotBlank(message="keyAttraction name is reqired")
	@Size(min=2,max=50,message="keyAttraction name  must be  between 2 to 50  characters  ")
	    private String keyAttractionName;

	   
	  @ManyToOne
	    @JoinColumn(name = "destination_id")
	  @JsonBackReference
	    private Destination destination;
	

	
//	private Destination destination;

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

//	public List<String> getKeyAttractionName() {
//		return keyAttractionName;
//	}
//
//	public void setKeyAttractionName(List<String> keyAttractionName) {
//		this.keyAttractionName = keyAttractionName;
//	}

	public Long getId() {
		return id;
	}

	public String getKeyAttractionName() {
		return keyAttractionName;
	}

	public void setKeyAttractionName(String keyAttractionName) {
		this.keyAttractionName = keyAttractionName;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	
//	public void setDestination(Destination destination) {
//		this.destination = destination;
//	}

}
