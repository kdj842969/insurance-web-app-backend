package com.mercury.msifinalserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="msi_document")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_DOCUMENT_SEQ_GEN")
	@SequenceGenerator(name = "MSI_DOCUMENT_SEQ_GEN", sequenceName = "MSI_DOCUMENT_SEQ", allocationSize = 1)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "claim_id")
	@JsonIgnore
	private Claim claim;
	
	@Column
	private String address;
}
