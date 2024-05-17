package com.example.JOB4;

public class ReverseString {

	public static void main(final String[] args) {
		final String obj = "Hello";
		final char[] charArray = obj.toCharArray();
		for (int i = 0; i < obj.length() / 2; i++) {
			final char temp = obj.charAt(i);
			charArray[i] = charArray[obj.length() - 1 - i];
			charArray[obj.length() - 1 - i] = temp;

		}
		System.out.println(new String(charArray));
	}

}
