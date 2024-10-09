package com.ms.jwt.repository.country;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.jwt.modelscountry.State;

@Repository
public interface StateRepository extends JpaRepository<State,Long>

{
	
	Optional<State> findByMasterKey(String masterKey);

	List<State> findByCountryId(Long country_id);

	//State findByMasterkey(String masterkey);
	
}
