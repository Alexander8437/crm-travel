package com.ms.jwt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ms.jwt.modelsrolepermission.RolePermissionActions;

@Entity
@Table(name = "role_permissions")
public class RolePermission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String module;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Role role;


	@OneToMany(mappedBy = "rolePermission", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RolePermissionActions> actions;

	
	
	public RolePermission() {
	} // Add this default constructor

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<RolePermissionActions> getActions() {
		return actions;
	}

	public void setActions(List<RolePermissionActions> actions) {
		this.actions = actions;
	}

	// Getters and Setters (optional, depending on your usage)

}
