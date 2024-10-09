package com.ms.jwt.models.pkg;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
	 @JsonProperty("PackageInfo")
	 public PackageInfo packageInfo;
	   
	 //@Column(name = "itinerary_ids")
	    private List<Long> itineraryIds;
	 

	 public List<Long> getItineraryIds() {
			return itineraryIds;
		}
		public void setItineraryIds(List<Long> itineraryIds) {
			this.itineraryIds = itineraryIds;
		}
	public ArrayList<CustomField> customFields;
	 
	 public ArrayList<String> references;
	
	 public PackageInfo getPackageInfo() {
			return packageInfo;
		}
		public void setPackageInfo(PackageInfo packageInfo) {
			this.packageInfo = packageInfo;
		}
		 
		
		public ArrayList<CustomField> getCustomFields() {
			return customFields;
		}
		public void setCustomFields(ArrayList<CustomField> customFields) {
			this.customFields = customFields;
		}
		public ArrayList<String> getReferences() {
			return references;
		}
		public void setReferences(ArrayList<String> references) {
			this.references = references;
		}
		 
	    
	    
	    
}
