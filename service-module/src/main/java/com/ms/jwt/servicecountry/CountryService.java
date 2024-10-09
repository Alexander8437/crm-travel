package com.ms.jwt.servicecountry;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.jwt.modelscountry.Country;
import com.ms.jwt.repository.country.CountryRepository;
@Service

public class CountryService {

	@Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
    	return countryRepository.findAll();
    }
        
    

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public Optional<Country> getCountryByMasterKey(String masterKey) {
        return countryRepository.findByMasterKey(masterKey);
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Long id, Country countryDetails) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            country.setCountryName(countryDetails.getCountryName());
            country.setCode(countryDetails.getCode());
            country.setC_image(countryDetails.getC_image());
            country.setStatus(countryDetails.getStatus());
            country.setIpAddress(countryDetails.getIpAddress());
            return countryRepository.save(country);
        } else {
            throw new RuntimeException("Country not found with id: " + id);
        }
    }
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
     }



	public Country addcountry(Country country) {
		// TODO Auto-generated method stub
		
		return countryRepository.save(country);
	}
}
