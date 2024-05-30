package com.day13;


public class MinHeap {
	private int[] heap;
	private int size;
	private int capacity;
	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.size= 0;
		this.heap = new int[capacity];
	}
	private int parent(int i) {
		return (i-1)/2;
	}
	private int leftChild(int i) {
		return 2*i+1;
	}
	private int rightChild(int i) {
		return 2*i+2;
	}
	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	private void heapifyUp(int i) {
		while(i != 0 && heap[parent(i)]> heap[i]) {
			swap(i,parent(i));
			i = parent(i);
		}
	}
	public void heapifyDown(int i) {
		int smallest = i;
		int left = leftChild(i);
		int right = rightChild(i);
		if(left < size && heap[left] < heap[smallest]) {
			smallest = left;
		}
		if(right < size && heap[right]< heap[smallest]) {
			smallest = right;
		}
		if(smallest != i) {
			swap(i,smallest);
			heapifyDown(smallest);
		}
	}
	public void insert(int element) {
		if(size == capacity) {
			throw new IllegalStateException("Heap is Full");
		}
		heap[size] = element;
		size ++;
		heapifyUp(size - 1);
	}
	public int deleteMin() {
		if(size == 0) {
			throw new IllegalStateException("Heap is Empty");
		}
		int minElement = heap[0];
		heap[0] = heap[size -1];
		size--;
		heapifyDown(0);
		return minElement;
	}
	public int getMin() {
		if(size == 0) {
			throw new IllegalStateException("Heap is Empty");
		}
		
		return heap[0];
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(10);
		minHeap.insert(3);
		minHeap.insert(2);
		minHeap.insert(1);
		minHeap.insert(5);
		minHeap.insert(4);
		System.out.println("Minimum element: " + minHeap.getMin());
		System.out.println("Deleted minimum element: " + minHeap.deleteMin());
		System.out.println("New minimum element: " + minHeap.getMin());

	}

}
