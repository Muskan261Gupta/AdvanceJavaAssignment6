package com.nagarro.training.advancejava.assignment4.spring.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.nagarro.training.advancejava.assignment4.spring.service.*;

@Component
@EnableScheduling
public class Timer {
	@Autowired
	private CSVService csv;

	@Scheduled(cron = "*/5 * * * * *")
	/*
	 * Scheduling transfer of CSV Files
	 */

	public void message() {

		csv.transferCsvFiles();
		System.out.println();
	}
}
