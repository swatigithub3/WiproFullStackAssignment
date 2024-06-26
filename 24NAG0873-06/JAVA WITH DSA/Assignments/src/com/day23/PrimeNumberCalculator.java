package com.day23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeNumberCalculator {

	public static void main(String[] args) {
		int maxNumber = 1000;
		int numberOfThreads = 4;
		String outputPath = "primes.txt";
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
		List<CompletableFuture<Void>> futures = new ArrayList<>();
		for(int i = 0; i < numberOfThreads; i++) {
			final int start = i * (maxNumber / numberOfThreads) + 1;
			final int end = (i + 1) * (maxNumber / numberOfThreads);
			futures.add(CompletableFuture.runAsync(() -> writePrimesToFile(start, end, outputPath), executorService));
			
		}
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
		.thenRun(() -> System.out.println("Prime numbers have been written to " + outputPath))
		.exceptionally(ex ->{
			ex.printStackTrace();
			return null;
		});
		executorService.shutdown();

	}
	private static void writePrimesToFile(int start, int end, String path) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))){
			for(int i = start; i <= end; i++) {
				if(isPrime(i)) {
					writer.write(i + "\n");
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static boolean isPrime(int number) {
		if(number <= 1) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(number);i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
