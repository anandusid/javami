package com.example.JOB4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiMap {
	public static void main(final String[] args) {
		final List<Integer> integerList = Arrays.asList(1, 4, 3, 6, 5, 5, 6, 2, 7);

		final Map<Integer, Long> mapCount = integerList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(mapCount);

	}

}
