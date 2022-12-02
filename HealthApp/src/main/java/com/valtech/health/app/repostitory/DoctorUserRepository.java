package com.valtech.health.app.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.health.app.entity.DoctorUser;

@Repository
public interface DoctorUserRepository extends JpaRepository<DoctorUser, Integer> {

	/* This method finds Doctor by their Email */
	DoctorUser findByEmail(String email);

	/* This method finds Doctor by their user name */
	DoctorUser findByUsername(String username);

	/* This method finds Doctor by their Password */
	DoctorUser findByPassword(String password);

	/* This method retrieves user name by ID */
	DoctorUser findUsernameById(int id);

	/* This method retrieves Doctor's ID by user name */
	DoctorUser findIdByUsername(String username);

	/* This method finds Doctor by name */
	DoctorUser findByName(String name);

}