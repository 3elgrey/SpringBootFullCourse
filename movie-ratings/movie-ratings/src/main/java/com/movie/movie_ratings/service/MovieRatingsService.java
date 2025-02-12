package com.movie.movie_ratings.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movie_ratings.model.MovieRating;
import com.movie.movie_ratings.repository.MovieRatingsRepository;

@Service
public class MovieRatingsService {
	
	@Autowired
	MovieRatingsRepository movieRatingsRepository;
	
	public List<MovieRating> getAllRatings() throws IOException{
		return movieRatingsRepository.getAllRatings();
	}
	
	public Optional<MovieRating> getRating(Integer id) throws IOException {
		return movieRatingsRepository.getRating(id);
	}
}
