package com.valtech.health.app.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.health.app.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
