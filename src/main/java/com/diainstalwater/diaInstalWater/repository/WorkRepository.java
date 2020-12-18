package com.diainstalwater.diaInstalWater.repository;

import com.diainstalwater.diaInstalWater.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
}
