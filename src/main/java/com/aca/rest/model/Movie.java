package com.aca.rest.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="movie")
public class Movie {
	
	@XmlElement(name="title")
	private String title;
	
	@XmlElement(name="genre")
	private String genre;
	
	@XmlElement(name="rating")
	private String rating;
	
	@XmlElement(name="cast")
	private String cast;
	
	@XmlElement(name="rottenTomatoes")
	private int rottenTomatoes;
	
	@XmlElement(name="releaseYear")
	private String releaseYear;
	
	//no argument constructor is needed for jersey/jaxb
	public Movie(){
	}
	
	public Movie(String title, String genre, String rating, String cast, int rottenTomatoes,
					Date releaseDate){
		this.title=title;
		this.genre=genre;
		this.rating=rating;
		this.cast=cast;
		this.rottenTomatoes=rottenTomatoes;
		
		SimpleDateFormat sd= new SimpleDateFormat("YYYY");
		this.releaseYear= sd.format(releaseDate);
		
		
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public void setGenre(String genre){
		this.genre=genre;
	}
	
	public void setRating(String rating){
		this.rating=rating;
	}
	
	public void setCast(String cast){
		this.cast=cast;
	}
	
	public void setrottenTomatoes(int rottenTomatoes){
		this.rottenTomatoes=rottenTomatoes;
	}
	
	@XmlTransient
	public String getGenre() {
		return genre;
	}
	
	@XmlTransient
	public String getRelearYear() {
		return releaseYear;
	}

	
}
