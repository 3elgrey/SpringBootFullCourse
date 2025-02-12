package com.movie.movie_catalog.client;

import java.io.IOException;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.movie_catalog.model.MovieInfo;

@FeignClient(name = "movie-info", url = "http://localhost:8070/movie-info")
public interface FeignClientMovieInfo {
	
	@GetMapping("/getAllinfo")
	public List<MovieInfo> getAllInfo() throws IOException;

	
	@GetMapping("/getInfo")
	public MovieInfo getInfo(@RequestParam("id") Integer id) throws IOException;

}
