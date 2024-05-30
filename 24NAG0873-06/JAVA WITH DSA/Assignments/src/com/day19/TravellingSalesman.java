package com.day19;

public class TravellingSalesman {
	private static final int INF = Integer.MAX_VALUE/2;
	public int FindMinCost(int[][] graph) {
		int n = graph.length;
		int fullMask = (1 << n) - 1;
		int[][] dp = new int[1 << n][n];
		for(int i =0; i < (1 << n); i++) {
			for(int j = 0; j < n;j++) {
				dp[i][j] = INF;
			}
		}
		dp[1][0] = 0;
		for(int mask = 1; mask < (1 << n); mask++) {
			for(int i = 0; i < n; i++) {
				if((mask & (1 << i)) == 0)
					continue;
				for(int j = 0;j < n; j++) {
					if((mask & (1 << j)) !=0)
						continue;
					int nextMask = mask | (1 << j);
					dp[nextMask][j] = Math.min(dp[nextMask][j], dp[mask][i] + graph[i][j]);
				}
			}
		}
		int minCost = INF;
		for(int i= 1; i < n; i++) {
			minCost = Math.min(minCost, dp[fullMask][i] + graph[i][0]);
		}
		return minCost;
	}

	public static void main(String[] args) {
		TravellingSalesman ts = new TravellingSalesman();
		int[][] graph = {
				{0, 10, 15, 20},
				{10, 0, 35, 25},
				{15, 35, 0, 30},
				{20, 25, 30, 0}
		};
		System.out.println("Minimum tour cost will be:" + ts.FindMinCost(graph));
		}

	}


