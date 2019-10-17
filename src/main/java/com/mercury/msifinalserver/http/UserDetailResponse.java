package com.mercury.msifinalserver.http;

import com.mercury.msifinalserver.beans.UserDetail;

public class UserDetailResponse extends Response {

	private UserDetail userDetail;

	public UserDetailResponse(boolean success, UserDetail userDetail) {
		super(success);
		this.userDetail = userDetail;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}

