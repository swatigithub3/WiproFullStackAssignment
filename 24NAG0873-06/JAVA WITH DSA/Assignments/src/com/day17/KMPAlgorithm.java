package com.day17;

public class KMPAlgorithm {
	public static void KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		int lps[] = new int[M];
		int j =0;
		computeLPSArray(pat,M,lps);
		int i =0;
		while(i < N) {
			if(pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if(j==M) {
				System.out.println("Found pattern at index " + (i-j));
				j = lps[j-1];
			}
			else if(i<N && pat.charAt(j)!=txt.charAt(i)) {
				if(j!=0)
					j=lps[j-1];
				else
					i=i+1;
			}
		}
	}
	private static void computeLPSArray(String pat,int M,int lps[]) {
		int len =0;
		int i = 1;
		lps[0] =0;
		while(i<M) {
			if(pat.charAt(i)==pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len!=0) {
					len = lps[len-1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		String txt = "ABABDABACBDEABABCAB";
		String pat = "ABABC";
		KMPSearch(pat,txt);

	}

}




/* How Pre-processing Improves Search Time:
 * Avoiding Redundant Comparisons:
 * During the search when a mismatch occurs after 'j' matches, instead of shifting the pattern by one 
 * character to the right and starting comparisons from scratch, the KMP algorithm uses the information
 * from the LPS array to skip characters in the pattern and text.
 * Overall, the KMP algorithm improves the search time to O(M+N), which is much more efficient than the 
 * O(MN) time complexity of the naive approach,especially for larger text and patterns. */ 
