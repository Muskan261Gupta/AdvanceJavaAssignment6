package com.nagarro.training.advancejava.assignment4.spring.service;

import java.util.List;
import java.util.stream.Stream;

import com.nagarro.training.advancejava.assignment4.spring.model.Product;

public interface CSVService{
	
	public List<Product> parseCSVFiles(String scanDirectory);
	public List<String> scanForCsvFiles(String scanDirectory);
	public Stream<Product> convertToObject(String fileName);
	public void transferCsvFiles();
}