package com.example.JOB4.tcs;

import java.util.Arrays;

public class SortTemp {

	public static void main(final String[] args) {
		final int[] integerList = { 2, 5, 4, 7, 8, 1 };

		for (int i = 0; i < integerList.length - 1; i++) {
			int minindx = i;
			for (int j = 1 + i; j < integerList.length; j++) {
				if (integerList[j] < integerList[minindx]) {
					minindx = j;
				}

			}
			final int temp = integerList[minindx];

			integerList[minindx] = integerList[i];
			integerList[i] = temp;
		}
		System.out.println(Arrays.toString(integerList));

	}
}
