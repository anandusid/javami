package com.example.JOB4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {

	public static void main(final String[] args) {
		final List<String> stringArrayList = new ArrayList<>(Arrays.asList("abc", "bcd", "adb"));

		stringArrayList.add(0, "123");
		System.out.println(stringArrayList);

		final int[] numbers = { 10, 20, 30, 40, 50 };

		final int[] numbersArray = new int[5];

		final StudentArray[] numbersIntegerArray = new StudentArray[5];
		numbersIntegerArray[0] = new StudentArray(1, "anandu");

		System.out.println(numbersIntegerArray[0].toString());

	}
}
