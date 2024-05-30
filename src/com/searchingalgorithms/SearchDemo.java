package com.searchingalgorithms;

public class SearchDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,7,4,5,8};
		System.out.println(LinearSearch.find(arr,9));
		System.out.println(LinearSearch.find(arr,5));

		
		
		//Binary Search
		System.out.println("For Binary Search");
		int[] arr1 = {1,2,3,4,5,6,7,8,9};
		System.out.println(BinarySearch.search(arr1,6));
		
		int[] arr2 = {9,8,7,6,5,4,3,2,1};
		System.out.println(BinarySearch.search(arr2,6));
		
		
		//Jump Search
		System.out.println("For Jump Search: ");
		int[] arr3 = {1,2,3,5,6,9,13};
		System.out.println(JumpSearch.search(arr3,6));

	}

}
