package com.kpn.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.kpn.dto.constant.Genre;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String title;
	private float rating;
	private int runtime;
	private String imdb;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MOVIE_ACTOR_MAP", joinColumns = { @JoinColumn(name = "movieId") }, inverseJoinColumns = {
			@JoinColumn(name = "actorId") })
	private List<Actor> actors = new ArrayList<Actor>();

	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Genre.class)
	@CollectionTable(name = "MOVIEGENRES", joinColumns = @JoinColumn(name = "movieId"))
	@Column(name = "GENREID")
	private List<Genre> genres = new ArrayList<Genre>();

	public Movie(String title, float rating, int runtime, String imdb, List<Actor> actors, List<Genre> genres) {
		this.title = title;
		this.rating = rating;
		this.runtime = runtime;
		this.imdb = imdb;
		this.actors = actors;
		this.genres = genres;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
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

	public List<Genre> getGenres() {
		return genres;
	}

	

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", rating=" + rating + ", runtime=" + runtime
				+ ", imdb=" + imdb + ", actors=" + actors + ", genres=" + genres + "]";
	}

}
