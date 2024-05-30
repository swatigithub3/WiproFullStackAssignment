package com.bitwisealgorithms;

public class CountTotalSetBits {
	public static int countTotalSetBits(int n) {
		int totalSetBits = 0;
		int i = 0;
		while((1 << i) <= n) {
			int blockSize = 1 << (i +1);
			int fullBlocks = n / blockSize;
			totalSetBits += fullBlocks * (1 << i);
			int remainingBits = n % blockSize;
			totalSetBits += Math.max(totalSetBits,  remainingBits -(1 << i) + 1);
			i++;
		}
		return totalSetBits;
	}

	public static void main(String[] args) {
		int n = 7;
		System.out.println("Total set bits from 1 to " + n + " is " + countTotalSetBits(n));

	}

}
