
package com.nagarro.training.advancejava.assignment4.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.training.advancejava.assignment4.spring.model.Customer;
import com.nagarro.training.advancejava.assignment4.spring.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	/*
	 * to show the login page
	 */
	@GetMapping("/login")
	public String showLogin() {
		return "index";
	}

	/*
	 * to logout and redirect to login page
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/logout")
	public String logoutPage() {
		return "redirect:/login?logout";
	}

	/*
	 * Check for Credentials
	 * 
	 * @param1 customer
	 * 
	 * @param2 model
	 * 
	 * @return String
	 */
	@PostMapping("/login")
	public String login(@ModelAttribute(name = "loginForm") Customer login, Model m) {
		if (customerService.login(login)) {
			return "searchProduct";
		} else {
			m.addAttribute("error", "Incorrect Username & Password");
			return "index";
		}
	}
}
