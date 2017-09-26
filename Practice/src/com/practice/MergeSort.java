package com.practice;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 4, 10, 3, 5, 1 };
		int n = arr.length;
		MergeSort mSort = new MergeSort();
		mSort.sort(arr, 0, n - 1);
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

	private void sort(int[] arr, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			sort(arr, 0, mid);
			sort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private void merge(int[] arr, int low, int mid, int high) {
		int len1 = mid - low + 1;
		int len2 = high - mid;
		
		int A[] = new int[len1];
		int B[] = new int[len2];
		
		for(int i = 0; i < len1; i++)
			A[i] = arr[low + i];
		for(int i = 0; i < len2; i++)
			B[i] = arr[mid + 1 + i];
		
		int i = 0, j = 0, k = low;
		while(i < len1 && j < len2) {
			if(A[i] <= B[j]) {
				arr[k] = A[i];
				i++;
			}
			else {
				arr[k] = B[j];
				j++;
			}
			k++;
		}
		while(i < len1) {
			arr[k] = A[i];
			i++;
			k++;
		}
		while(j < len2) {
			arr[k] = B[j];
			j++;
			k++;
		}
	}
}
