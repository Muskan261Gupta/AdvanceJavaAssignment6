
package com.nagarro.training.advancejava.assignment4.spring.serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;

import com.nagarro.training.advancejava.assignment4.spring.model.Product;
import com.nagarro.training.advancejava.assignment4.spring.service.CSVService;

@Service
public class CSVServiceImpl implements CSVService{
	private static final String CSV = "csv";

	@Override
	/*
	 * Create List of all CSV Files
	 * 
	 * @param String scanDirectory
	 * 
	 * @return List of Product
	 */
	public List<Product> parseCSVFiles(String scanDirectory) {
		List<String> csvFiles = scanForCsvFiles(scanDirectory);
		if (Objects.isNull(csvFiles) || csvFiles.isEmpty()) {
			return null;
		}

		return csvFiles.stream().flatMap(fileName -> {
			return convertToObject(fileName);
		}).collect(Collectors.toList());
	}

	@Override
	/*
	 * Scan the path of CSV Files
	 * 
	 * @param String scanDirectory
	 * 
	 * @return List of Path
	 */
	public List<String> scanForCsvFiles(String scanDirectory) {
		File[] filesInDirectory = new File(scanDirectory).listFiles();
		if (Objects.isNull(filesInDirectory) || filesInDirectory.length == 0) {
			return null;
		}

		return Arrays.stream(filesInDirectory).map(file -> {
			if (file.isDirectory()) {
				scanForCsvFiles(file.getAbsolutePath());
			}
			String filePath = file.getAbsolutePath();
			String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
			if (CSV.equals(fileExtenstion)) {
				return filePath;
			}
			return null;
		}).filter(Objects::nonNull).collect(Collectors.toList());

	}

	@Override
	/*
	 * Converting CSV Record into object
	 * 
	 * @param String fileName
	 * 
	 * @return Stream of Product
	 */
	public Stream<Product> convertToObject(String fileName) {
		try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			return csvParser.getRecords().stream().map(csvRecord -> {
				Product tutorial = new Product(csvRecord.get("ID"), csvRecord.get("NAME"), csvRecord.get("COLOUR"),
						csvRecord.get("GENDER_RECOMMENDATION"));
				tutorial.setSize(csvRecord.get("SIZE"));
				tutorial.setPrice(Double.parseDouble(csvRecord.get("PRICE")));
				tutorial.setRating(Float.parseFloat(csvRecord.get("RATING")));
				tutorial.setAvailability(csvRecord.get("AVAILABILITY"));
				return tutorial;
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}

	@Override
	/*
	 * Transfer CSV File from configurable directory to csv directory
	 */
	public void transferCsvFiles() {
		List<String> csvFile = scanForCsvFiles("D://Configurable//");
		if (csvFile == null) {
			return;
		}
		csvFile.stream().forEach(file -> {
			File src = new File(file);
			File dest = new File("D://projects//csv//" + src.getName());
			try {
				if (!dest.exists())
					Files.copy(src.toPath(), dest.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(src.getPath());
			// System.out.println(dest.getPath());
		});

	}
}
