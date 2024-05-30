package com.day17;

public class BoyerMooreLastOccurrence {
	public static int lastIndexOf(String text, String pattern) {
		int n =text.length();
		int m = pattern.length();
		if(m==0)
			return 0;
		int[] last = buildLast(pattern);
		int i = n - 1;
		int j = m - 1;
		while(i >= 0 && j >= 0) {
			if(text.charAt(i) == pattern.charAt(j)) {
				i--;
				j--;
			} else {
				i = i + m - Math.min(j, 1 + last[text.charAt(i)]);
				j = m - 1;
			}
		}
		if(j == -1)
			return i + 1;
		return -1;
	}
	private static int[] buildLast(String pattern) {
		int[] last = new int[256];
		for(int i =0;i < last.length;i++) {
			last[i] = -1;
		}
		for(int i=0;i < pattern.length();i++) {
			last[pattern.charAt(i)] = i;
		}
		return last;
	}

	public static void main(String[] args) {
		String text = "the quick brown fox is very quick";
		String pattern = "quick";
		int lastIndex = lastIndexOf(text,pattern);
		if(lastIndex!=-1) {
			System.out.println("Last occurance found at index: " + lastIndex);
		} else {
			System.out.println("Pattern not found in the text.");
		}

	}

}



/* Why Boyer-Moore algorithm can outperform others in certain scenarios:
 * The Boyer-Moore algorithm excels in scenarios where the pattern to be searched for is relatively
 * long and the text being searched is large. This is because it utilizes two main strategies: the
 * "bad character rule" and the "good suffix rule" which allow it to skip comparisons and eliminate
 * potential matches quickly. Additionally Boyer-Moore tends to perform well when there is a high
 * repetition of characters in the pattern, as it can exploit this information to skip large
 *  portions of the text during the search process. */ 
