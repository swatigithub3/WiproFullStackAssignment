package com.dynamicprogrammingalgorithms;

public class OptimalBST {
	public static int optimalBST(int[] keys, int[] freq, int n) {
		int[][] cost = new int[n+1][n+1];
		int[][] weight = new int[n+1][n+1];
		for(int i = 0; i < n; i++) {
			cost[i][i] = freq[i];
			weight[i][i] = freq[i];
		}
		for(int length = 2; length <= n; length++) {
			for(int i = 0; i <= n-length; i++) {
				int j = i + length - 1;
				weight[i][j] = weight[i][j-1] + freq[j];
				cost[i][j] = Integer.MAX_VALUE;
				for(int r = i; r <= j; r++) {
					int c = ((r > i) ? cost[i][r-1]:0) + ((r < j) ? cost[r+1][j]:0) + weight[i][j];
					if(c < cost[i][j]) {
						cost[i][j] = c;
					}
				}
			}
		}
		return cost[0][n-1];
	}

	public static void main(String[] args) {
		int[] keys = {10,12,20};
		int[] freq = {34,8,50};
		int n = keys.length;
		System.out.println("Cost of Optimal BST is : " + optimalBST(keys, freq, n));

	}

}
