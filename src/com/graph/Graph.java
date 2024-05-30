package com.graph;
import java.util.ArrayList;

public class Graph {
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	Graph(int v){
		for(int i = 0; i < v; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}
	public void addEdge(int U, int V) {
		adjList.get(U).add(V);
		adjList.get(V).add(U);
	}
	public void printAdjList() {
		for(int i = 0; i < adjList.size(); i++) {
			System.out.println("Adjlist of vertex " +i);
			for(int j = 0; j < adjList.get(i).size();j++) {
				System.out.println(" " + adjList.get(i).get(j));
			}
		}
	}

}
