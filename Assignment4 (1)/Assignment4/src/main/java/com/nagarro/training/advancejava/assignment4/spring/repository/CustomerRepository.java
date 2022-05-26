
package com.nagarro.training.advancejava.assignment4.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.training.advancejava.assignment4.spring.model.Customer;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
