package com.example.JOB4;

public class SwapTest {

	public static void main(final String[] args) {

		int a = 10, b = 20;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("a :" + a + " b: " + b);
	}
}
