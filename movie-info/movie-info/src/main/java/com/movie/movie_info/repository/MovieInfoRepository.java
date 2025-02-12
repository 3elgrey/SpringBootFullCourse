package com.movie.movie_info.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.movie_info.model.MovieInfo;

@Repository
public class MovieInfoRepository {
	
	@Autowired
	ObjectMapper objectMapper;
	
	public List<MovieInfo> getAllInfo() throws StreamReadException, DatabindException, IOException{
		
		Resource resource = new ClassPathResource("/static/data/movieInfo.json");
		List<MovieInfo> infoList = objectMapper.readValue(resource.getInputStream(), 
				objectMapper.getTypeFactory().constructCollectionType(List.class, MovieInfo.class));
		return infoList;
	}
	
	public MovieInfo getInfo(Integer id) throws StreamReadException, DatabindException, IOException{
		Resource resource = new ClassPathResource("/static/data/movieInfo.json");
		List<MovieInfo> infoList = objectMapper.readValue(resource.getInputStream(), 
				objectMapper.getTypeFactory().constructCollectionType(List.class, MovieInfo.class));
		
		Optional<MovieInfo> info = infoList.stream().filter(i-> i.getMovie_id()== id).findFirst();
		return info.get();
	}

}
