package com.day28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface SortingStrategy{
	void sort(List<Integer> numbers);
}

class BubbleSortStrategy implements SortingStrategy{
	@Override
	public void sort(List<Integer> numbers) {
		int n = numbers.size();
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(numbers.get(j) > numbers.get(j + 1)) {
					int temp = numbers.get(j);
					numbers.set(j, numbers.get(j + 1));
					numbers.set(j + 1, temp);
				}
			}
		}
	}
}

class QuickSortStrategy implements SortingStrategy{
	@Override
	public void sort(List<Integer> numbers) {
		quickSort(numbers, 0, numbers.size() - 1);
	}
	private void quickSort(List<Integer> numbers, int low, int high) {
		if(low < high) {
			int pi = partition(numbers, low, high);
			quickSort(numbers, low, pi - 1);
			quickSort(numbers, pi + 1, high);
		}
	}
	private int partition(List<Integer> numbers, int low, int high) {
		int pivot = numbers.get(high);
		int i = low - 1;
		for(int j = low; j < high; j++) {
			if(numbers.get(j) < pivot) {
				i++;
				int temp = numbers.get(i);
				numbers.set(i, numbers.get(j));
				numbers.set(j, temp);
			}
		}
		int temp = numbers.get(i + 1);
		numbers.set(i + 1, numbers.get(high));
		numbers.set(high, temp);
		return i + 1;
	}
}

public class Context {
	
	private SortingStrategy sortingStrategy;
	public Context(SortingStrategy sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}
	public void setSortingStrategy(SortingStrategy sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}
	public void sort(List<Integer> numbers) {
		sortingStrategy.sort(numbers);
	}

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(6,4,9,3,5,1,0,7,8));
		Context context = new Context(new BubbleSortStrategy());
		context.sort(numbers);
		System.out.println("Sorted using Bubble Sort: " + numbers);
		
		numbers = new ArrayList<>(Arrays.asList(6,4,9,3,5,1,0,7,8));
		context.setSortingStrategy(new BubbleSortStrategy());
		context.sort(numbers);
		System.out.println("Sorted using Quick Sort: " + numbers);

	}
	

}
