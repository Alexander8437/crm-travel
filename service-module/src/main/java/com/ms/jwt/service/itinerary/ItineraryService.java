package com.ms.jwt.service.itinerary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.jwt.models.itineraryentity.ItineraryMenu;
import com.ms.jwt.models.itineraryentity.ItineraryPkg;



@Service
public class ItineraryService {
	
	@Autowired
	private ItineraryServiceImpl itineraryServiceImpl;

	
	
	public ItineraryPkg addItinerary(ItineraryPkg itinerary) {
		return itineraryServiceImpl.save(itinerary);
	}

	public List<ItineraryPkg> getAllItinerary() {
		return itineraryServiceImpl.findAll();
	}

	public Optional<ItineraryPkg> getItineraryById(Long id) {
		return itineraryServiceImpl.findById(id);
	}

	public void findById(Long id) {
		
		itineraryServiceImpl.deleteById(id);
		
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

//    public ItineraryPkg updateItinerary(Long id, ItineraryPkg itinerary) {
//        return itineraryServiceImpl.findById(id)
//                .map(existingItinerary -> {
//                    // Update the list of ItineraryMenu if provided
//                    if (itinerary.getItineraryMenu() != null && !itinerary.getItineraryMenu().isEmpty()) {
//                        List<ItineraryMenu> newMenus = itinerary.getItineraryMenu();
//                        List<ItineraryMenu> existingMenus = existingItinerary.getItineraryMenu();
//
//                        // Clear existing menus and update with new ones
//                        existingMenus.clear();
//                        existingMenus.addAll(newMenus);
//
//                        // Optionally update each ItineraryMenu individually
//                        for (int i = 0; i < newMenus.size(); i++) {
//                            ItineraryMenu newMenu = newMenus.get(i);
//                            ItineraryMenu existingMenu = existingMenus.get(i);
//
//                            // Update Activity inside each ItineraryMenu
//                            if (newMenu.getActivity() != null) {
//                                existingMenu.setActivity(newMenu.getActivity());
//                            }
//
//                            // Update MealPlan inside each ItineraryMenu
//                            if (newMenu.getMealPlan() != null) {
//                                existingMenu.setMealPlan(newMenu.getMealPlan());
//                            }
//
//                            // Update Transport inside each ItineraryMenu
//                            if (newMenu.getTransport() != null) {
//                                existingMenu.setTransport(newMenu.getTransport());
//                            }
//                        }
//                    }
//
//                    return itineraryServiceImpl.save(existingItinerary);
//                })
//                .orElseThrow(() -> new RuntimeException("Itinerary not found"));
//    }


	public ItineraryPkg updateItinerary(Long id, ItineraryPkg itinerary) {
		// TODO Auto-generated method stub
		return itineraryServiceImpl.findById(id)
				.map(existingItinerary -> {
					
					if(itinerary.getItineraryMenu() != null) {
						existingItinerary.setItineraryMenu(itinerary.getItineraryMenu());
						
					}
					
					if(itinerary.getActivity() !=null) {
						existingItinerary.setActivity(itinerary.getActivity());
						
					}
					
					if(itinerary.getMealPlan() != null) {
						existingItinerary.setMealPlan(itinerary.getMealPlan());
					}
					return itineraryServiceImpl.save(existingItinerary);
				})
				.orElseThrow(() -> new RuntimeException("Itinerary not found"));
	}

	public List<ItineraryPkg> getDestinationById(Long did) {
		return itineraryServiceImpl.findByDestinationId(did);
	}
 
	
 
	//public void updateItinerary(Long id, Itinerary it) {
		// TODO Auto-generated method stub
		
	//}
	
	
 
 
 
	
	
}
