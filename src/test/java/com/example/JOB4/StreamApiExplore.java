package com.example.JOB4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiExplore {

	public static void main(final String[] args) {
		final List<Integer> numbers = List.of(3, 2, 6, 1, 2, 2, 3, 4, 4, 5);
		final List<String> fruitListWithDummy = Arrays.asList("Orange", "Mango", "Apple", "Jackfruit", "Guva", "Mango");
		final List<String> strings = List.of("apple", "banana", "pear", "orange", "kiwi", "grape");
		final List<String> stringsa = List.of("apple", "banana", "pear");

		final List<String> stringsI = List.of("1234567", "9876543", "2345678");

		final var stringObj = "India is my country , Pakisthan is my negbour company";

		final Map<Integer, Long> fruitLengthandCountMap = fruitListWithDummy.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(fruitLengthandCountMap);
	}
}
