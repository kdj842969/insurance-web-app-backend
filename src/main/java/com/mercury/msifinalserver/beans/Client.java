package com.mercury.msifinalserver.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="msi_client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_CLIENT_SEQ_GEN")
	@SequenceGenerator(name = "MSI_CLIENT_SEQ_GEN", sequenceName = "MSI_CLIENT_SEQ", allocationSize = 1)
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String middleName;
	
	@Column
	private String sex;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	@Column
	private int marital;
	
	@Column
	private int education;
	
	@Column
	private String occupation;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zip;
	
	@Column
	private String ssn;
	
	@Column
	private String license;
	
	@OneToOne(mappedBy = "client")
	private Application application;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id, String firstName, String lastName, String middleName, String sex, Date dateOfBirth,
			int marital, int education, String occupation, String address1, String address2, String city, String state,
			String zip, String ssn, String license) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.marital = marital;
		this.education = education;
		this.occupation = occupation;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ssn = ssn;
		this.license = license;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getMarital() {
		return marital;
	}

	public void setMarital(int marital) {
		this.marital = marital;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + ", marital=" + marital + ", education=" + education
				+ ", occupation=" + occupation + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", ssn=" + ssn + ", license=" + license + "]";
	}
}
