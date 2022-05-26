
package com.nagarro.training.advancejava.assignment4.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.training.advancejava.assignment4.spring.Validator.Validation;
import com.nagarro.training.advancejava.assignment4.spring.model.Product;
import com.nagarro.training.advancejava.assignment4.spring.service.CSVService;
import com.nagarro.training.advancejava.assignment4.spring.service.ProductService;

@Controller
@RequestMapping("/products/")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired

	private CSVService csvService;
	/*
	 * Check for Products
	 * 
	 * @param1 color
	 * 
	 * @param2 preference
	 * 
	 * @param3 gender
	 * 
	 * @param4 size
	 * 
	 * @return product
	 */

	@GetMapping("/")
	public String searchProduct(@RequestParam(value = "color", required = false) String color,
			@RequestParam(value = "preference", required = false) String preference,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "size", required = false) String size, Model model) {
		if (Validation.isInputValid(color, size, gender, preference, model)) {
			List<Product> productList = csvService.parseCSVFiles("D://projects//csv//");
			List<Product> products = (List<Product>) productService.searchProduct(gender, color, size);
			if (products.isEmpty()) {
				model.addAttribute("noproduct", "No such product exists!");
			} else {

				productService.save(productList);

				products = (List<Product>) productService.sortProduct(products, preference);
			}
			model.addAttribute("products", products);
			System.out.println(color + " " + size + " " + gender);
		}
		return "searchProduct";
	}

}
