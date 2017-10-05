package com.practice;

public class BinaryTree {
	Node root;
	public static void main(String args[]) {
		/*
		 * Constructed binary tree is   10 
		 *                            /   \ 
		 *                            8    2 
		 *                           / \   / 
		 *                           3  5 2
		 */
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		int[] path = new int[10];
//		tree.pathSum(tree.root, path, 0);
		tree.printRightSubTree(tree.root, tree.root);
	}
	private void printRightSubTree(Node node, Node main) {
		if(node == null) return;
		
		System.out.println(node.data);
		if(node != main)
			printRightSubTree(node.left, main);
		printRightSubTree(node.right, main);
	}
	private void pathSum(Node node, int[] path, int cur) {
		if(node == null) return;
		path[cur++] = node.data;
		if(node.left == null && node.right == null)
			printArray(path, cur);
		pathSum(node.left, path, cur);
		pathSum(node.right, path, cur);
	}
	private void printArray(int[] path, int len) {
		int sum = 0;
		for(int i = 0; i < len; i++) {
			sum += path[i];
		}
		System.out.print(sum + "  ");
	}
}
class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
