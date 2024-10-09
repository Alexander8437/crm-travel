package com.ms.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.jwt.models.Role;
import com.ms.jwt.models.RolePermission;
import com.ms.jwt.repository.RolePermissionsRepository;
import com.ms.jwt.repository.RoleRepository;
import com.ms.jwt.request_response.JwtResponse;
import com.ms.jwt.request_response.MessageResponse;
import com.ms.jwt.request_response.UtilMethod;
import com.ms.jwt.service.RoleService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("Motherson/crm/v1")
public class GSTController {

	@Autowired
	private RoleService genericService;
	
	@Autowired
	private RolePermissionsRepository rolePermissionsRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@PostMapping("/all")
	public ResponseEntity<MessageResponse> allAccess(@RequestBody String generic) {
		try {
			genericService.saveGeneric(generic);
			return ResponseEntity.ok(new MessageResponse("Successfully inserted"));
			
		}catch(DataIntegrityViolationException e) {
			
			return new ResponseEntity<>(new MessageResponse( UtilMethod.extractDetailMessage(e.getMostSpecificCause().getMessage())),HttpStatus.CONFLICT);
		}catch(Exception e) {
			 
			return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/rolesPermission")
	public ResponseEntity<?> getPermission(){
		return ResponseEntity.ok(roleRepository.findAll());
	}
	
	@GetMapping("/rolesPermission/{id}")
	public ResponseEntity<?> getRoleById(@PathVariable Long id){
		Optional<Role> permission =  roleRepository.findById(id);
		return ResponseEntity.ok(permission);
	}
	
	@GetMapping("/roles/{name}")
	public ResponseEntity<?> getRoleByName(@PathVariable String name){
		Role role = roleRepository.findByName(name);
		return ResponseEntity.ok(role);
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
