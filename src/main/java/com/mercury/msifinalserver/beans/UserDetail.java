package com.mercury.msifinalserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "msi_user_detail")
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_USER_DETAIL_SEQ_GEN")
	@SequenceGenerator(name = "MSI_USER_DETAIL_SEQ_GEN", sequenceName = "MSI_USER_DETAIL_SEQ", allocationSize = 1)
	int id;
	@Column
	String name;
	@Column
	String phone;
	@Column
	String email;
	@Column
	String address1;
	@Column
	String address2;
	@Column
	String city;
	@Column
	String zip;
	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	User user;

	public UserDetail() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", zip=" + zip
				+ ", user=" + user + "]";
	}

}
