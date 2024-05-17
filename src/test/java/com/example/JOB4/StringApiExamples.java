package com.example.JOB4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringApiExamples {

	public static void main(final String[] args) {

		final List<String> fruitList = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");

		final Stream<String> startsWitha = fruitList.stream().filter(s -> s.startsWith("A"));
		startsWitha.forEach(System.out::println);

		final List<Integer> integerList = Arrays.asList(2, 3, 8);

		final List<Integer> eqr = integerList.stream().map(s -> s * s).collect(Collectors.toList());

		final String lowest = fruitList.stream().max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
				.orElse(null);
		System.out.println(lowest);

		final List<String> fruitListWithDummy = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");

		final Map<Integer, String> fruitMap = IntStream.range(0, fruitListWithDummy.size()).boxed()
				.collect(Collectors.toMap(i -> i, i -> fruitListWithDummy.get(i)));

		System.out.println(fruitMap);

	}

}
