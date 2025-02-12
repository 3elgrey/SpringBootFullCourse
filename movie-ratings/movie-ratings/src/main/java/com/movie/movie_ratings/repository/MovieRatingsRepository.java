package com.movie.movie_ratings.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.movie_ratings.model.MovieRating;

@Repository
public class MovieRatingsRepository {

	@Autowired
	private ObjectMapper objectMapper;

	public List<MovieRating> getAllRatings() throws IOException {

		Resource resource = new ClassPathResource("/static/data/ratings.json");
		List<MovieRating> mList = objectMapper.readValue(resource.getInputStream(),
				objectMapper.getTypeFactory().constructCollectionType(List.class, MovieRating.class));

		return mList;

	}

	public Optional<MovieRating> getRating(Integer id) throws IOException {

		Resource resource = new ClassPathResource("/static/data/ratings.json");
		List<MovieRating> mList = objectMapper.readValue(resource.getInputStream(),
				objectMapper.getTypeFactory().constructCollectionType(List.class, MovieRating.class));
		
		Optional<MovieRating> rating = mList.stream().filter(i-> i.getMovie_id()== id).findFirst();

		return rating;

	}

}
