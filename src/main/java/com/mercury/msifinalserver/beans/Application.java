package com.mercury.msifinalserver.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="msi_application")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_CAR_SEQ_GEN")
	@SequenceGenerator(name = "MSI_CAR_SEQ_GEN", sequenceName = "MSI_CAR_SEQ", allocationSize = 1)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Car car;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Client client;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Policy policy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	@Column
	private String applicationStatus;

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Application(int id, Car car, Client client, User user, Policy policy, String applicationStatus) {
		super();
		this.id = id;
		this.car = car;
		this.client = client;
		this.policy = policy;
		this.user = user;
		this.applicationStatus = applicationStatus;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", car=" + car + ", client=" + client + ", policy=" + policy + ", user=" + user
				+ ", applicationStatus=" + applicationStatus + "]";
	}

	


	
}
