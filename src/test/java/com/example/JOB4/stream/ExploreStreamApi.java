package com.example.JOB4.stream;

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
		final List<String> strings = List.of("apple", "banana", "pear", "orange", "kiwi", "grape");
		final List<String> stringsa = List.of("apple", "banana", "pear");

		final List<String> stringsI = List.of("1234567", "9876543", "2345678");

		final var stringObj = "India is my country , Pakisthan is my negbour company";
		final String name = "Hello";
		final List<String> stringList = Arrays.asList(name);
//		obj.countName(name);
		obj.coutWords(stringObj);
		obj.makeCharsForTheString(stringsa);
		obj.makeCharsForTheString(stringList);
//		obj.makeIntegerForTheString(stringsI);
//		obj.createMapofLengthandCount(strings);
//		obj.createMappingWithOccurence(numbers);
//		obj.createMappingWithLength(fruitListWithDummy);
//		obj.createrFruitMapWithNameAndCount(fruitListWithDummy);
	}

	private void countName(final String name) {
		final List<String> stringList = Arrays.asList(name);

		final Map<Character, Long> stringListMap = stringList.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(stringListMap);

//		final List<String> stringsI = List.of("1234567", "9876543", "2345678");
//		final Map<Character, Long> integerMap = stringsI.stream().flatMap(a -> a.chars().mapToObj(c -> (char) c))
//				.filter(Character::isDigit).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(integerMap);
//		final List<String> numbers = List.of("3", "2", "6", "1");
//		final List<Integer> i = numbers.stream().map(Integer::valueOf).filter(a -> a % 2 == 0).filter(b -> b == 6)
//				.collect(Collectors.toList());
//		System.out.println(i);
	}

	private void coutWords(final String stringObj) {
		final Map<String, Long> wordCount = Arrays.asList(stringObj.replaceAll("[^a-zA-Z ]", "").split(" ")).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(wordCount);

	}

	private void makeIntegerForTheString(final List<String> stringsI) {
		final List<Integer> intList = stringsI.stream().flatMap(s -> s.chars().mapToObj(i -> (Integer) i))
				.collect(Collectors.toList());

		System.out.println("integer List----- " + intList);

	}

	private void makeCharsForTheString(final List<String> stringsa) {
		final List<Character> charList = stringsa.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c))
				.collect(Collectors.toList());
		System.out.println("charList----- " + charList);

		final String name = "Hello";

		final List<Character> chardWordList = name.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

	}

	private void createMapofLengthandCount(final List<String> strings) {
		final Map<Integer, Long> map = strings.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println("createMapofLengthandCount **** " + map);

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
