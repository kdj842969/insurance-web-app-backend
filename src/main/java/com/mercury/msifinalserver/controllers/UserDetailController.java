package com.mercury.msifinalserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.msifinalserver.beans.UserDetail;
import com.mercury.msifinalserver.http.Response;
import com.mercury.msifinalserver.services.UserDetailService;

@RestController
@RequestMapping("/user-details")
public class UserDetailController {
	
	@Autowired
	UserDetailService userDetailService;

	@PostMapping
	public Response postUserDetails(@RequestBody UserDetail userDetail, Authentication authentication) {
		return userDetailService.addUserDetail(userDetail, authentication);
	}
	
	@PutMapping
	public Response putUserDetails(@RequestBody UserDetail userDetail) {
		return userDetailService.updateUserDetail(userDetail);
	}
	
}
