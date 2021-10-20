package com.citi.argentina.ip.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	 {
		HashMap<String,com.citi.argentina.ip.model.User> userMap=new HashMap<>();
		
		com.citi.argentina.ip.model.User user1=new com.citi.argentina.ip.model.User();
		
		user1.setUsername("chetan");
		user1.setPassword("chetan");
		Set<String> set1=new HashSet<>();
		set1.add("USER");
		user1.setRoles(set1);
		
		
        com.citi.argentina.ip.model.User user2=new com.citi.argentina.ip.model.User();
		
		user2.setUsername("admin");
		user2.setPassword("admin");
		Set<String> set2=new HashSet<>();
		set2.add("ADMIN");
		set2.add("USER");
		user2.setRoles(set2);
		
		
		userMap.put("chetan", user1);
		userMap.put("admin",user2);
		
		com.citi.argentina.ip.model.User user=userMap.get(username);
		
	//	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));	
		return new User(user.getUsername(),user.getPassword(),getAuthority(user));
	}
	
	private Set getAuthority(com.citi.argentina.ip.model.User user) {
        Set authorities = new HashSet<>();
        for(String role:user.getRoles())
        {
        	System.out.println("ROLES:"+role);
            authorities.add(new SimpleGrantedAuthority("ROLE_" +role));
    		
        }
        
        /*
		user.getRoles().forEach(role -> {
        });*/
        
		return authorities;
	}


}
