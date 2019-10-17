package com.mercury.msifinalserver.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mercury.msifinalserver.beans.Application;

public interface ApplicationDao extends JpaRepository<Application, Integer> {
	@Modifying
	@Transactional
	@Query("delete from Application a where a .id = ?1")
	public void delete(int id);
}
