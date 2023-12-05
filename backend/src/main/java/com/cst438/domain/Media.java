package com.cst438.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Media {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String type;
	private String genre;
	private int rating;
	private String review;
	private String picURL;
	
	public int getId() {
		return id;	
	}
	
	public void setId(int id) {
		this.id = id;	
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}


	
	public String getPicURL() {
		return picURL;
	}

	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", type=" + type + ", title=" + title 
				+ ", rating=" + rating + ", review=" + review + "picURL=" + picURL + "]";
	}

}
