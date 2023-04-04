package com.example.InsuranceManagementPlatForm.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="policy")
public class Policy {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	
	@Column(name="policy_number")
	private String policyNumber;
	
	@Column(name="type")
	private String type;
	
	@Column(name="coverage_amount")
	private double coverageAmount;
	
	@Column(name="premium")
	private double premium;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="end_date")
	private String endDate;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST,
			             CascadeType.MERGE,
			             CascadeType.DETACH,
			             CascadeType.REFRESH})
	@JoinColumn(name="client_id")
	private Client client;
	
	
	//OneToMany mapping for one policy to many Claims
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade=CascadeType.ALL)   
	@JoinColumn(name="policy_id")
	private List<Claim> claims;
	
	//Adding convenient method for claims
	public void  add(Claim tempClaim) {
		if(claims==null) {
			claims = new ArrayList<>();
		}
		claims.add(tempClaim);
	}
	
	//Empty Constructor
	public Policy() {
		
	}

	//Constructor with Fields
	public Policy(String policyNumber, String type,double coverageAmount, double premium, String startDate, String endDate) {
		this.policyNumber = policyNumber;
		this.type = type;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyNumber=" + policyNumber + ", type=" + type + ", coverageAmount="
				+ coverageAmount + ", premium=" + premium + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", client=" + client + "]";
	}
}
