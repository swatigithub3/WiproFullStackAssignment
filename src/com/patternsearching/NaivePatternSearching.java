package com.patternsearching;

public class NaivePatternSearching {
	public static void search(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		for(int i =0; i<n-m;i++) {
			int j =0;
			for(j=0;j<m;j++) {
				if(text.charAt(i+j)!= pattern.charAt(j)) {
					break;
				}
			}
			if(j==m) {
				System.out.println("Pattern found at index " + i);
			}
		}
				
	}

	public static void main(String[] args) {
		String text="ABABAB";
		String pattern="AB";
		search(text,pattern);

	}

}
