package com.ms.jwt.controllercountry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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
import com.ms.jwt.servicecountry.CountryService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("Motherson/crm/v1/country")
public class Controller {
	

	    @Autowired
	    private CountryService countryService;

	    @GetMapping("/get")
	    public ResponseEntity<List<Country>> getAllCountries() {
	        List<Country> countries = countryService.getAllCountries();
	        return new ResponseEntity<>(countries, HttpStatus.OK);
	    }

	    @GetMapping("/getid/{id}")
	    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
	        Optional<Country> country = countryService.getCountryById(id);
	        return country.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @GetMapping("/masterKey/{masterKey}")
	    public ResponseEntity<Country> getCountryByMasterKey(@PathVariable String masterKey) {
	        Optional<Country> country = countryService.getCountryByMasterKey(masterKey);
	        return country.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

//	    @PostMapping("/create")
//	    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
//	        Country savedCountry = countryService.createCountry(country);
//	        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
//	    }
	   
	    public static String uploadDirectory=System.getProperty("user.dir") + "/src/main/image/countryimage";
		
		@PostMapping("/createcountry")
		 public Country createcountry(@ModelAttribute Country country,
	             @RequestParam("image") MultipartFile file) throws IOException {
	// Validate file type
	if (!isValidImage(file)) {
	throw new IllegalArgumentException("File must be a JPEG or PNG image.");
	}
	 
	String originalFilename = file.getOriginalFilename();
	Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
	Files.write(fileNameAndPath, file.getBytes());
	String imageUrl = "/image/" + originalFilename;
	   country.setC_image(imageUrl);
	   
	   //hotel.setModify_Dt(LocalDateTime.now());
	 
	return this.countryService.addcountry(country);
	}
	 
	private boolean isValidImage(MultipartFile file) {
	// Get the file content type
	String contentType = file.getContentType();
	return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"));
	}
	 
	    @PutMapping("/updateby/{id}")
	    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country countryDetails) {
	        try {
	            Country updatedCountry = countryService.updateCountry(id, countryDetails);
	            return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/deleteby/{id}")
	    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
	        countryService.deleteCountry(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
