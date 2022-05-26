package com.nagarro.training.advancejava.assignment4.spring.service;

import java.util.List;

import com.nagarro.training.advancejava.assignment4.spring.model.Product;
public interface ProductService {
	/*
	 * to find all the products in db
	 * 
	 * @return Iterable of product
	 */
	public Iterable<Product> findAll();
	/*
	 * to search for the products 
	 * 
	 * @param1 gender
	 * 
	 * @param2 color
	 * 
	 * @param3 size
	 * 
	 * @return Iterable of product
	 */
	public Iterable<Product> searchProduct(String gender, String color, String size);
	/*
	 * to sort for the products 
	 * 
	 * @param1 products
	 * 
	 * @param2 based
	 
	 * @return List of product
	 */
	public List<Product> sortProduct(Iterable<Product> products, String based);
	/*
	 * to save products  into db
	 * 
	 * @param1 productList
	 */
	public void save(Iterable<Product> productList);
}
