package com.valtech.health.app.service;

import com.valtech.health.app.entity.DoctorUser;

public interface DoctorUserService {

	/* This method creates Doctor */
	DoctorUser createDoctorUser(DoctorUser d1);

	/* This method finds Doctor by their Email */
	DoctorUser findByEmail(String email);

	/* This method finds Doctor by their user name */
	DoctorUser findByUsername(String username);

	/* This method finds Doctor by their Password */
	DoctorUser findByPassword(String password);

	/* This method retrieves Doctor's user name by their ID */
	DoctorUser getUsername(int id);

	/* This method retrieves Doctor's ID by user name */
	int getIdbyUsername(String username);

	/* This method finds Doctor by name */
	Boolean findByName(String name);
}
