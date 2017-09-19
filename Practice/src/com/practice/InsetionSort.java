package com.practice;

public class InsetionSort {
	public static void main(String[] args) {
		int[] input = { 4, 10, 3, 5, 1 };
		int n = input.length;
		
		for(int i = 0; i < n; i++) { //taking each element a time
			int temp = input[i]; // take out the data before rearranging value
			int j = i - 1; // index from where back searching will start
			while(j >= 0 && input[j] > temp) {
				input[j + 1] = input[j]; // copy data to next block
				j--;
			}
			input[j + 1] = temp; // fill this empty position with our saved data
		}
		for (int i = 0; i < n; ++i) {
			System.out.print(input[i] + " ");
		}
	}
}
