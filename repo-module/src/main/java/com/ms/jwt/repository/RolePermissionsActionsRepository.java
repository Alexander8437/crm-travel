package com.ms.jwt.repository;
import org.springframework.stereotype.Repository;

import com.ms.jwt.modelsrolepermission.RolePermissionActions;

import org.springframework.data.jpa.repository.JpaRepository;
 
@Repository
public interface RolePermissionsActionsRepository extends JpaRepository<RolePermissionActions, Long> {
	
}
 
