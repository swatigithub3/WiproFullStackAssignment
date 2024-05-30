package com.bitwisealgorithms;

public class OptimizeBitwiseAND {
	public static int bitwiseANDOfAllSubsets(int[] arr) {
		int result = arr[0];
		for(int i = 1; i < arr.length;i++) {
			result &= arr[i];
			if(result==0) {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 12,15,7};
		int result = bitwiseANDOfAllSubsets(arr);
		System.out.println("Bitwise AND of all subsets: " + result);

	}

}
