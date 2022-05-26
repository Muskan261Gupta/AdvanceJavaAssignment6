package com.nagarro.training.advancejava.assignment4.spring.Validator;

import org.springframework.ui.Model;

public class Validation {

	public static boolean isInputValid(String color,String size,String gender,String preference,Model model) {
		color=color.trim();
		if(color.isEmpty()||color.equalsIgnoreCase("null")) {
			model.addAttribute("colorError","fill out the color");
			return false;
		}
		if(size==null) {
			model.addAttribute("sizeError","size is mandatory");
			return false;
		}
		if(gender==null) {
			model.addAttribute("genderError","gender is mandatory");
			return false;
		}
		if(preference==null) {
			model.addAttribute("preferenceError","preference is mandatory");
			return false;
		}
		return true;
	}
}
