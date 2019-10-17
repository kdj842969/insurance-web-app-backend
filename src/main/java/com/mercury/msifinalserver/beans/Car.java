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

@Entity
@Table(name="msi_car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_CAR_SEQ_GEN")
	@SequenceGenerator(name = "MSI_CAR_SEQ_GEN", sequenceName = "MSI_CAR_SEQ", allocationSize = 1)
	private int id;
	
	@Column
	private String vinNumber;
	
	@Column
	private String garageZip;
	
	@Column
	private String primaryUse;
	
	@Column
	private String year;
	
	@Column
	private String makes;
	
	@Column
	private String models;
	
	@Column
	private String bodyStyle;
	
	@Column
	private int totalResidence;
	
	@Column
	private String carfaxReport;
	
	@OneToOne(mappedBy = "car")
	private Application application;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int id, String vinNumber, String garageZip, String primaryUse, String year, String makes, String models,
			String bodyStyle, int totalResidence, String carfaxReport) {
		super();
		this.id = id;
		this.vinNumber = vinNumber;
		this.garageZip = garageZip;
		this.primaryUse = primaryUse;
		this.year = year;
		this.makes = makes;
		this.models = models;
		this.bodyStyle = bodyStyle;
		this.totalResidence = totalResidence;
		this.carfaxReport = carfaxReport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getGarageZip() {
		return garageZip;
	}

	public void setGarageZip(String garageZip) {
		this.garageZip = garageZip;
	}

	public String getPrimaryUse() {
		return primaryUse;
	}

	public void setPrimaryUse(String primaryUse) {
		this.primaryUse = primaryUse;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMakes() {
		return makes;
	}

	public void setMakes(String makes) {
		this.makes = makes;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyles(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public int getTotalResidence() {
		return totalResidence;
	}

	public void setTotalResidence(int totalResidence) {
		this.totalResidence = totalResidence;
	}

	public String getCarfaxReport() {
		return carfaxReport;
	}

	public void setCarfaxReport(String carfaxReport) {
		this.carfaxReport = carfaxReport;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", vinNumber=" + vinNumber + ", garageZip=" + garageZip + ", primaryUse=" + primaryUse
				+ ", year=" + year + ", makes=" + makes + ", models=" + models + ", bodyStyles=" + bodyStyle
				+ ", totalResidence=" + totalResidence + ", carfaxReport=" + carfaxReport + "]";
	}
	
	
}
