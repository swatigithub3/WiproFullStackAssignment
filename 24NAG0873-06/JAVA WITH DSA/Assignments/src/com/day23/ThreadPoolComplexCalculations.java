package com.day23;

import java.util.concurrent.*;

public class ThreadPoolComplexCalculations {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 10; i++) {
			int taskId = i;
			executorService.submit(() -> performTask(taskId));
		}
		executorService.shutdown();
		try {
			if(!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
			}
		} catch(InterruptedException e) {
			executorService.shutdownNow();
		}

	}
	private static void performTask(int taskId) {
		System.out.println("Task " + taskId + " started.");
		double result = 0;
		for(int i = 0; i < 1000000; i++) {
			result += Math.sin(i) * Math.cos(i);
		}
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("Task " + taskId + " completed. Result: " + result);
	}

}
