package com.movie.movie_info.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie_info.model.MovieInfo;
import com.movie.movie_info.service.MovieInfoService;

@RestController
@RequestMapping("/movie-info")
public class MovieInfoController {

	@Autowired
	MovieInfoService movieInfoService;
	
	
	@GetMapping("/getAllinfo")
	public List<MovieInfo> getAllInfo() throws IOException {
		
		List<MovieInfo> list = movieInfoService.getAllInfo();
		return list;
	}
	
	@GetMapping("/getInfo")
	public MovieInfo getInfo(@RequestParam("id") Integer id) throws IOException {
		
		MovieInfo rating = movieInfoService.getInfo(id);
		return rating;
		
	}
}
