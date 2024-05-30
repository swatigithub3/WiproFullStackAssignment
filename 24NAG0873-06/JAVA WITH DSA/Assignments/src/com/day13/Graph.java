package com.day13;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private final List<Integer>[] adjList;
	private final int numNodes;
	@SuppressWarnings("unchecked")
	public Graph(int numNodes) {
		this.numNodes = numNodes;
		this.adjList = new ArrayList[numNodes];
		for(int i = 0; i < numNodes; i++) {
			adjList[i] = new ArrayList<>();		
		}
	}
	public boolean addEdge(int start,int end) {
		adjList[start].add(end);
		if(hasCycle()) {
			adjList[start].remove((Integer)end);
			return false;
		}
		return true;
	}
	private boolean hasCycle() {
		boolean[] visited = new boolean[numNodes];
		boolean[] recStack = new boolean[numNodes];
		for(int node = 0; node<numNodes; node++) {
			if(dfs(node,visited,recStack)) {
				return true;
			}
		}
		return false;
	}
	private boolean dfs(int node,boolean[] visited, boolean[] recStack) {
		if(recStack[node]) {
			return true;
		}
		if(visited[node]) {
			return false;
		}
		visited[node] = true;
		recStack[node] = true;
		for(Integer neighbor : adjList[node]) {
			if(dfs(neighbor,visited,recStack)) {
				return true;
			}
		}
		recStack[node] = false;
		return false;
	}

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		System.out.println(graph.addEdge(0, 1));
		System.out.println(graph.addEdge(1, 2));
		System.out.println(graph.addEdge(2, 0));
		System.out.println(graph.addEdge(2, 3));
		System.out.println(graph.addEdge(3, 0));
		

	}

}
