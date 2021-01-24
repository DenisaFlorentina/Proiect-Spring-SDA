package com.diainstalwater.diaInstalWater.repository;

import com.diainstalwater.diaInstalWater.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
