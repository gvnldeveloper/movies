package com.kpn.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movies {

	@XmlElement(name = "movie")
	private List<Movie> movie;

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(ArrayList<Movie> movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Movies [movies=" + movie + "]";
	}

}
