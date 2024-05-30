package com.graph;

public class GraphRepresentation {

	public static void main(String[] args) {
		//int[][] gr = {{0,1,0,0,1},{1,0,1,0,1},{0,1,0,1,0},{0,0,1,0,1},{1,1,0,1,0}};
		Graph gp = new Graph(5);
		gp.addEdge(0,1);
		gp.addEdge(2,3);
		gp.addEdge(1,2);
		gp.addEdge(3,4);
		gp.addEdge(0,4);
		gp.addEdge(1,4);
		gp.printAdjList	();
		
		//BFS
		BFS graph = new BFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		System.out.println("Breadth First Search Starts from vertex 0: ");
		graph.bfs(0);
		
		//DFS
		DFS g = new DFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("\nDepth First Search Starts from vertex 0: ");
		g.dfs(0);

	}

}
