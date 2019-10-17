package com.mercury.msifinalserver.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.msifinalserver.beans.UserDetail;

public interface UserDetailDao extends JpaRepository<UserDetail, Integer> {

}

