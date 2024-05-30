package com.day17;
import java.util.ArrayList;
import java.util.List;
public class RabinKarpSubstringSearch {
	private static final int PRIME = 101;
	private static final int BASE = 256;
	public static List<Integer> search(String text, String pattern){
		List<Integer> indexes = new ArrayList<>();
		int n = text.length();
		int m = pattern.length();
		int patternHash = hash(pattern,m);
		int textHash = hash(text.substring(0,m),m);
		for(int i =0;i<=n-m;i++) {
			if(patternHash == textHash && text.substring(i,i+m).equals(pattern)) {
				indexes.add(i);
			}
			if(i < n - m) {
				textHash = recalculateHash(text,i,m,textHash);
			}
		}
		return indexes;
	}
	public static int hash(String str, int length) {
		int hash = 0;
		for(int i = 0; i < length; i++) {
			hash =(BASE * hash + str.charAt(i)) % PRIME;
		}
		return hash;
	}
	private static int recalculateHash(String str, int oldIndex, int length, int oldHash) {
		int newHash = (oldHash - str.charAt(oldIndex) * power(BASE, length -1)) % PRIME;
		newHash = (newHash * BASE + str.charAt(oldIndex +length)) % PRIME;
		if(newHash < 0) {
			newHash += PRIME;
		}
		return newHash;
	}
	private static int power(int base, int exp) {
		int result = 1;
		for(int i = 0; i < exp; i++) {
			result = (result * base) % PRIME;
		}
		return result;
	}

	public static void main(String[] args) {
		String text = "ababcababcabcabc";
		String pattern = "abc";
		List<Integer> indexes = search(text, pattern);
		System.out.println("Pattern found at indexes: " + indexes);

	}

}



/* Impact of hash collision and how to handle them: 
 * The hash collisions can impact the performance of the Rabin-Karp algorithm. If two different
 * substrings have the same hash value, the algorithm might falsely identify one substring for another,
 * resulting in incorrect matches. This can lead to a loss of accuracy and efficiency.
 * To handle hash collisions, one method is to use a rolling hash technique, which recalculates the hash
 * value in constant time as the window slides over the text. This helps mitigate the impact of collisions
 * because even if there is a collision, it will only affect the current window, not the entire text.*/
