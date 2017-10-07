package com.practice;
//Search in a row wise and column wise sorted matrix
public class BSMartixCRSorted {
	public static void main(String[] args) {
		int mat[][] = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 50}};
		int n = 4;
		int key = 100;
		boolean result = search(mat, n, key);
		System.out.println(result ? "Key is present" : "Key is not present");
	}

	private static boolean search(int[][] mat, int n, int key) {
		int i = 0; int j = n - 1;
		while(i < n && j >= 0) {
			if(key == mat[i][j]) return true;
			if(key < mat[i][j])
				j--;
			else if(key > mat[i][j])
				i++;
		}
		return false;
	}
}
