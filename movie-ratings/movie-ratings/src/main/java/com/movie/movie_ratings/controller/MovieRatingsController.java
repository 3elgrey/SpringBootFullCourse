package com.movie.movie_ratings.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie_ratings.model.MovieRating;
import com.movie.movie_ratings.service.MovieRatingsService;

@RestController
@RequestMapping("/movie-ratings")
public class MovieRatingsController {
	
	@Autowired
	MovieRatingsService movieRatingsService;
	
	@GetMapping("/getAllratings")
	public List<MovieRating> getAllRatings() throws IOException {
		
		List<MovieRating> list = movieRatingsService.getAllRatings();
		return list;
	}
	
	@GetMapping("/getRating")
	public MovieRating getRating(@RequestParam("id") Integer id) throws IOException {
		
		Optional<MovieRating> rating = movieRatingsService.getRating(id);
		return rating.get();
		
	}

}
