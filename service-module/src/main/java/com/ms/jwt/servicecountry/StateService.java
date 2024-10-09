package com.ms.jwt.servicecountry;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.jwt.modelscountry.State;
import com.ms.jwt.repository.country.StateRepository;

@Service

public class StateService {
	  @Autowired
	  
	    private StateRepository stateRepository;

	    public List<State> getAllStates() {
	        return stateRepository.findAll();
	    }

	    public Optional<State> getStateById(Long id) {
	        return stateRepository.findById(id);
	    }

	    public Optional<State> getStateByMasterKey(String masterKey) {
	        return stateRepository.findByMasterKey(masterKey);
	    }

	    public State createState(State state) {
	        return stateRepository.save(state);
	    }

	    public State updateState(Long id, State stateDetails) {
	        Optional<State> optionalState = stateRepository.findById(id);
	        if (optionalState.isPresent()) {
	            State state = optionalState.get();
	            state.setStateName(stateDetails.getStateName());
	            state.setCode(stateDetails.getCode());
	            state.setS_image(stateDetails.getS_image());
	            state.setIpAddress(stateDetails.getIpAddress());
	            state.setCountry(stateDetails.getCountry());
	            return stateRepository.save(state);
	        } else {
	            throw new RuntimeException("State not found with id: " + id);
	        }
	    }

	    public void deleteState(Long id) {
	        stateRepository.deleteById(id);
	    }

		public List<State> getStateByCountryId(Long cid) {
			return stateRepository.findByCountryId(cid);
		}
}
