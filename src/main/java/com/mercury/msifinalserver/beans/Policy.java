package com.mercury.msifinalserver.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="msi_policy")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_POLICY_SEQ_GEN")
	@SequenceGenerator(name = "MSI_POLICY_SEQ_GEN", sequenceName = "MSI_POLICY_SEQ", allocationSize = 1)
	private int id;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@Column
	private String policyDocumentAddress;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "msi_policy_msi_insurance_type", joinColumns = {
			@JoinColumn(name = "policy_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "insurance_type_id", referencedColumnName = "id") })
	private List<InsuranceType> types = new ArrayList<InsuranceType>();

	@OneToOne(mappedBy = "policy", cascade = CascadeType.ALL)
	private Application application;
	
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(int id, Date startDate, Date endDate, String policyDocumentAddress, List<InsuranceType> types) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.policyDocumentAddress = policyDocumentAddress;
		this.types = types;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPolicyDocumentAddress() {
		return policyDocumentAddress;
	}

	public void setPolicyDocumentAddress(String policyDocumentAddress) {
		this.policyDocumentAddress = policyDocumentAddress;
	}

	public List<InsuranceType> getTypes() {
		return types;
	}

	public void setTypes(List<InsuranceType> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", policyDocumentAddress="
				+ policyDocumentAddress + ", types=" + types + "]";
	}

	
	
	
}
