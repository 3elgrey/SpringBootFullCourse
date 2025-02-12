package com.movie.movie_catalog.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie_catalog.client.FeignClientMovieInfo;
import com.movie.movie_catalog.client.FeignClientMovieRating;
import com.movie.movie_catalog.model.MovieCatalog;
import com.movie.movie_catalog.model.MovieInfo;
import com.movie.movie_catalog.model.MovieRating;


@RestController
@RequestMapping("/movie-catalog")
public class MovieController_FeignClient {
	
	
	
	@Autowired
	FeignClientMovieInfo feignClientMovieInfo;
	
	@Autowired
	FeignClientMovieRating feignClientMovieRating;
	
	
	@GetMapping("/getMovieDetails/{id}")
	public MovieCatalog getMovieDetails(@PathVariable("id") Integer id) throws IOException {
		
		
		MovieInfo info = feignClientMovieInfo.getInfo(id);
		MovieRating rate = feignClientMovieRating.getRating(id);
		
		MovieCatalog cat = new MovieCatalog();
		cat.setMovieId(id);
		cat.setMovieName(info.getMovie_name());
		cat.setRating(rate.getMovie_ratings());
		cat.setMovieDirector(info.getMovie_director());
		cat.setMovieInfo(info.getMovie_info());
		return cat;
		
	}
}
