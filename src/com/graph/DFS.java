package com.graph;
import java.util.*;
public class DFS {
	private int vertices;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public DFS(int vertices) {
		this.vertices = vertices;
		adj = new LinkedList[vertices];
		for(int i = 0; i < vertices; i++){
			adj[i] = new LinkedList<>();
	    }
	}
	public void addEdge(int x,int y) {
		adj[x].add(y);
	}
	public void dfs(int startVertex) {
		boolean[] visited = new boolean[vertices];
		dfs2(startVertex, visited);
	}
		private void dfs2(int vertex, boolean[] visited) {
		    visited[vertex] = true;
		    System.out.print(vertex + " ");
			for(int neighbor : adj[vertex]) {
				if(!visited[neighbor]) {
					dfs2(neighbor, visited);
				}
			}
		}
	}


