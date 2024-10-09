package com.ms.jwt.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
 

import com.ms.jwt.models.RolePermission;
 
@Repository
public interface RolePermissionsRepository extends JpaRepository<RolePermission, Long> {
	
}
 
 
