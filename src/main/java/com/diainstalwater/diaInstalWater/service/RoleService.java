package com.diainstalwater.diaInstalWater.service;

import com.diainstalwater.diaInstalWater.model.Role;
import com.diainstalwater.diaInstalWater.repository.RoleRepository;
import com.diainstalwater.diaInstalWater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    public Role createRole(Role role){
        return roleRepository.saveAndFlush(role);
    }

    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id){
        return roleRepository.findById(id).get();
    }

    public void deleteRoleById(Long id){
        roleRepository.deleteById(id);
    }

  /*  public void assignUsername(Long id){
        Role role = roleRepository.findById(id).orElse(null);
        User user = userRepository.findByUsername(
                role.getName());
        role.setName(user.getUsername());
        roleRepository.save(role);
    }*/

    /** Update a Role */
    public ResponseEntity<Object> updateRole(Long id, Role role) {
        if(roleRepository.findById(id).isPresent()){
            Role newRole = roleRepository.findById(id).get();
            newRole.setName(role.getName());
            Role savedRole = roleRepository.save(newRole);
            if(roleRepository.findById(savedRole.getId()).isPresent())
                return ResponseEntity.accepted().body("Role saved successfully");
            else return ResponseEntity.badRequest().body("Failed to update Role");

        } else return ResponseEntity.unprocessableEntity().body("Specified Role not found");
    }
}

