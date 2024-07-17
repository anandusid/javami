package com.example.JOB4.tcs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

public class MapStreamOperation {

	public static void main(final String[] args) {
		sortMap();
		findDuplicate();
	}

	private static void findDuplicate() {
		final var stringObj = "India is my country , Pakisthan is my negbour company";

		Arrays.asList(stringObj.replaceAll("[^a-zA-z]", "").split(" ")).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	}

	private static void sortMap() {
		final Map<String, Integer> scores = new HashMap<>();

		scores.put("David", 95);
		scores.put("Jane", 80);
		scores.put("Mary", 97);
		scores.put("Lisa", 78);
		scores.put("Dino", 65);

		System.out
				.println(scores.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));

	}

}
