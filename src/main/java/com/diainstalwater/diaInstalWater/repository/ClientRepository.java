package com.diainstalwater.diaInstalWater.repository;

import com.diainstalwater.diaInstalWater.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
