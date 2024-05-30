package com.day18;

public class BitManipulation {
	public static int countSetBits(int num) {
		int count = 0;
		while(num > 0) {
			count += (num & 1);
			num >>= 1;
		}
		return count;
	}
	public static int totalSetBits(int n) {
		int totalCount = 0;
		for(int i = 1; i <= n; i++) {
			totalCount += countSetBits(i);
		}
		return totalCount;
	}

	public static void main(String[] args) {
		int num = 10;
		System.out.println("Number of set bits in " + num + " is " + countSetBits(num));
		int n = 5;
		System.out.println("Total number of set bits from 1 to " + n + " is " + totalSetBits(n));

	}

}
