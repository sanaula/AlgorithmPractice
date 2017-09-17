package com.practice;

public class HeapProblem {

	private static int HEAP_MAX_SIZE = 100;
	private static int heapLength = 0;
	private static int[] heapArray = new int[HEAP_MAX_SIZE];
	
	public static void main(String[] args) {
		int[] input = {10, 2, 86, 202, 50, 29, 157};
		HeapProblem hClass = new HeapProblem();
		for(int i = 0; i < input.length; i++) {
			hClass.add(input[i]);
		}
		hClass.printArray();
		hClass.getMin();
		hClass.printArray();
	}
	
	private void add(int data) {
		heapArray[heapLength++] = data;
		heapify();
	}
	
	private void heapify() {
		for (int i = heapLength / 2 - 1; i >= 0; i--)
            heapify(heapLength, i);
		
		for(int i = heapLength -1 ; i >= 0; i--) {
			int temp = heapArray[i];
			heapArray[i] = heapArray[0];
			heapArray[0] = temp;
			heapify(i, 0);
		}
	}

	private void heapify(int n, int i) {
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < n && heapArray[left] < heapArray[smallest])
			smallest = left;
		if(right < n && heapArray[right] < heapArray[smallest])
			smallest = right;
		
		if(smallest != i) {
			int temp = heapArray[i];
			heapArray[i] = heapArray[smallest];
			heapArray[smallest] = temp;
			heapify(n, smallest);
		}
		
	}

	private int getMin() {
		int data = heapArray[heapLength--];
		heapify();
		return data;
	}
	
	private void printArray() {
		for(int i = 0; i < heapLength; i++) {
			System.out.print(heapArray[i] + " ");
		}
		System.out.println();
	}
}
