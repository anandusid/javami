package com.example.JOB4.tcs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayStreamOperation {

	// method for check SET

	public static void main(final String[] args) {

//		findDuplicate();
//		findLength();
//		findMax();
//		findFirstNotRepeatedChar();
//		sortNumbers();
//		sortNumberDescending();
//		findEvenNumbersInArray();
//		findCube();
		findPrimeNumber();

	}

	private static void findPrimeNumber() {
		Arrays.asList(4, 5, 6, 7, 1, 2, 3, 9).stream().filter(ArrayStreamOperation::isPrime).forEach(System.out::println);

	}

	private static boolean isPrime(final int n) {
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return false;
	}

	private static void findCube() {
		Arrays.asList(4, 5, 6, 7, 1, 2, 3).stream().map(m -> m * m * m).filter(n -> n > 50)
				.forEach(System.out::println);

	}

	private static void findEvenNumbersInArray() {
		final String[] number = { "1", "2", "3", "4" };
		Arrays.asList(number).stream().map(Integer::valueOf).filter(b -> b % 2 == 0)
				.forEach(a -> System.out.println(a));

	}

	private static void sortNumberDescending() {
		final List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

	}

	private static void sortNumbers() {
		final List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		myList.stream().sorted(Integer::compare).forEach(System.out::println);

	}

	private static void findFirstNotRepeatedChar() {
		final String input = "Java articles are Awesome";

		System.out.println(input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).findFirst());

	}

	private static void findMax() {
		final List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		final Integer maxNumber = myList.stream().max(Integer::compare).get();

	}

	private static void findLength() {
		final List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		final Long count = myList.stream().count();
		System.out.println(count);

	}

	// FIND Duplicate
	private static void findDuplicate() {
		final List<Integer> i = List.of(2, 4, 3, 6, 7, 4, 9);

		final Set<Integer> set = new HashSet<>();

		final List<Integer> abc = i.stream().filter(s -> !set.add(s)).collect(Collectors.toList());
		System.out.println(abc);

	}

}
