package com.ms.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ms.jwt.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//	@Query("SELECT id FROM Role  WHERE Role.name = :name")
//	Role findByCustomName(String name);

	Role findByName(String role);
}
