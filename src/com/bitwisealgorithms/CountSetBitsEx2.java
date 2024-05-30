package com.bitwisealgorithms;

public class CountSetBitsEx2 {
	public static int countSetBits(int n) {
		int count = 0;
		while(n>0) {
			count += (n & 1);
			n >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int num = 7;
		System.out.println("Number of set bits in " + num + " is " + countSetBits(num));

	}

}
