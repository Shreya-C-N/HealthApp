package com.valtech.health.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.health.app.entity.Admin;
import com.valtech.health.app.repostitory.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	/* This method creates Admin */
	@Override
	public Admin createAdmin(Admin ad) {
		return adminRepository.save(ad);
	}

}
