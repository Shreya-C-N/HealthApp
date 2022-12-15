package com.valtech.health.app.service;

import java.util.List;
import com.valtech.health.app.entity.Ambulance;

public interface AmbulanceService {

	/* This method creates Ambulance */
	Ambulance createAmbulance(Ambulance a);

	/* This method lists all Ambulance */
	List<Ambulance> getAllAmbulance();

}