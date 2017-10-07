package com.testing;

public class MultiplyUsingRecursion {

	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		System.out.println("Multiplication of " + a + " and " + b +" is : " + multiply(5, 3));
	}

	private static int multiply(int i, int j) {
		if(j <= 0) return 0;
		return i + multiply(i, j - 1);
	}
}
