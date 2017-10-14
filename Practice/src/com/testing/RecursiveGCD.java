package com.testing;

public class RecursiveGCD {

	public static void main(String[] args) {
		int arr[] = {4, 8, 12};
        int n = arr.length;
        System.out.println("GCD is : "  + findGCDRec(arr, n));
	}

	private static int findGCD(int[] arr, int n) {
		int result = arr[0];
		for(int i = 1; i < n; i++) {
			result = GCD(result, arr[i]);
		}
		return result;
	}
	
	private static int findGCDRec(int[] arr, int n) {
		if(n == 2)
			return GCD(arr[n - 1], arr[n - 2]);
		return GCD(arr[n - 1], findGCDRec(arr, n - 1));
	}

	private static int GCD(int a, int b) {
		if(a == 0) return b;
		return GCD(b % a, a);
	}
}
