package com.movie.movie_info.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.movie.movie_info.model.MovieInfo;
import com.movie.movie_info.repository.MovieInfoRepository;

@Service
public class MovieInfoService {
	
	@Autowired
	MovieInfoRepository movieInfoRepository;
	
	public List<MovieInfo> getAllInfo() throws StreamReadException, DatabindException, IOException{
		return movieInfoRepository.getAllInfo();
	}
	
	public MovieInfo getInfo(Integer id) throws StreamReadException, DatabindException, IOException{
		return movieInfoRepository.getInfo(id);
	}

}
