package com.practice.linkedlist;

public class FindLoop {

	public static void main(String[] args) {
		Node head = new Node(50);
	    head.next = new Node(20);
	    head.next.next = new Node(15);
	    head.next.next.next = new Node(4);
	    head.next.next.next.next = new Node(10);
	 
	    /* Create a loop for testing */
	    head.next.next.next.next.next = head.next.next;
	 
	    detectAndRemoveLoop(head);
	 
	    System.out.println("Linked List after removing loop \n");
	    printList(head);
	}

	private static void printList(Node node) {
		while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
	}

	private static void detectAndRemoveLoop(Node head) {
		Node slow = head;
		Node fast = head;
		boolean isLoop = false;
		while(slow!= null && fast!= null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				isLoop = true;
				break;
			}
		}
		if(isLoop) {
			slow = head;
			while(slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
	}
}
class Node {
	int data;
	Node next;

	Node(int item) {
		data = item;
		next = null;
	}
}
