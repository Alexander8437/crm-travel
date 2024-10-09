package com.ms.jwt.repository.policy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.jwt.models.policy.Policy;

@Repository

public interface policyRepository extends JpaRepository<Policy ,Long> {
  
	Optional<Policy>findBymasterKey(String masterkey);
}
