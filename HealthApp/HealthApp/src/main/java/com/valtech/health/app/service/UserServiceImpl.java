package com.valtech.health.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.valtech.health.app.entity.User;
import com.valtech.health.app.repostitory.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	 
	 public UserServiceImpl(UserRepository userRepository){
	        this.userRepository = userRepository;
	        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    }
	 

//	/* This method creates new nurse */
//	@Override
//	public User createUser(User u) {
//		return userRepository.save(u);
//	}
	 
	 /* This method creates Doctor */
	    @Override
	    public User createUser(User u) {
	        String encodedPassword = this.bCryptPasswordEncoder.encode(u.getPassword());
	        //d1.setPassword(bCryptPasswordEncoder.encode(d1.getPassword()));
	        u.setPassword(encodedPassword);
//	        UserEntity userEntity = new UserEntity();
//	        return doctorUserRepository.save(d1);
	        return this.userRepository.save(u);
	    }
	 

	/* This method finds nurse by email */
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/* This method finds nurse by user name */
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	/* This method finds nurse by password */
	@Override
	public User findByPassword(String password) {
		return userRepository.findByPassword(password);
	}

	/* This method retrieves user name by id */
	@Override
	public User getUsername(int id) {
		// TODO Auto-generated method stub
		return userRepository.findUsernameById(id);
	}

	/* This method retrieves id by user name */
	@Override
	public int getIdbyUsername(String username) {
		User du = userRepository.findByUsername(username);
		return du.getId();
	}

	@Override
	public User changePassword(User u, String password, String confirmpassword) {
		// TODO Auto-generated method stub
		u.setPassword(password);
		u.setConfirmpassword(confirmpassword);
		return userRepository.save(u);
	}

}
