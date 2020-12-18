package com.diainstalwater.diaInstalWater.repository;

import com.diainstalwater.diaInstalWater.model.Plumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlumberRepository extends JpaRepository<Plumber, Long> {
}
