package com.day16;

public class StringOperations {
	public static String middleSubstringAfterReverse(String str1,String str2,int length) {
		String concatenated = str1+str2;
		String reversed = new StringBuilder(concatenated).reverse().toString();
		if(length >= reversed.length()) {
			return reversed;
		}
		int startIndex = (reversed.length() - length)/2;
		return reversed.substring(startIndex,startIndex + length);
	}

	public static void main(String[] args) {
		System.out.println(middleSubstringAfterReverse("hello", "world", 4));
		System.out.println(middleSubstringAfterReverse("java", "program", 5));

	}

}
