package com.practice;

public class BinarySearchTree {
	Node root;
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(11);
		bst.insert(12);
		bst.preorder();
		System.out.println(bst.search(15) ? "Present" : "Not present");
		
		bst.delete(12);
		bst.preorder();
	}
	
	private void delete(int key) {
		root = delete(root, key);
	}
	private Node delete(Node node, int key) {
		if(node == null) return node;
		
		if(key < node.data)
			node.left = delete(node.left, key);
		else if(key > node.data)
			node.right = delete(node.right, key);
		else {
			if(node.left == null) return node.right;
			else if(node.right == null) return node.left;
			
			node.data = min(node.right);
			node.right = delete(node.right, node.data);
		}
		
		return node;
	}

	private int min(Node node) {
		int min = node.data;
		while(node.left != null) {
			min = node.left.data;
			node = node.left;
		}
		return min;
	}

	private boolean search(int key) {
		return search(root, key) != null;
	}
	private Node search(Node node, int key) {
		if(node == null || node.data == key) return node;
		
		if(key < node.data) {
			return search(node.left, key);
		}
		return search(node.right, key);
	}
	
//	private boolean search(Node node, int key) {
//		if(node == null) return false;
//		boolean first = false, second = false;
//		if(key == node.data) return true;
//		if(key < node.data) {
//			first = search(node.left, key);
//		}
//		else if(key > node.data) {
//			second = search(node.right, key);
//		}
//		return first || second;
//	}
	private void insert(int val) {
		root = insert(root, val);
	}
	private Node insert(Node node, int key) {
		if(node == null) {
			node = new Node(key);
			return node;
		}
		
		if(key < node.data) {
			node.left = insert(node.left, key);
		}
		else if(key > node.data){
			node.right = insert(node.right, key);
		}
		return node;
	}
	
	private void preorder() {
		Node node = root;
		preorder(node);
	}
	private void preorder(Node node) {
		if(node == null) return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
}
