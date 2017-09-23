package com.practice;

public class BinarySearchRotated {

	public static void main(String[] args) {
		int[] arr = {5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4};
		int ret = search(arr, 0, arr.length - 1, 3);
		if(ret == -1)
			System.out.println("Key not found");
		else
			System.out.println("Key found at : " + ret);
	}

	private static int search(int[] arr, int low, int high, int key) {
		
		if(low > high) return -1;
		int mid = (low + high) / 2;
		if(key == arr[mid]) return mid;

		if(arr[low] <= arr[mid]) {
			//SORTED ARRAY
			if(key >= arr[low] && key <= arr[high])
				return search(arr, low, mid - 1, key);
			return search(arr, mid + 1, high, key);
		}
		
		//UNSORTED
		
		if(key >= arr[mid] && key <= arr[high])
			return search(arr, mid + 1, high, key);
		return search(arr, low, mid - 1, key);
	}
}
