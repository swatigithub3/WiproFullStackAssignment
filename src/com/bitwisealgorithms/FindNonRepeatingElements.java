package com.bitwisealgorithms;

public class FindNonRepeatingElements {
	public static void findNonRepeating(int[] arr) {
		int xorResult = 0;
		for(int num : arr) {
			xorResult ^= num;
		}
		int setBit = xorResult & ~(xorResult-1);
		int x=0;
		int y=0;
		for (int num : arr) {
			if((num & setBit) == 0) {
				x ^= num;
			} else {
				y ^= num;
			}
		}
		System.out.println("The two non repeating elements are " + x + " and " + y);
	}

	public static void main(String[] args) {
		int[] arr = {4,2,4,3,7,5,5,2};
		findNonRepeating(arr);

	}

}
