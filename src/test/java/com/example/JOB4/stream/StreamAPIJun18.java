package com.example.JOB4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIJun18 {
	public static void main(final String[] args) {

		final List<Integer> numbers = List.of(3, 2, 6, 1, 2, 2, 3, 4, 4, 5);
		final List<String> fruitListWithDummy = Arrays.asList("Orange", "Mango", "Apple", "Jackfruit", "Guva", "Mango");
		final List<String> strings = List.of("apple", "banana", "pear", "orange", "kiwi", "grape");
		final List<String> stringsa = List.of("apple", "banana", "pear");

		final List<String> stringsI = List.of("1234567", "9876543", "2345678");

		final var stringObj = "India is my country , Pakisthan is my negbour company";

		final List<Character> integerList = stringsI.stream().flatMap(s -> s.chars().mapToObj(i -> (char) i))
				.collect(Collectors.toList());
		integerList.stream().forEach(System.out::println);
		final List<String> words = Arrays.asList("apple", "banana", "cherry");

		final List<Integer> lengths = words.stream().map(String::length).collect(Collectors.toList());
		final List<String> appleList = words.stream().filter(a -> a.startsWith("a")).collect(Collectors.toList());
		System.out.println(appleList);

	}
}
