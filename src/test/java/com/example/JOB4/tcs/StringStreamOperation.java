package com.example.JOB4.tcs;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

public class StringStreamOperation {
	public static void main(final String[] args) {

		countCharacters();
		countNumbers();
		FindDuplciate();
	}

	private static void FindDuplciate() {
		final var stringObj = "India is my country , Pakisthan is my negbour company";

		Arrays.asList(stringObj.replaceAll("[^a-zA-z]", "").split(" ")).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

	}

	private static void countNumbers() {
		final String input = "12a34";

		System.out.println(input.chars().filter(Character::isDigit).count());

	}

	private static void countCharacters() {
		final String input = "JavaJavaEEJavaJavaEE ";

		System.out.println(input.chars().count());

	}

}
