package com.day15;
import java.util.*;
public class Dijkstra {
	private List<List<Edge>> adjList;
	static class Edge{
		int target;
		int weight;
		Edge(int target, int weight){
			this.target= target;
			this.weight= weight;
		}
	}
		
	public Dijkstra(int numNodes){
			adjList = new ArrayList<>(numNodes);
			for(int i = 0; i < numNodes; i++) {
				adjList.add(new ArrayList<>());
			}
		}
		void addEdge(int source,int target, int weight) {
			adjList.get(source).add(new Edge(target,weight));
			adjList.get(target).add(new Edge(source,weight));
	}
		public int[] dijkstra(int startNode) {
			int numNodes = adjList.size();
			int[] distances = new int[numNodes];
			Arrays.fill(distances,Integer.MAX_VALUE);
			distances[startNode] =0;
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
			pq.add(new int[] {startNode, 0});
			while(!pq.isEmpty()) {
				int[] current = pq.poll();
				int node = current[0];
				int distance = current[1];
				if(distance > distances[node])
					continue;
				for(Edge edge: adjList.get(node)) {
					int newDist = distance +edge.weight;
					if(newDist < distances[edge.target]) {
						distances[edge.target] = newDist;
						pq.add(new int[] {edge.target,newDist});
					}
				}
			}
			return distances;
		}
	

	public static void main(String[] args) {
		Dijkstra graph = new Dijkstra(5);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 4, 5);
		graph.addEdge(1, 2, 1);
		graph.addEdge(4, 1, 3);
		graph.addEdge(4, 2, 9);
		graph.addEdge(4, 3, 2);
		graph.addEdge(2, 3, 4);
		graph.addEdge(3, 2, 6);
		graph.addEdge(3, 0, 7);
		int[] shortestPaths = graph.dijkstra(0);
		System.out.println("Shortest path from node 0: ");
		for(int i =0; i < shortestPaths.length;i++) {
			System.out.println("To node " + i + " - Distance: " + shortestPaths[i]);
		}
		
		

	}

}
