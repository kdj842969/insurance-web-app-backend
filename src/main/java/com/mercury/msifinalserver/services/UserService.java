package com.mercury.msifinalserver.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercury.msifinalserver.beans.Application;
import com.mercury.msifinalserver.beans.Profile;
import com.mercury.msifinalserver.beans.User;
import com.mercury.msifinalserver.daos.UserDao;
import com.mercury.msifinalserver.http.Response;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getAll() {
		return userDao.findAll();
	}
	
	public Response register(User user) {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			List<Profile> profiles = new ArrayList<Profile>();
			profiles.add(new Profile(2));
			user.setProfiles(profiles);
			userDao.save(user);
			// TODO: send email. assume username is the email for now
			return new Response(true);

		} catch (Exception e) {
			return new Response(false, 400, e.getMessage());
		}
	}
	
	public Response changePassword(User user, Authentication authentication) {
		// authentication: Spring security API, tell are you able to change the password
		// 
		if(user.getUsername().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
			User u = userDao.findByUsername(user.getUsername());
			u.setPassword(passwordEncoder.encode(user.getPassword()));
			userDao.save(u);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new Response(false);
		}
		return new Response(true);
	}
	
	public boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
		// check if it is your admin
		boolean isAdmin = false;
		for(GrantedAuthority profle: profiles) {
			if(profle.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		};
		return isAdmin;
	}
	
	public Response deleteUser(int id) {
		if(userDao.findById(id).get() != null) {
			userDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "User is not found!");
		}
	}
}
