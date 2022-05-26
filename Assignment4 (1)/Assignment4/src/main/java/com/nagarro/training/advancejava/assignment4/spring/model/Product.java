package com.nagarro.training.advancejava.assignment4.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Product {
	@Id

	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private Double price;
	private float rating;
	private String availability;
	public Product() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	/*
	 * @param1 id
	 * @param2 name
	 * @param3 color
	 * @param4 gender
	 */
	public Product(String id, String name, String color, String gender) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.gender = gender;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
 
}
