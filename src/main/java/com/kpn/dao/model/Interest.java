package com.kpn.dao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kpn.model.Genre;
import com.kpn.model.RuntimeSpecialSymbole;

@Entity
public class Interest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int interest_id;
	private String gender;
	private String ratings;
	private boolean ratingsWithPlus;

	private String runtime;
	@Enumerated(EnumType.STRING)
	private RuntimeSpecialSymbole runtimeSpecialSymbole;

	@Enumerated(EnumType.STRING)
	private Genre genres;
	private String actors;

	public int getInterest_id() {
		return interest_id;
	}

	public void setInterest_id(int interest_id) {
		this.interest_id = interest_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public boolean isRatingsWithPlus() {
		return ratingsWithPlus;
	}

	public void setRatingsWithPlus(boolean ratingsWithPlus) {
		this.ratingsWithPlus = ratingsWithPlus;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public RuntimeSpecialSymbole getRuntimeSpecialSymbole() {
		return runtimeSpecialSymbole;
	}

	public void setRuntimeSpecialSymbole(RuntimeSpecialSymbole runtimeSpecialSymbole) {
		this.runtimeSpecialSymbole = runtimeSpecialSymbole;
	}

	public Genre getGenres() {
		return genres;
	}

	public void setGenres(Genre genres) {
		this.genres = genres;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Interest [interest_id=" + interest_id + ", gender=" + gender + ", ratings=" + ratings
				+ ", ratingsWithPlus=" + ratingsWithPlus + ", runtime=" + runtime + ", runtimeSpecialSymbole="
				+ runtimeSpecialSymbole + ", genres=" + genres + ", actors=" + actors + "]";
	}

}
