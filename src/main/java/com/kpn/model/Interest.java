package com.kpn.model;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.kpn.model.constant.Genre;

public class Interest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String gender;
	private String ratings;
	private String runtime;
	@Enumerated(EnumType.STRING)
	private Genre genres;
	private String actors;

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

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
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
		return "Interest [gender=" + gender + ", ratings=" + ratings + ", runtime=" + runtime + ", genres=" + genres
				+ ", actors=" + actors + "]";
	}

}
