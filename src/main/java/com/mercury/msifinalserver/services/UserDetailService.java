package com.mercury.msifinalserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.msifinalserver.beans.User;
import com.mercury.msifinalserver.beans.UserDetail;
import com.mercury.msifinalserver.daos.UserDao;
import com.mercury.msifinalserver.daos.UserDetailDao;
import com.mercury.msifinalserver.http.Response;
import com.mercury.msifinalserver.http.UserDetailResponse;

@Service
public class UserDetailService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDetailDao userDetailDao;
	
	public Response addUserDetail(UserDetail userDetail, Authentication authentication) {
		User user = userDao.findByUsername(authentication.getName());
		userDetail.setUser(user);
		return new UserDetailResponse(true, userDetailDao.save(userDetail));
	}
	
	public Response updateUserDetail(UserDetail userDetail) {
		UserDetail ud = userDetailDao.findById(userDetail.getId()).get();
		userDetail.setUser(ud.getUser());
		ud = userDetail;
		userDetailDao.save(ud);
		return new Response(true);
	}
}

