package com.citi.argentina.ip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.argentina.ip.model.AuthenticationRequest;
import com.citi.argentina.ip.model.AuthenticationResponse;
import com.citi.argentina.ip.services.MyUserDetailsService;
import com.citi.argentina.ip.util.JwtUtil;

@RestController
public class HelloController 
{
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	/*
	 * For Admin only
	 * */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/getAll")
	public String getAll()
	{
		return "Get All Accounts";
		
	}
	
	/*
	 * For Admin and User 
	 * */
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@PostMapping("/create")
	public String create(@RequestBody String data)
	{
		return "Account Created";
		
	}
	
	/*
	 * For Admin and User
	 * */
   //@PreAuthorize("hasRole('ADMIN')")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping({"/hello"})
	public String hello()
	{
		return "Hello World";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
		//	e.printStackTrace();
			System.out.println("Incorrect username or password");
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	

}
