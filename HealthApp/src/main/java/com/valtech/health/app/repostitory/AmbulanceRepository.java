package com.valtech.health.app.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.health.app.entity.Ambulance;

@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Integer> {

}
