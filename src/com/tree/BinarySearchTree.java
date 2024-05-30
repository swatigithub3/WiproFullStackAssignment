package com.tree;

public class BinarySearchTree {
	class Node{
		int key;
		Node left, right;
		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	Node root;
	BinarySearchTree(){
		root = null;
	}
	void insert(int key) {
		root = insert(root,key);
	}
	Node insert(Node root, int val) {
		if(root == null) {
			root = new Node(val);
			return root;
		}
		if(val < root.key)
			root.left = insert(root.left,val);
		else if(val > root.key)
			root.right = insert(root.right,val);
		return root;
	}
	
	void inOrder(Node root) {
		if(root!= null) {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}
	public Node search(Node root, int val) {
		if(root == null || root.key == val)
			return root;
		if(val < root.key)
			return search(root.left,val);
		else
			return search(root.right,val);
	}
	void preOrder(Node root) {
		if(root!= null) {
			
			System.out.print(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
		void postOrder(Node root) {
			if(root!= null) {
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.key + " ");
			}
		}
		public Node delete(Node root, int val) {
			if(root == null)
				return root;
			if(val < root.key)
				root.left =delete(root.left,val);
			else if(val > root.key)
				root.left =delete(root.right,val);
			else {
				if(root.left == null)
					return root.right;
				else if(root.right == null)
					return root.left;
				root.key = min(root.right);
				root.right = delete(root.right,root.key);
			}
			return root;
		}
		public int min(Node root) {
			int minVal = root.key;
			while(root.left != null) {
				minVal = root.left.key;
				root = root.left;
			}
			return minVal;
		}


}
