package com.movie.movie_catalog.client;

import java.io.IOException; 
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.movie_catalog.model.MovieRating;

@FeignClient(name = "movie-ratings" , url = "http://localhost:8060/movie-ratings")
public interface FeignClientMovieRating {

	@GetMapping("/getAllratings")
	public List<MovieRating> getAllRatings() throws IOException;

	
	@GetMapping("/getRating")
	public MovieRating getRating(@RequestParam("id") Integer id) throws IOException;
}
