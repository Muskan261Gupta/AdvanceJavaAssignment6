
package com.nagarro.training.advancejava.assignment4.spring.service;

import com.nagarro.training.advancejava.assignment4.spring.model.Customer;

public interface CustomerService {
	/*
	 * check the credentials of user
	 * 
	 * @param customer login
	 * 
	 * @return boolean
	 */
	public boolean login(Customer login);
}
