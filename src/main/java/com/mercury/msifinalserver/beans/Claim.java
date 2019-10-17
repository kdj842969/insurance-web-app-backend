package com.mercury.msifinalserver.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="msi_claim")
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_CLAIM_SEQ_GEN")
	@SequenceGenerator(name = "MSI_CLAIM_SEQ_GEN", sequenceName = "MSI_CLAIM_SEQ", allocationSize = 1)
	private int id;
	
	@Column
	private Date accidentTime;
	
	@Column
	private int occupantsNumber;
	
	@Column
	private String policeReport;
	
	@Column
	private String policeStationName;
	
	@Column
	private String placeOfAccident;
	
	@Column
	private String relationshipWithInsured;
	
	@Column
	private String driverLicense;
	
	@Column
	private String statement;
	
	@Column
	private String propertyDetails;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "policy_id")
	private Policy policy;
	
	@Column
	private String claimStatus;
	
	@Column
	private double claimPrice;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "claim")
	private List<Document> documents = new ArrayList<>();

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(int id, Date accidentTime, int occupantsNumber, String policeReport, String policeStationName,
			String placeOfAccident, String relationshipWithInsured, String driverLicense, String statement,
			String propertyDetails, Policy policy, String claimStatus, double claimPrice, List<Document> documents) {
		super();
		this.id = id;
		this.accidentTime = accidentTime;
		this.occupantsNumber = occupantsNumber;
		this.policeReport = policeReport;
		this.policeStationName = policeStationName;
		this.placeOfAccident = placeOfAccident;
		this.relationshipWithInsured = relationshipWithInsured;
		this.driverLicense = driverLicense;
		this.statement = statement;
		this.propertyDetails = propertyDetails;
		this.policy = policy;
		this.claimStatus = claimStatus;
		this.claimPrice = claimPrice;
		this.documents = documents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(Date accidentTime) {
		this.accidentTime = accidentTime;
	}

	public int getOccupantsNumber() {
		return occupantsNumber;
	}

	public void setOccupantsNumber(int occupantsNumber) {
		this.occupantsNumber = occupantsNumber;
	}

	public String getPoliceReport() {
		return policeReport;
	}

	public void setPoliceReport(String policeReport) {
		this.policeReport = policeReport;
	}

	public String getPoliceStationName() {
		return policeStationName;
	}

	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}

	public String getPlaceOfAccident() {
		return placeOfAccident;
	}

	public void setPlaceOfAccident(String placeOfAccident) {
		this.placeOfAccident = placeOfAccident;
	}

	public String getRelationshipWithInsured() {
		return relationshipWithInsured;
	}

	public void setRelationshipWithInsured(String relationshipWithInsured) {
		this.relationshipWithInsured = relationshipWithInsured;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getPropertyDetails() {
		return propertyDetails;
	}

	public void setPropertyDetails(String propertyDetails) {
		this.propertyDetails = propertyDetails;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public double getClaimPrice() {
		return claimPrice;
	}

	public void setClaimPrice(double claimPrice) {
		this.claimPrice = claimPrice;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", accidentTime=" + accidentTime + ", occupantsNumber=" + occupantsNumber
				+ ", policeReport=" + policeReport + ", policeStationName=" + policeStationName + ", placeOfAccident="
				+ placeOfAccident + ", relationshipWithInsured=" + relationshipWithInsured + ", driverLicense="
				+ driverLicense + ", statement=" + statement + ", propertyDetails=" + propertyDetails + ", policy="
				+ policy + ", claimStatus=" + claimStatus + ", claimPrice=" + claimPrice + ", documents=" + documents
				+ "]";
	}
	

	
}
