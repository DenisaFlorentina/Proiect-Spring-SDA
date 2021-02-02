package com.diainstalwater.diaInstalWater.service;

//import com.diainstalwater.diaInstalWater.model.Role;
import com.diainstalwater.diaInstalWater.model.Role;
import com.diainstalwater.diaInstalWater.model.User;
import com.diainstalwater.diaInstalWater.repository.RoleRepository;
import com.diainstalwater.diaInstalWater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    // am facut nou toata clasa
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;
    //create
    public Role createRole(Role newRole){
        return roleRepository.saveAndFlush(newRole);
    }
    //findAllRoles
    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }
    //findRoleById
    public Role getRoleById(Long id){
        return roleRepository.findById(id).get();
    }

      //deleteRole
    public void deleteRoleById(Long id){
        roleRepository.deleteById(id);
    }

   /* public void assignUsername(Long id){
        Role role = roleRepository.findById(id).orElse(null);
        User user = userRepository.findByUsername(
                role.getName());
        role.setName(user.getUsername());
        roleRepository.save(role);
    }*/
}

