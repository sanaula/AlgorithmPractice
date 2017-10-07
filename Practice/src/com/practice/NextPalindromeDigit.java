package com.practice;

public class NextPalindromeDigit {

	public static void main(String[] args) throws java.lang.Exception{
		NextPalindromeDigit myClass = new NextPalindromeDigit();
		long digit = 72;
		
		while(true) {
			digit++;
			String str = String.valueOf(digit);
			if(myClass.checkPal(str, 0 , str.length() - 1)) {
				System.out.println("Next Palidrome is : " + digit);
				break;
			}
		}
//		Scanner scanner = new Scanner(System.in);
//		int n = Integer.parseInt(scanner.nextLine());
//		for(int i = 0; i < n; i++) {
//			 int digit = Integer.parseInt(scanner.nextLine());
//			 boolean result = myClass.checkPalindrome(digit);
//			 System.out.println(result ? "String is palindrome." : "String is not palindrome");
//		}
	}

	private boolean checkPal(String str, int i, int j) {
		if(i > j) return false;
		if(str.charAt(i) != str.charAt(j)) return false;
		checkPal(str, i + 1, j - 1);
		return true;
	}
	private boolean checkPalindrome(long digit) {
		if(digit <= 0) return false;
		String str = String.valueOf(digit);
		int i = 0, j = str.length() - 1;
		while(j >= i) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
}
