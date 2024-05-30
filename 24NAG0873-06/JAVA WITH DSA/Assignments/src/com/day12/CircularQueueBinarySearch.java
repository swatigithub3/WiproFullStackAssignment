package com.day12;


public class CircularQueueBinarySearch {
	static int search(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		while(start <= end) {
			int mid = (start + end)/2;
			if(arr[mid] == target) {
				return mid;
			}
			if(arr[start] <= arr[mid]) {
				if(target >= arr[start] && target < arr[mid]) {
					end = mid-1;
				} else {
					start = mid +1;
				}
			} else {
				if(target > arr[mid] && target <= arr[end]) {
					start = mid +1;
				} else {
					end = mid-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] circularQueue = {40,8,56,3,90,6};
		int target = 3;
		int result = search(circularQueue, target);
		if(result != -1) {
			System.out.println("Element " + target + " found at index: " + result);
		} else {
			System.out.println("Element " + target + " not found.");
		}

	}

}


