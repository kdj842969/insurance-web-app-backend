package com.mercury.msifinalserver.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="msi_user")
public class User implements UserDetails{
	@Id
	@SequenceGenerator(name="msi_user_gen", sequenceName="MSI_USER_SEQ", allocationSize=1) 
	@GeneratedValue(generator="msi_user_gen", strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="username", unique = true, nullable = false) 
	// java level constraint, not database constraint
	private String username;
	@Column(name="password", nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	// two isolated table, detached, don't need to mention
	@JoinTable(name = "MSI_USER_MSI_USER_PROFILE", // when write code inside, you are using this table
	     joinColumns = {
	    		 @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	     },
	     inverseJoinColumns = {
	    		 @JoinColumn(name="USER_PROFILE_ID", referencedColumnName = "ID")
	     }
	)
	@JsonIgnore
	// intermediate table, need to give the table name
	// I'm MSI_USER_MSI_USER_PROFILE (my USER_ID), need to join with the MSI_USER (top class) ID
	// generic type represent with one to join -> inverseJoinColumns
	private List<Profile> profiles = new ArrayList<>(); 
	// have to have generic, or inverseJoinColumns don't know which one to join
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserDetail userDetail;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Application> applications = new ArrayList<>();
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", profiles=" + profiles
				+ ", userDetail=" + userDetail + ", applications=" + applications +"]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// return a collection
		// profile extends GrantedAuthority, profiles list is collection
		return profiles;
	}
	@Override
	public boolean isAccountNonExpired() { // expire after 3 month
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() { // username and pwd never expired
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
