
package com.nagarro.training.advancejava.assignment4.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.training.advancejava.assignment4.spring.model.Product;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, String> {
	public Iterable<Product> findByGenderAndSizeAndColorAndAvailability(String gender, String size, String color,
			String Available);

	public void save(Iterable<Product> productList);

}
