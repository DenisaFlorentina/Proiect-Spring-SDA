package com.diainstalwater.diaInstalWater.repository;

import com.diainstalwater.diaInstalWater.model.Role;
import com.diainstalwater.diaInstalWater.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
//  Optional<User> findById(Long id);


/*
    User findAllById(Long id);

*/

  // new mai jos
  User save(User user);
  //User save(User user, Role role);
//  User save(UserDto user);
  List<User> findAll();

  //User findOne(String username);
}
