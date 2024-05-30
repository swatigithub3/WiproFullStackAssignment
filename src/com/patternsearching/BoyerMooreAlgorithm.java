package com.patternsearching;

import java.util.Arrays;

public class BoyerMooreAlgorithm {
	public static final int ALPHABET_SIZE = 256;
	private static int[] buildBadMatchTable(String pattern) {
		int m = pattern.length();
		int[] badMatchTable = new int[ALPHABET_SIZE];
		Arrays.fill(badMatchTable, -1);
		for(int i =0; i < m; i++) {
			badMatchTable[(int) pattern.charAt(i)] = i;
		}
		return badMatchTable;
	}
	public static int search(String text,String pattern) {
		int n = text.length();
		int m = pattern.length();
		if(m == 0 || n == 0 || m > n) {
			return -1;
		}
		int[] badMatchTable = buildBadMatchTable(pattern);
		int i =0;
		while(i <= n - m) {
			int j = m - 1;
			while(j >= 0&& pattern.charAt(j) == text.charAt(i+j)) {
				j--;
			}
			if(j < 0) {
				return i;
			} else {
				int badCharIndex = (int) text.charAt(i+j);
				i += Math.max(1, j-badMatchTable[badCharIndex]);
			}
		}
		return -1;
				
	}

	public static void main(String[] args) {
		String text = "this is an example";
		String pattern = "exam";
		int index = search(text, pattern);
		if(index == -1) {
			System.out.println("Pattern not found");
		} else {
			System.out.println("Pattern found at index: " + index);
		}

	}

}
