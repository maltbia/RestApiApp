package com.aca.rest.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.aca.rest.model.Movie;

public class MovieDao {
	
	private static List<Movie> movies= new ArrayList<Movie>();
	
	static{
		
		Calendar cal =Calendar.getInstance();
		cal.set(1999, 0, 0);
		Date releaseDate1 = cal.getTime();
		
		Calendar cal1 =Calendar.getInstance();
		cal1.set(2016, 0, 0);
		Date releaseDate2 = cal1.getTime();
		
		Calendar cal2 =Calendar.getInstance();
		cal2.set(2017, 0, 0);
		Date releaseDate3 = cal2.getTime();
		
		Calendar cal3 =Calendar.getInstance();
		cal3.set(1985, 0, 0);
		Date releaseDate4 = cal3.getTime();
		
		
		movies.add(new Movie("The World Is Not Enough", "Action", "PG-13","Pierce Brosnan", 51, releaseDate1));
		movies.add(new Movie("Star Trek Beyond", "Syfy", "PG-13", "Zoe Saldana", 84, releaseDate2));
		movies.add(new Movie("Girls Trip", "Comedy", "R", "Tiffany Haddish", 89, releaseDate3));
		movies.add(new Movie("The Color Purple", "Drama", "PG-13", "Danny Glover", 88, releaseDate4));
	}
	
	public List<Movie> getAllMovies(){
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.addAll(MovieDao.movies);
		
		return movies;
	}
	
	public List<Movie> getMoviesByGenre(String genre){
		List<Movie> movies = new ArrayList<Movie>();
		
		for(Movie movie: MovieDao.movies ){
			if(movie.getGenre().equalsIgnoreCase(genre)){
				movies.add(movie);
			}
		}
			
		return movies;
		
	}

	public List<Movie> getMoviesByYear(String year) {
		List<Movie> movies = new ArrayList<Movie>();
		
		for(Movie movie: MovieDao.movies ){
			if(movie.getRelearYear().equalsIgnoreCase(year)){
				movies.add(movie);
			}
		}
			
		return movies;
	}

}
