package com.kpn.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movies {
	@XmlElement(name = "movie")
	private ArrayList<Movie> movie;

	public ArrayList<Movie> getMovie() {
		return movie;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movie = movies;
	}

	@Override
	public String toString() {
		return "Movies [movies=" + movie + "]";
	}

}
