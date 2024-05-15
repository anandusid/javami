package com.example.JOB4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
	public static void main(final String[] args) {

		final List<String> fruitList = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");

		// map

		final Stream<String> stream = fruitList.stream();
		final Stream<String> map = stream.map(String::toUpperCase);
		map.forEach(System.out::println);

		// filter
		final Stream<String> filter = fruitList.stream().filter(s -> s.startsWith("A"));
		filter.forEach(System.out::println);

		// flatMap

		final List<List<String>> fruitListOfList = Arrays.asList(
				Arrays.asList("Orange", "Mango", "Apple", "Jackfruit", "Guva"),
				Arrays.asList("Grape", "Apricot", "Pineapple", "Watermelon", "Strawbery"),
				Arrays.asList("Chery", "Kivi", "Sugercane", "Tomato", "Musmabi"));

		final Stream<String> sortedFruitList = fruitListOfList.stream().flatMap(s -> s.stream().sorted());
//		sortedFruitList.forEach(System.out::println);

		// Terminal
		// collect()

		final List<List<String>> fruitListOfListM = Arrays.asList(
				Arrays.asList("Orange", "Mango", "Apple", "Jackfruit", "Guva"),
				Arrays.asList("Grape", "Apricot", "Pineapple", "Watermelon", "Strawbery"),
				Arrays.asList("Chery", "Kivi", "Sugercane", "Tomato", "Musmabi"));

		final List<String> sortedFruitListM = fruitListOfList.stream().flatMap(List::stream)
				.collect(Collectors.toList());

		final var count = IntStream.range(0, sortedFruitListM.size()).boxed()
				.collect(Collectors.toMap(i -> i + 1, i -> sortedFruitListM.get(i)));

		System.out.println(count);

		// reduce

		final List<String> fruitListR = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");

		final String all = fruitListR.stream().reduce(String::concat).orElse(null);
		System.out.println(all);

//		var mapObj = sortedFruitList.map(Collectors.toMap(s -> (, s));

	}

}
