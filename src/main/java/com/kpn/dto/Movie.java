package com.kpn.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.kpn.dto.constant.Genre;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Movie {

	private String title;
	private float rating;
	private int runtime;
	private String imdb;

	private List<Actor> actors = new ArrayList<Actor>();

	private List<Genre> genres = new ArrayList<Genre>();

	public Movie(String title, float rating, int runtime, String imdb, List<Actor> actors, List<Genre> genres) {
		this.title = title;
		this.rating = rating;
		this.runtime = runtime;
		this.imdb = imdb;
		this.actors = actors;
		this.genres = genres;
	}

	public Movie() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	@XmlElementWrapper(name = "actors")
	@XmlElement(name = "actor")
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}

	@XmlElementWrapper(name = "genres")
	@XmlElement(name = "genre")
	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", rating=" + rating + ", runtime=" + runtime + ", imdb=" + imdb + ", actors="
				+ actors + ", genres=" + genres + "]";
	}

}
