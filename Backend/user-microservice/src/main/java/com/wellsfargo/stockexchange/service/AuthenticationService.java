package com.wellsfargo.stockexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.wellsfargo.stockexchange.models.*;
import com.wellsfargo.stockexchange.models.enums.UserTypes;
import com.wellsfargo.stockexchange.util.UserRepository;

import java.util.ArrayList;


@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        if(user==null) {
        	throw new UsernameNotFoundException("Error: User not found with username: " + username);
        }
        
    	
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
    }
    
    public boolean checkAdmin(LoginRequest user) throws DataIntegrityViolationException {
        User user1 = userRepository.findByUsername(user.getUsername());
        if(user1.getUserType()==UserTypes.ADMIN)
        	return true;
        return false;
    }
    
    public boolean checkExistingUserName(User user) throws DataIntegrityViolationException {
        User user1 = userRepository.findByUsername(user.getUsername());
        if(user1==null)
        	return true;
        return false;
   	}
    
    public boolean checkExistingEmail(User user) throws DataIntegrityViolationException {
        User user1 = userRepository.findByEmail(user.getEmail());   
        if(user1==null)
        	return true;
        return false;
   	}
    
    
	public User save(User userRequest) {
		userRequest.setUserType(UserTypes.USER);
		userRequest.setConfirmed(true);
		
		return userRepository.save(userRequest);
	}
    
    
}
