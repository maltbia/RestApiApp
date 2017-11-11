package com.aca.rest.service;

import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import com.aca.rest.dao.MovieDao;
import com.aca.rest.model.Movie;

public class MovieService {

	public List<Movie> getAllMovies(){

		MovieDao dao= new MovieDao();		
		return dao.getAllMovies();
	}

	public List<Movie> getMoviesByGenre(String genre) {
		validateGenre(genre);
		MovieDao dao= new MovieDao();		
		return dao.getMoviesByGenre(genre);
	}

	private boolean validateGenre(String genre) {		
		if(genre.equalsIgnoreCase("Action") || genre.equalsIgnoreCase("Syfy") || genre.equalsIgnoreCase("Comedy") || genre.equalsIgnoreCase("Drama")){
			return true;
		}else{			
			Response response = Response.status(400)
					.entity("Invalid request entered for genre...'" + genre + "'..., use valid values of 'action', 'syfy', 'comedy', and 'drama'")
					.build();
			throw new WebApplicationException(response);
		}

	}

	public List<Movie> getMoviesByYear(String year) {

		MovieDao dao= new MovieDao();		
		return dao.getMoviesByYear(year);
	}

}
