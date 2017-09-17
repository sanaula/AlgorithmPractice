package com.practice;

public class NextPalindromeDigit {

	public static void main(String[] args) {
		long digit = 12321;
		NextPalindromeDigit myClass = new NextPalindromeDigit();
		boolean result = myClass.checkPalindrome(digit);
		System.out.println(result ? "String is palindrome." : "String is not palindrome");
	}

	private boolean checkPalindrome(long digit) {
		if(digit <= 0) return false;
		String str = String.valueOf(digit);
		int i = 0, j = str.length() - 1;
		
		while(j >= i) {
			if(str.charAt(i) == str.charAt(j)) {
				return true;
			}
			i++;
			j--;
		}
		
		return false;
	}
}