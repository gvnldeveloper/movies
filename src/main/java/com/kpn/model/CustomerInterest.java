package com.kpn.model;

public class CustomerInterest {

	private String title;
	private String imdb;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public CustomerInterest() {
	}

	public CustomerInterest(String title, String imdb) {
		super();
		this.title = title;
		this.imdb = imdb;
	}

	@Override
	public String toString() {
		return "CustomerInterest [title=" + title + ", imdb=" + imdb + "]";
	}

}
