package com.movie.movie_catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.movie_catalog.model.MovieCatalog;
import com.movie.movie_catalog.model.MovieInfo;
import com.movie.movie_catalog.model.MovieRating;

@RestController
//@RequestMapping("/movie-catalog")
public class MovieController_RestTemplate{
	
		
	//@GetMapping("/getMovieDetails/{id}")
	public MovieCatalog getMovieDetails(@PathVariable("id") Integer id) {
		
		//Either we hard code the rest template here or create bean in @SpringBootApplication to make it singleton
		RestTemplate template = new RestTemplate();
		MovieInfo info = template.getForObject("http://localhost:8070/movie-info/getInfo/"+ id, MovieInfo.class);
		MovieRating rate = template.getForObject("http://localhost:8060/movie-ratings/getRating/"+ id, MovieRating.class);
		
		MovieCatalog cat = new MovieCatalog();
		cat.setMovieId(id);
		cat.setMovieName(info.getMovie_name());
		cat.setRating(rate.getMovie_ratings());
		cat.setMovieDirector(info.getMovie_director());
		cat.setMovieInfo(info.getMovie_info());
		
		return cat;
		
	}

}
