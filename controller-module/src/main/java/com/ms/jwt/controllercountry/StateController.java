package com.ms.jwt.controllercountry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ms.jwt.modelscountry.Country;
import com.ms.jwt.modelscountry.State;
import com.ms.jwt.servicecountry.StateService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("Motherson/crm/v1/state")
public class StateController {
	  @Autowired
	    private StateService stateService;

	    @GetMapping("/get")
	    public ResponseEntity<List<State>> getAllStates() {
	        List<State> states = stateService.getAllStates();
	        return new ResponseEntity<>(states, HttpStatus.OK);
	    }

	    @GetMapping("/getid/{id}")
	    public ResponseEntity<State> getStateById(@PathVariable Long id) {
	        Optional<State> state = stateService.getStateById(id);
	        return state.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	    
	    @GetMapping("/getbycountryid/{cid}")
	    public List<State> getStateByCountryId(@PathVariable Long cid){
	        return stateService.getStateByCountryId(cid);
	    }

	    @GetMapping("/masterKey/{masterKey}")
	    public ResponseEntity<State> getStateByMasterKey(@PathVariable String masterKey) {
	        Optional<State> state = stateService.getStateByMasterKey(masterKey);
	        return state.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

//	    @PostMapping("/create")
//	    public ResponseEntity<State> createState(@Valid @RequestBody State state) {
//	        State savedState = stateService.createState(state);
//	        return new ResponseEntity<>(savedState, HttpStatus.CREATED);
//	    }
	     
 public static String uploadDirectory=System.getProperty("user.dir") + "/src/main/image/countryimage";
		
		@PostMapping("/createstate")
		 public State createstate(@ModelAttribute State state,
	             @RequestParam("image") MultipartFile file) throws IOException {
	// Validate file type
	if (!isValidImage(file)) {
	throw new IllegalArgumentException("File must be a JPEG or PNG image.");
	}
	 
	String originalFilename = file.getOriginalFilename();
	Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
	Files.write(fileNameAndPath, file.getBytes());
	String imageUrl = "/image/" + originalFilename;
	   state.setS_image(imageUrl);
	   
	   //hotel.setModify_Dt(LocalDateTime.now());
	 
	return this.stateService.createState(state);
	}
	 
	private boolean isValidImage(MultipartFile file) {
	// Get the file content type
	String contentType = file.getContentType();
	return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
	}
	 

	    @PutMapping("updatebyid/{id}")
	    public ResponseEntity<State> updateState(@PathVariable Long id, @RequestBody State stateDetails) {
	        try {
	            State updatedState = stateService.updateState(id, stateDetails);
	            return new ResponseEntity<>(updatedState, HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
	        stateService.deleteState(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
}
