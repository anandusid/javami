package com.example.JOB4.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamAPIJun18 {
	public static void main(final String[] args) {

		final List<Integer> numbers = List.of(3, 2, 6, 1, 2, 2, 3, 4, 4, 5);
		final List<String> fruitListWithDummy = Arrays.asList("Orange", "Mango", "Apple", "Jackfruit", "Guva", "Mango");
		final List<String> strings = List.of("apple", "banana", "pear", "orange", "kiwi", "grape");
		final List<String> stringsa = List.of("apple", "banana", "pear");

		map();
//		concateString(fruitListWithDummy);

//		findSumOfList(numbers);

		sortNumberinAsc(numbers);

	}

	private static void map() {
		final Map<String, Integer> mapObj = new HashMap<>();
		mapObj.put("abc", 1);
		mapObj.put("abc", 2);

	}

	private static void sortNumberinAsc(final List<Integer> numbers) {
		numbers.stream().sorted(Comparator.naturalOrder());

	}

	private static void findSumOfList(final List<Integer> numbers) {

		final var s = numbers.stream().mapToInt(Integer::valueOf).sum();
		System.out.println(s);

	}

	private static void concateString(final List<String> fruitListWithDummy) {

		System.out.println(fruitListWithDummy.stream().filter(null));

	}
}
