package com.practice;

public class HeapFunction {

	private static final int MAX_HEAP_SIZE = 100;
	private int[] heapArray = new int[MAX_HEAP_SIZE];
	private static int heapLength;

	public static void main(String[] args) {
		int[] input = { 4, 10, 3, 5, 1 };

		HeapFunction hFun = new HeapFunction();

		for (int i = 0; i < input.length; i++) {
			hFun.add(input[i]);
		}
		hFun.printArray();
		System.out.println("Extract Min : " + hFun.getMin());
		hFun.printArray();
	}

	private void add(int data) {
		if (heapLength < MAX_HEAP_SIZE - 1) {
			heapArray[heapLength++] = data;
			for (int i = (heapLength / 2) - 1; i >= 0; i--) {
				heapify(heapLength, i);
			}
		}
	}

	private int getMin() {
		int temp = -1;
		if(heapLength > 0){
			temp = heapArray[0];
			heapArray[0] = heapArray[--heapLength];
			heapify(heapLength, 0);
		}
		return temp;
	}

	private void heapify(int len, int index) {
		int smallest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		if (left < len && heapArray[left] < heapArray[smallest])
			smallest = left;
		if (right < len && heapArray[right] < heapArray[smallest])
			smallest = right;

		if (smallest != index) {
			int temp = heapArray[smallest];
			heapArray[smallest] = heapArray[index];
			heapArray[index] = temp;

			heapify(len, smallest);
		}
	}

	private void printArray() {
		for (int i = 0; i < heapLength; ++i) {
			System.out.print(heapArray[i] + " ");
		}
		System.out.println();
	}
}