package com.day14;
import java.util.*;

public class DFS {
	private int V;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	DFS(int v){
		V= v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	void dfsUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for(int i = 0; i < adj[v].size(); i++) {
			int n = adj[v].get(i);
			if(!visited[n]) {
				dfsUtil(n,visited);
			}
		}
	}
	void dfs() {
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; ++i) {
			if(!visited[i])
				dfsUtil(i,visited);
		}
	}

	public static void main(String[] args) {
		DFS graph =new DFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		System.out.println("Depth First Search: ");
		graph.dfs();

	}

}
