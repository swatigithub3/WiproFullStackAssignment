package com.day14;
import java.util.*;

public class BFS {
	private int V;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	BFS(int v){
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
	void bfs(int sv) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[sv] = true;
		queue.add(sv);
		while(!queue.isEmpty()) {
			sv = queue.poll();
			System.out.print(sv + " ");
			for(int i = 0; i < adj[sv].size(); i++) {
				int n = adj[sv].get(i);
			    if(!visited[n]) {
			    	visited[n] = true;
					queue.add(n);
			    }
			    
			}
		}
	}

	public static void main(String[] args) {
		BFS graph = new BFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println("Breadth First Search starting from vertex 1 : ");
		graph.bfs(1);

		

	}

}
