package com.example.JOB4.tcs;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamOperation {

	public static void main(final String[] args) {
		sortMap();
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
