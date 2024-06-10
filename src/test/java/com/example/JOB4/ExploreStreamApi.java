package com.example.JOB4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExploreStreamApi {

	public static void main(final String[] args) {

		final ExploreStreamApi obj = new ExploreStreamApi();

		final List<Integer> numbers = List.of(3, 2, 6, 1, 2, 2, 3, 4, 4, 5);
		final List<String> fruitListWithDummy = Arrays.asList("Orange", "Mango", "Apple", "Jackfruit", "Guva", "Mango");

		obj.createMappingWithOccurence(numbers);
		obj.createMappingWithLength(fruitListWithDummy);
		obj.createrFruitMapWithNameAndCount(fruitListWithDummy);
	}

	private void createrFruitMapWithNameAndCount(final List<String> fruitListWithDummy) {

		final var forPredicateTest = fruitListWithDummy;
		final Predicate predicate = p -> p.equals("Orange");
		final var list = forPredicateTest.stream().filter(Predicate.not(predicate));
		list.forEach(System.out::println);
		// {Apple=1, Mango=2, Guva=1, ORange=1, jackfruit=1}

		final Map<String, Long> map = fruitListWithDummy.stream()
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println("createrFruitMapWithNameAndCount" + map);

	}

	private void createMappingWithLength(final List<String> fruitListWithDummy) {
		final Map<String, List<String>> fruitMap = fruitListWithDummy.stream().collect(Collectors.groupingBy(
				Function.identity(), TreeMap::new, Collectors.mapping(Function.identity(), Collectors.toList())));
		System.out.println(fruitMap);

	}

	private void createMappingWithOccurence(final List<Integer> numbers) {

		final Map<Integer, Long> numberGroupedMap = numbers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(numberGroupedMap);

	}
}
