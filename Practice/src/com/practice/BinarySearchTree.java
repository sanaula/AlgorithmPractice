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
