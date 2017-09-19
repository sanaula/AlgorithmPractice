package com.practice;

public class HeapMethods {
	private static final int MAX_HEAP_SIZE = 100;
	private int[] heapArray = new int[MAX_HEAP_SIZE];
	private static int heapLength;

	public static void main(String[] args) {
		int[] input = { 4, 10, 3, 5, 1 };

		HeapMethods hFun = new HeapMethods();

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
            int prev = heapLength - 1;
            int i = getParent(prev);
            while(i >= 0){
                if(heapArray[prev] < heapArray[i]){
                    int temp = heapArray[prev];
                    heapArray[prev] = heapArray[i];
                    heapArray[i] = temp;
                }
                else break;
                prev = i;
                i = getParent(i);
            }
		}
	}
	
	private int getParent(int index){
		return (index + 1) / 2 - 1;
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
