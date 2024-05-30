package com.dynamicprogrammingalgorithms;

public class Knapsack {
	public static int knapsack(int[] weights, int[] values, int weightLimit) {
		int n = weights.length;
		int[][] dp = new int[n+1][weightLimit+1];
		for(int i = 0; i <= n; i++) {
			for(int w = 0; w <= weightLimit; w++) {
				if(i == 0 || w == 0) {
					dp[i][w] = 0;
				} else if(weights[i - 1] <= w) {
					dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		return dp[n][weightLimit];
	}

	public static void main(String[] args) {
		int[] weights = {10,15,5,20};
		int[] values = {6,10,12,14};
		int weightLimit = 20;
		System.out.println("Maximum value in Knapsack = " + knapsack(weights, values, weightLimit));

	}
}
