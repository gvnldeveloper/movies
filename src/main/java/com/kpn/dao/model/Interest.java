package com.kpn.dao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kpn.dto.constant.Genre;
import com.kpn.dto.constant.RuntimeSpecialSymbol;

@Entity
public class Interest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int interestId;
	private String gender;
	private String ratings;
	private boolean ratingsWithPlus;

	private String runtime;
	@Enumerated(EnumType.STRING)
	private RuntimeSpecialSymbol runtimeSpecialSymbol;

	@Enumerated(EnumType.STRING)
	private Genre genres;
	private String actors;

	public int getInterestId() {
		return interestId;
	}

	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}

	public void setRuntimeSpecialSymbol(RuntimeSpecialSymbol runtimeSpecialSymbol) {
		this.runtimeSpecialSymbol = runtimeSpecialSymbol;
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

	public RuntimeSpecialSymbol getRuntimeSpecialSymbol() {
		return runtimeSpecialSymbol;
	}

	public void setRuntimeSpecialSymbole(RuntimeSpecialSymbol runtimeSpecialSymbol) {
		this.runtimeSpecialSymbol = runtimeSpecialSymbol;
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
		return "Interest [interestId=" + interestId + ", gender=" + gender + ", ratings=" + ratings
				+ ", ratingsWithPlus=" + ratingsWithPlus + ", runtime=" + runtime + ", runtimeSpecialSymbole="
				+ runtimeSpecialSymbol + ", genres=" + genres + ", actors=" + actors + "]";
	}

}
