package com.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.insertLeft(tree.root,2);
		tree.insertRight(tree.root,3);
		tree.insertLeft(tree.root.left,4);
		tree.insertRight(tree.root.left,5);
		tree.insertLeft(tree.root.right,6);
		System.out.print("Pre Order Traversal: ");
		BinaryTree.preOrder(tree.root);
		System.out.print("\nIn Order Traversal: ");
		BinaryTree.inOrder(tree.root);
		System.out.print("\nPost Order Traversal: ");
		BinaryTree.postOrder(tree.root);
		
		

	}

}
