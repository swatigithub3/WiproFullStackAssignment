package com.day27;

public class StringUtils {
	public boolean isPalindrome(String str) {
		if(str == null) {
			return false;
		}
		String reversed = new StringBuilder(str).reverse().toString();
		return str.equals(reversed);
	}
	public String reverse(String str) {
		if(str == null) {
			return null;
		}
		return new StringBuilder(str).reverse().toString();
	}
	public boolean containsOnlyDigits(String str) {
		if(str == null) {
			return false;
		}
		return str.matches("\\d+");
	}

}
