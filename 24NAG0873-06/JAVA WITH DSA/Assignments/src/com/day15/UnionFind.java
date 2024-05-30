package com.day15;

public class UnionFind {
	int[] parent;
	int[] rank;
	public UnionFind(int size) {
		parent = new int[size];
		rank = new int[size];
		for(int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	public int find(int x) {
		if(parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	public boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX == rootY) {
			return false;
		}
		if(rank[rootX] > rank[rootY]) {
			parent[rootY] = rootX;
		}
		else if(rank[rootX] < rank[rootY]) {
			parent[rootX] = rootY;
		}
		else {
			parent[rootY] = rootX;
			rank[rootX]++;
		}
		return true;
	}
	public boolean hasCycle(int[][] edges) {
		for(int[] edge: edges) {
			int u = edge[0];
			int v= edge[1];
			int rootU = find(u);
			int rootV = find(v);
			if(rootU == rootV) {
				return true;
			}
			union(u,v);
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,1}};
		UnionFind uf = new UnionFind(5);
		if(uf.hasCycle(edges)) {
			System.out.println("Graph contains a cycle");
		} else {
			System.out.println("Graph does not contain a cycle");
		}

	}

}
