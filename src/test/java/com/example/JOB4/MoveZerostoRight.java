package com.example.JOB4;

public class MoveZerostoRight {

	public static void main(final String[] args) {
		final int[] numberArray = { 0, 3, 4, 2, 5, 2, 6, 10, 4, 0 };

		final int index = 0;
		for (int i = 0; i < numberArray.length; i++) {

			if (numberArray[i] != 0) {

				numberArray[index] = numberArray[i];
			}

		}
		for (final int num : numberArray) {
			System.out.print(num + " ");
		}
	}

}
