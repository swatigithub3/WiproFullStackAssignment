package com.graph;
import java.util.*;

public class BFS {
	private int vertices;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public BFS(int vertices) {
		this.vertices = vertices;
		adj = new LinkedList[vertices];
		for(int i = 0; i < vertices; i++){
			adj[i] = new LinkedList<>();
	    }
	}
	public void addEdge(int x,int y) {
		adj[x].add(y);
	}
	public void bfs(int startVertex) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[startVertex] = true;
		queue.add(startVertex);
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			for(int neighbor : adj[vertex]) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}

}
