package com.computationalalgorithms;

public class TowerOfHanoi {
	public static void solveHanoi(int n, char fromRod, char auxRod, char toRod) {
		if(n==1) {
			System.out.println("Move disk 1 from rod "+ fromRod + " to rod " +toRod);
			return;
		}
		solveHanoi(n-1, fromRod, toRod, auxRod);
		System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
		solveHanoi(n-1, auxRod, fromRod, toRod);
	}

	public static void main(String[] args) {
		int numberOfDisks = 3;
		solveHanoi(numberOfDisks, 'A', 'B', 'C');

	}

}
