
package com.nagarro.training.advancejava.assignment4.spring.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.advancejava.assignment4.spring.model.Customer;
import com.nagarro.training.advancejava.assignment4.spring.repository.CustomerRepository;
import com.nagarro.training.advancejava.assignment4.spring.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	/*
	 * to check the credentials
	 * 
	 * @param customer login
	 * 
	 * @return boolean
	 */
	@Override
	public boolean login(Customer login) {
		String uname = login.getUsername();
		String pass = login.getPassword();
		Optional<Customer> customerOptional = customerRepo.findById(uname);
		if (customerOptional.isEmpty()) {
			return false;
		}
		Customer customer = customerOptional.get();
		System.out.print(customer);
		if (customer.getUsername().equalsIgnoreCase(uname) && customer.getPassword().equalsIgnoreCase(pass)) {
			return true;
		} else
			return false;
	}

}
