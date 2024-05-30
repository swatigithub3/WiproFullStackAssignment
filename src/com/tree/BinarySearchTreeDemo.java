package com.tree;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(bst.root,20);
		bst.insert(10);
		bst.insert(50);
		bst.insert(46);
		bst.insert(90);
		bst.insert(17);
		bst.insert(5);
		System.out.println("In Order Traversal:");
		bst.inOrder(bst.root);
		System.out.println("\nPre Order Traversal:");
		bst.preOrder(bst.root);
		System.out.println("\nPost Order Traversal:");
		bst.postOrder(bst.root);
		if(bst.search(bst.root, 50)==null)
			System.out.println("Not found");
		else
			System.out.println("\nFound");

	}

}
