package com.day16;
import java.util.*;

public class KruskalAlgorithm {
	static class Edge implements Comparable <Edge>{
		int src,dest,weight;
		public Edge(int src,int dest,int weight) {
			this.src = src;
			this.dest= dest;
			this.weight = weight;
		}
		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	}
	class Subset{
		int parent,rank;
		public Subset(int parent,int rank) {
			this.parent= parent;
			this.rank = rank;
		}
	}
	int V,E;
	Edge edge[];
	KruskalAlgorithm(int v, int e){
		V= v;
		E = e;
		edge = new Edge[E];
	}
	int find(Subset subsets[], int i) {
		if(subsets[i].parent!=i) {
			subsets[i].parent = find(subsets,subsets[i].parent);
		}
		return subsets[i].parent;
	}
	void union(Subset subsets[],int x,int y) {
		int rootX = find(subsets,x);
		int rootY = find(subsets,y);
		if(subsets[rootX].rank < subsets[rootY].rank)
			subsets[rootX].parent = rootY;
		else if(subsets[rootX].rank > subsets[rootY].rank)
			subsets[rootY].parent = rootX;
		else {
			subsets[rootY].parent = rootX;
			subsets[rootX].rank++;
		}
	}
	void KruskalMST() {
		Edge result[] = new Edge[V-1];
		int e =0;
		int i = 0;
		Arrays.sort(edge);
		Subset subsets[] = new Subset[V];
		for(int v=0; v<V;++v) {
			subsets[v] = new Subset(v,0);
		}
		while(e<V-1) {
			Edge nextEdge = edge[i++];
			int x = find(subsets,nextEdge.src);
			int y = find(subsets,nextEdge.dest);
			if(x!=y) {
				result[e++] = nextEdge;
				union(subsets,x,y);
			}
		}
		System.out.println("Edges in the Minimum Spanning Tree(MST)");
		for(i= 0; i<e;++i) {
			System.out.println(result[i].src + "--" +result[i].dest+ "==" + result[i].weight);
		}
	}

	public static void main(String[] args) {
		int V = 4;
		int E = 5;
		KruskalAlgorithm graph = new KruskalAlgorithm(V,E);
		graph.edge[0] = new Edge(0,1,1);
		graph.edge[1] = new Edge(0,2,3);
		graph.edge[2] = new Edge(1,2,3);
		graph.edge[3] = new Edge(1,3,6);
		graph.edge[4] = new Edge(2,3,4) ;
		
		graph.KruskalMST();
	}

}
	

	

