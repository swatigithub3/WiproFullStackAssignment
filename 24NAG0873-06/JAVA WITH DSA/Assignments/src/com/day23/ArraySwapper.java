package com.day23;

import java.util.Arrays;

public class ArraySwapper {
	public static <T> void swap(T[] array, int index1, int index2) {
		if(index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
			throw new IllegalArgumentException("Invalid indices");
		}
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
		System.out.println("Before swapping: " + Arrays.toString(intArray));
		swap(intArray, 1, 3);
		System.out.println("After swapping: " + Arrays.toString(intArray));
		
		String[] stringArray = {"ant", "bear", "cat", "dog", "elephant"};
		System.out.println("Before swapping: " + Arrays.toString(stringArray));
		swap(stringArray, 0, 2);
		System.out.println("After swapping: " + Arrays.toString(stringArray));
		
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
		System.out.println("Before swapping: " + Arrays.toString(doubleArray));
		swap(doubleArray, 2, 4);
		System.out.println("After swapping: " + Arrays.toString(doubleArray));

	}

}
