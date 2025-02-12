package com.movie.movie_catalog.model;

import java.io.Serializable;

public class MovieCatalog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1815406800654428446L;
	
	private Integer movieId;
	private String movieName;
	private String movieInfo;
	private String movieDirector;
	private Integer rating;
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	

}
