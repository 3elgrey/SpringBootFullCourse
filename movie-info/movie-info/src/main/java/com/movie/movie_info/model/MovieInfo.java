package com.movie.movie_info.model;

import java.io.Serializable;

public class MovieInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1815406800654428446L;
	
	private Integer movie_id;
	private String movie_name;
	private String movie_info;
	private String movie_director;
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
	public String getMovie_info() {
		return movie_info;
	}
	public void setMovie_info(String movie_info) {
		this.movie_info = movie_info;
	}
	public String getMovie_director() {
		return movie_director;
	}
	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}
	
	
	

}
