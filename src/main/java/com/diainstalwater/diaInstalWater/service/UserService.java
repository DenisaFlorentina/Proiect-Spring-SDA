package com.diainstalwater.diaInstalWater.service;

import com.diainstalwater.diaInstalWater.model.Role;
import com.diainstalwater.diaInstalWater.model.User;
import com.diainstalwater.diaInstalWater.repository.RoleRepository;
import com.diainstalwater.diaInstalWater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

// metoda initiala
   /*public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }*/


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }


    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("USER");
        List<Role> roleSet = new ArrayList<>();
        roleSet.add(role);
        //  if(user.getUsername().equals("admin")){
        //if ((user.getUsername().startsWith("admin")) || (roleSet.contains("ADMIN"))) {


        if (user.getUsername().startsWith("admin")){
            role = roleRepository.findByName("ADMIN");
           roleSet.add(role);


        }
        user.setRoles(roleSet);
        userRepository.saveAndFlush(user);
    }

   /* public void assignRolename(User user) {
        // User user = userRepository.findById(id).orElse(null);
        Role role = roleRepository.findByName(user.getUsername());
        user.setUsername(role.getName());
        userRepository.saveAndFlush(user);
    }*/

    /**
     * Update an Existing User
     */


    @Transactional
    public User updateUser(User user, Long id) {
        User newUser = userRepository.findById(id).get();
        if (userRepository.findById(id).isPresent()) {
            newUser.setFirstname(user.getFirstname());
            newUser.setLastname(user.getLastname());
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setRoles(user.getRoles());
          //  User savedUser = userRepository.save(newUser);
//            if(userRepository.findById(savedUser.getId()).isPresent())
//                return  ResponseEntity.accepted().body("User updated successfully");
//            else return ResponseEntity.unprocessableEntity().body("Failed updating the user specified");
//        } else return ResponseEntity.unprocessableEntity().body("Cannot find the user specified");
        }
        return  userRepository.save(newUser);

    }
}





