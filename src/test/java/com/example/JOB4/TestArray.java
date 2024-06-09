package com.example.JOB4;

import java.util.Set;
import java.util.TreeSet;

public class TestArray {

	public static void main(final String[] args) {

		final int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		final int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

		final Set<Integer> sortedUnionArr = new TreeSet<>();

		for (final int element : arr1) {
			sortedUnionArr.add(element);
		}
		for (final int element : arr2) {
			sortedUnionArr.add(element);
		}
		System.out.print(sortedUnionArr);

		final String a = new String("anandu");
		final String b = "anandu";
		System.out.println(a == b);
	}

}
