package com.kpn.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int actor_id;
	private String gender;

	private String name;

	public Actor(String gender, String name) {
		this.gender = gender;
		this.name = name;
	}

	public Actor() {
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	@Override
	public String toString() {
		return "Actor [actor_id=" + actor_id + ", gender=" + gender + ", name=" + name + "]";
	}

}
