package com.kpn.dao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
	@Id
	private int customerId;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMERINTERESTS", joinColumns = { @JoinColumn(name = "customerId") }, inverseJoinColumns = {
			@JoinColumn(name = "interestId") })
	private List<Interest> interests;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public Customer(int customerId, String name, List<Interest> interests) {
		this.customerId = customerId;
		this.name = name;
		this.interests = interests;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", interests=" + interests + "]";
	}

}
