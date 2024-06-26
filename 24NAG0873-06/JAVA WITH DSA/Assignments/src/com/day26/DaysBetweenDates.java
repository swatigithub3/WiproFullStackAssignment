package com.day26;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetweenDates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first date(yyyy-MM-dd): ");
		String firstDateString = sc.nextLine();
		System.out.println("Enter the second date(yyyy-MM-dd): ");
		String secondDateString = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate firstDate = LocalDate.parse(firstDateString, formatter);
		LocalDate secondDate = LocalDate.parse(secondDateString, formatter);
		long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);
		System.out.println("Number of days between two dates: " + daysBetween);
		sc.close();
	}

}
