package com.diainstalwater.diaInstalWater.repository;

import com.diainstalwater.diaInstalWater.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
