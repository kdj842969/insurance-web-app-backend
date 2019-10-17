package com.mercury.msifinalserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "MSI_USER_PROFILE")
public class Profile implements GrantedAuthority {
	@Id // no need to use sequence, can insert in table
	private int id;
	
	@Column
	private String type;

	@Override
	public String toString() {
		return "Profile [id=" + id + ", type=" + type + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Profile(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return type;
	}
	
	public Profile(int id) {
		this.id = id;
	}
}
