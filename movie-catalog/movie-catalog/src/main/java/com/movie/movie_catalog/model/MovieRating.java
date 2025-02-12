package com.movie.movie_catalog.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class MovieRating implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1815406800654428446L;
	
	private Integer movie_id;
	private String movie_name;
	private Integer movie_ratings;
	
	
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public Integer getMovie_ratings() {
		return movie_ratings;
	}
	public void setMovie_ratings(Integer movie_ratings) {
		this.movie_ratings = movie_ratings;
	}
	


}
