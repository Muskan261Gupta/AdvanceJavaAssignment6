
package com.nagarro.training.advancejava.assignment4.spring.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.advancejava.assignment4.spring.Constants.ProductConstants;
import com.nagarro.training.advancejava.assignment4.spring.model.Product;
import com.nagarro.training.advancejava.assignment4.spring.repository.ProductRepository;
import com.nagarro.training.advancejava.assignment4.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepo;

	/*
	 * to find all the products in db
	 * 
	 * @return Iterable of product
	 */
	@Override
	public Iterable<Product> findAll() {
		return productRepo.findAll();
	}

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
	@Override
	public Iterable<Product> searchProduct(String gender, String color, String size) {
		return productRepo.findByGenderAndSizeAndColorAndAvailability(gender, size, color, "Y");
	}

	/*
	 * to sort for the products
	 * 
	 * @param1 products
	 * 
	 * @param2 based
	 * 
	 * @return List of product
	 */
	@Override
	public List<Product> sortProduct(Iterable<Product> products, String based) {
		List<Product> productList = (List<Product>) products;
		if (ProductConstants.PRICE.equalsIgnoreCase(based)) {
			productList = productList.stream().sorted(Comparator.comparingDouble(Product::getPrice))
					.collect(Collectors.toList());
			return productList;
		} else if (ProductConstants.RATING.equalsIgnoreCase(based)) {
			productList = productList.stream().sorted(Comparator.comparingDouble(Product::getRating).reversed())
					.collect(Collectors.toList());
			return productList;
		} else {
			productList = productList.stream()
					.sorted(Comparator.comparingDouble(Product::getPrice)
							.thenComparing(Comparator.comparingDouble(Product::getRating).reversed()))
					.collect(Collectors.toList());
			return productList;
		}
	}

	/*
	 * to save product in db
	 * 
	 * @param product
	 */
	public void save(Iterable<Product> productList) {
		productRepo.saveAll(productList);
	}
}
