package com.ms.jwt.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.jwt.models.Role;
import com.ms.jwt.models.RolePermission;
import com.ms.jwt.modelsrolepermission.RolePermissionActions;
import com.ms.jwt.repository.RolePermissionsActionsRepository;
import com.ms.jwt.repository.RolePermissionsRepository;
import com.ms.jwt.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository genericRepository;
	
	@Autowired
    private RolePermissionsActionsRepository rolePermissionRepository;


	@Autowired
    private RolePermissionsRepository rolePermissionActionsRepository;

    @Autowired
    private ObjectMapper objectMapper;
	
    
    @Transactional
	public void saveGeneric(String generic)throws IOException  {
    	
    	
    	JsonNode rootNode = objectMapper.readTree(generic);
        String roleName = rootNode.get("name").asText();

        // Create Role
        Role role = new Role();
        role.setName(roleName);

        // Iterate over permissions
        JsonNode permissionsNode = rootNode.get("permissions");
        List<RolePermission> rolePermissions = new ArrayList<>();

        for (JsonNode permissionNode : permissionsNode) {
            String module = permissionNode.get("module").asText();

            // Create RolePermission
            RolePermission rolePermission = new RolePermission();
            rolePermission.setModule(module);
            rolePermission.setRole(role);

            // Iterate over actions
            JsonNode actionsNode = permissionNode.get("actions");
            List<RolePermissionActions> actions = new ArrayList<RolePermissionActions>();

            for (JsonNode actionNode : actionsNode) {
                String action = actionNode.asText();

                // Create RolePermissionActions
                RolePermissionActions rolePermissionAction = new RolePermissionActions();
                rolePermissionAction.setAction(action);
                rolePermissionAction.setRolePermission(rolePermission);

                actions.add(rolePermissionAction);
            }

            rolePermission.setActions(actions);
            rolePermissions.add(rolePermission);
        }

        role.setPermissions(rolePermissions);
        genericRepository.save(role);
	}
}
