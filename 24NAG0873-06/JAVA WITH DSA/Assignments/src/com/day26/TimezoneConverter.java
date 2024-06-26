package com.day26;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Scanner;

public class TimezoneConverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date and time (yyyy-MM-dd HH:mm): ");
		String dateTimeString = sc.nextLine();
		System.out.println("Enter the source timezone(e.g., America/New_York): ");
		String sourceTimeZone = sc.nextLine();
		System.out.println("Enter the target timezone(e.g., Europe/London): ");
		String targetTimeZone = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
		ZonedDateTime sourceDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(sourceTimeZone));
		ZonedDateTime targetDateTime = sourceDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));
		System.out.println("Converted time: " + targetDateTime.format(formatter));
		sc.close();

	}

}
