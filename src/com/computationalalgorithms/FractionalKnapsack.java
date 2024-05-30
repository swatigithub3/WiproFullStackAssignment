package com.computationalalgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
	static class Item{
		int value, weight;
		Item(int value, int weight){
			this.value = value;
			this.weight = weight;
		}
	}
	public static double fractionalKnapsack(Item[] items, int capacity) {
		Arrays.sort(items, new Comparator<Item>(){
			@Override
			public int compare(Item o1, Item o2) {
				double r1 = (double) o1.value / o1.weight;
				double r2 = (double) o2.value / o2.weight;
				return Double.compare(r2, r1);
			}
		});
		double totalValue = 0.0;
		for(Item item : items) {
			if(capacity >= item.weight) {
				capacity -= item.weight;
			}else {
				totalValue += (double) item.value * capacity / item.weight;
				break;
			}
		}
		return totalValue;
	}

	public static void main(String[] args) {
		Item[] items = { 
				new Item(60, 10),
				new Item(100,20),
				new Item(120,30)
		};
		int capacity = 50;
		System.out.println("Maximum value in Knapsack: " + fractionalKnapsack(items, capacity));
		}

	}


