package com.kpn.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int customer_id;
	private String name;
	private List<Interest> interests = new ArrayList<Interest>();

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
