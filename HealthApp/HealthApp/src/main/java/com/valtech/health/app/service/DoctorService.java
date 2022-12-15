package com.valtech.health.app.service;

import java.util.List;

import com.valtech.health.app.entity.Doctor;

public interface DoctorService {

	/* This method creates Doctor Comments */
	Doctor createDoctor(Doctor d);

	/* This method finds Doctor Comments by their name */
	Doctor findByDoctorsname(String doctorsname);

	/* This method lists all the Doctor Comments */
	List<Doctor> getAllDoctorComments();

	/* This method lists all the Doctor Comments by ID */
	Doctor getDoctorCommentById(int id);

	/* This method updates all the Doctor Comments */
	Doctor updateDoctorComments(Doctor d);

}
