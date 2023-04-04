package com.example.InsuranceManagementPlatForm.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="name is required")
	@Column(name="name")
	private String name;
	
	@NotNull(message="dob is required")
	@Column(name="dob")
	private String dob;
	
	@NotNull(message="address is required")
	@Column(name="address")
	private String address;
	
	@NotNull(message="contact is required")
	@Column(name="contact")
	private long contact;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="client",
			   cascade= {CascadeType.PERSIST,
					     CascadeType.MERGE,
					     CascadeType.DETACH,
					     CascadeType.REFRESH})
	private List<Policy>  policies;
	
	//Add convenience Method for bidirectional relationship between client and policy
		public void add(Policy tempPolicy) {
			if(policies == null) {
				policies = new ArrayList<>();
			}
			policies.add(tempPolicy);     //bi-directional link
			tempPolicy.setClient(this);
		}
	
	
	//empty constructor
	public Client() {
		
	}

	//constructor using fields
	public Client(String name, String dob, String address, long contact) {
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.contact = contact;
	}

	//getters  and setters
	public int getId() {
		return id;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", contact=" + contact
				+ "]";
	}	

}
