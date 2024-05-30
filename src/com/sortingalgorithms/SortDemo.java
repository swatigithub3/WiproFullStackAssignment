package com.sortingalgorithms;

public class SortDemo {

	public static void main(String[] args) {
		int[] arr = {99,63,67,20,8,86,1};
		System.out.println("Unsorted Array: ");
		
		//Bubble Sort
		BubbleSort.printArray(arr);
		BubbleSort.bubbleSort(arr);
		System.out.println("Sorted Array: ");
		BubbleSort.printArray(arr);
		
		//Merge Sort
		MergeSort.sort(arr,0,arr.length - 1);
		System.out.println("Sorted Array:");
		MergeSort.printArray(arr);
		
		//Quick Sort
		QuickSort.quickSort(arr,0,arr.length-1);
		System.out.println("Sorted Array:");
		QuickSort.printArray(arr);
		
		//Heap Sort
		HeapSort h = new HeapSort();
		h.heapSort(arr);
		System.out.println("Sorted Array:");
		h.printArray(arr);
		

	}

}
