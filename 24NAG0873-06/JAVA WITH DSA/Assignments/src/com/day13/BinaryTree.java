package com.day13;


public class BinaryTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	public boolean isBalanced(TreeNode root) {
		return checkHeight(root) != -1;
	}
	private int checkHeight(TreeNode node) {
		if(node == null)
			return 0;
		int leftHeight = checkHeight(node.left);
		if(leftHeight == -1)
			return -1;
		int rightHeight = checkHeight(node.right);
		if(rightHeight == -1)
			return -1;
		if(Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) +1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		TreeNode rootBalanced = bt.new TreeNode(1);
		rootBalanced.left = bt.new TreeNode(2);
		rootBalanced.right = bt.new TreeNode(3);
		rootBalanced.left.left = bt.new TreeNode(4);
		rootBalanced.left.right = bt.new TreeNode(5);
		rootBalanced.right.left = bt.new TreeNode(6);
		rootBalanced.right.right = bt.new TreeNode(7);
		System.out.println("Is balanced: " + bt.isBalanced(rootBalanced));
		TreeNode rootUnbalanced = bt.new TreeNode(1);
		rootUnbalanced.left = bt.new TreeNode(2);
		rootUnbalanced.left.left = bt.new TreeNode(3);
		System.out.println("Is balanced: " + bt.isBalanced(rootUnbalanced));
		
		

	}

}

