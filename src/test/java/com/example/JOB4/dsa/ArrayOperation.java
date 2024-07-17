package com.example.JOB4.dsa;

public class ArrayOperation {

	public static void main(final String[] args) {
		findSecondLargest();
	}

	private static void findSecondLargest() {
		final int arr[] = { 4, 3, 1, 6, 5, 8, 2 };

		int first = 0;
		int second = 0;

		for (final int element : arr) {
			if (element > first) {
				second = first;
				first = element;

			} else if (element < first && element > second) {
				second = element;
			}
		}

		System.out.println("second largest" + second);
		System.out.println("first largest" + first);

	}
}
