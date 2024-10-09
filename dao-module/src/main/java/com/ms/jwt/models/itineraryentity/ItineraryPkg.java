package com.ms.jwt.models.itineraryentity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;

//import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ms.jwt.models.destination.Destination;
import com.ms.jwt.models.pkg.PackageInfo;

@Entity
@Table(name="itinerary_master")
public class ItineraryPkg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    @JsonBackReference
    private Destination destination;

//	@Embedded
//	private Activity activity;
//
	//@ElementCollection
//	private List<itineraryMenuitineraryMenu
	
	@Embedded
	private ItineraryMenu itineraryMenu;
	
	@Embedded
	private Activity activity;

	@Embedded
	private MealPlan mealPlan;
	
	@Embedded
	private Transport transport;
	
	
	private  String i_image;
	
//    @ManyToOne
//    @JoinColumn(name = "package_info_id") // Foreign key column in the ItineraryPkg table
//    @JsonBackReference
//    private PackageInfo packageID;
	
//	 @ManyToOne
//	    @JoinColumn(name = "package_id")  // Change the foreign key column name here
//	    private PackageInfo packageInfo;
	
	
//
//	@Embedded
//	private MealPlan mealPlan;
//	
//	@Embedded
//	private Transport transport;
	
	// @JoinColumn(name = "package_info_id")
// @ManyToOne
//	 @JoinColumn(name = "package_info_id", nullable = false)
//	 private PackageInfo PackageInfo;



	
	

//	public Transport getTransport() {
//		return transport;
//	}

	

//	public PackageInfo getPackageInfo() {
//		return PackageInfo;
//	}
//
//	public void setPackageInfo(PackageInfo packageInfo) {
//		PackageInfo = packageInfo;
//	}
	
//	public String getDestinationName() {
//		return destinationName;
//	}
//
//	public void setDestinationName(String destinationName) {
//		this.destinationName = destinationName;
//	}




	
	

	public Activity getActivity() {
		return activity;
	}

//	public PackageInfo getPackageID() {
//		return packageID;
//	}
//
//	public void setPackageID(PackageInfo packageID) {
//		this.packageID = packageID;
//	}

	public String getI_image() {
		return i_image;
	}

	public void setI_image(String i_image) {
		this.i_image = i_image;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public MealPlan getMealPlan() {
		return mealPlan;
	}

	public void setMealPlan(MealPlan mealPlan) {
		this.mealPlan = mealPlan;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItineraryMenu getItineraryMenu() {
		return itineraryMenu;
	}

	public void setItineraryMenu(ItineraryMenu itineraryMenu) {
		this.itineraryMenu = itineraryMenu;
	}

	
	
}
	
	
	
	

	
	
	
	