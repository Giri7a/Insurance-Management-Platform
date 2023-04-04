package com.example.InsuranceManagementPlatForm.entity;

import jakarta.persistence.*;

@Entity
@Table(name="claim")
public class Claim {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="claim_number")
	private String claimNumber;
	
	@Column(name="description")
	private String description;
	
	@Column(name="claim_date")
	private String claimDate;
	
	@Column(name="claim_status")
	private String claimStatus;
	
	//Empty Constructor
	public Claim() {
		
	}

	public Claim(String claimNumber, String description, String claimDate, String claimStatus) {
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimNumber=" + claimNumber + ", description=" + description + ", claimDate="
				+ claimDate + ", claimStatus=" + claimStatus + "]";
	}
}
