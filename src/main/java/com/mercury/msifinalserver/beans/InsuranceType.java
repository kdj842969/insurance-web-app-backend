package com.mercury.msifinalserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="msi_insurance_type")
public class InsuranceType {
	@Id
	private int id;
	
	@Column
	private String type;

	public InsuranceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsuranceType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
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

	@Override
	public String toString() {
		return "InsuranceType [id=" + id + ", type=" + type + "]";
	}
	
	
	
	
}
