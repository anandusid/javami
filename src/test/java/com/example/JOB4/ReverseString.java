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
//		drawTriangel();
//		drawTriangelR();
		drawPyramid();
	}

	private static void drawPyramid() {
		final int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	private static void drawTriangelR() {
		final int n = 5;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	private static void drawTriangel() {

		final int n = 5;
		for (int i = 1; i < n; i++) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
