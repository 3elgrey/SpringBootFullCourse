package com.movie.movie_catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.movie_catalog.model.MovieCatalog;
import com.movie.movie_catalog.model.MovieInfo;
import com.movie.movie_catalog.model.MovieRating;

@RestController
//@RequestMapping("/movie-catalog")
public class MovieController_webClient {

	//@GetMapping("/getMovieDetails/{id}")
	public MovieCatalog getMovieDetails(@PathVariable("id") Integer id) {
		
		WebClient webClientInfo = WebClient.builder().baseUrl("http://localhost:8070/movie-info/").build();
		MovieInfo info = webClientInfo.get()
                .uri("getInfo/"+ id)	
                .retrieve()
                .bodyToMono(MovieInfo.class) // mono is a promise of object of MovieInfo not right now but soon in future
                .block();
		
		WebClient webClientRatings = WebClient.builder().baseUrl("http://localhost:8060/movie-ratings/").build();
		MovieRating rate = webClientRatings.get()
                .uri("getRating/"+ id)	
                .retrieve()
                .bodyToMono(MovieRating.class) // mono is a promise of object of MovieInfo not right now but soon in future
                .block();
		
		MovieCatalog cat = new MovieCatalog();
		cat.setMovieId(id);
		cat.setMovieName(info.getMovie_name());
		cat.setRating(rate.getMovie_ratings());
		cat.setMovieDirector(info.getMovie_director());
		cat.setMovieInfo(info.getMovie_info());
		return cat;
		
	}
}
