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
	private int customer_id;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_INTEREST_MAP", joinColumns = {
			@JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "interest_id") })
	private List<Interest> interests;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public Customer(int customer_id, String name, List<Interest> interests) {
		this.customer_id = customer_id;
		this.name = name;
		this.interests = interests;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", interests=" + interests + "]";
	}

}
