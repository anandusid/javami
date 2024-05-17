package com.example.JOB4;

public class Palindrome {
	public static void main(final String[] args) {

		final String var = "MALAYALAM";
		final int n = var.length();

		final char[] varChar = var.toCharArray();

		for (int i = 0; i < n / 2; i++) {
			final char temp = varChar[i];
			varChar[i] = varChar[n - 1 - i];
			varChar[n - 1 - i] = temp;
		}
		final String reel = String.valueOf(varChar);
		if (reel.equals(var)) {
			System.out.println("Palindrom");
		} else {
			System.out.println("Not Palindrom");
		}
	}

}
