package com.valtech.health.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.valtech.health.app.entity.Ambulance;
import com.valtech.health.app.repostitory.AmbulanceRepository;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {
	@Autowired
	private AmbulanceRepository ambulanceRepository;

	/* This method creates Ambulance */
	@Override
	public Ambulance createAmbulance(Ambulance a) {
		return ambulanceRepository.save(a);
	}

	/* This method lists all Ambulance */
	@Override
	public List<Ambulance> getAllAmbulance() {
		return ambulanceRepository.findAll();
	}

}
