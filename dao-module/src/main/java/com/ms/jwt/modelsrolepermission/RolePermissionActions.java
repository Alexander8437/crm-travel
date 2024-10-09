package com.ms.jwt.modelsrolepermission;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ms.jwt.models.RolePermission;

@Entity
@Table(name = "role_permission_actions")
public class RolePermissionActions { // Changed to camel case
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @Column(nullable = false)
    private String action;
    
    
    @ManyToOne
    @JoinColumn(name = "role_permission_id",referencedColumnName="ID")
    @JsonBackReference
    private RolePermission rolePermission; // Changed to camel case
 // Constructor that accepts a String argument
    
    public RolePermissionActions() {
     
    }
    
    public RolePermissionActions(String action) {
        this.action = action;
    }
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RolePermission getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(RolePermission rolePermission) {
		this.rolePermission = rolePermission;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
   

}
