package com.practice;

import java.util.Stack;

public class BinaryTree {
	Node root;

	public static void main(String args[]) {
		/*
		 * Constructed binary tree is 10 / \ 8 2 / \ / 3 5 2
		 */
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
//		tree.root.right.left = new Node(2);
		int[] path = new int[10];
		// tree.pathSum(tree.root, path, 0);
		//tree.printRightSubTree(tree.root, tree.root);
		tree.printSpiral(tree.root);
		boolean res = tree.isBst(tree.root);
		System.out.println(res ? "BST" : "Not Bst");
	}

	private void printSpiral(Node root) {
		if (root == null)
			return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					s2.push(temp.left);
				if (temp.right != null)
					s2.push(temp.right);
			}
			while(!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.print(temp.data + " ");
				if (temp.right != null)
					s1.push(temp.right);
				if (temp.left != null)
					s1.push(temp.left);
			}
		}
	}
	
	private boolean isBst(Node node) {
		if(node == null) return false;
		if(node.left != null && node.left.data < node.data && 
				node.right != null && node.right.data > node.data)
			return true;
		isBst(node.left);
		isBst(node.right);
		
		return false;
	}

	private void printRightSubTree(Node node, Node main) {
		if (node == null)
			return;

		System.out.println(node.data);
		if (node != main)
			printRightSubTree(node.left, main);
		printRightSubTree(node.right, main);
	}

	private void pathSum(Node node, int[] path, int cur) {
		if (node == null)
			return;
		path[cur++] = node.data;
		if (node.left == null && node.right == null)
			printArray(path, cur);
		pathSum(node.left, path, cur);
		pathSum(node.right, path, cur);
	}

	private void printArray(int[] path, int len) {
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += path[i];
		}
		System.out.print(sum + "  ");
	}
}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}
