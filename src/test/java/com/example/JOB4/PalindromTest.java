package com.example.JOB4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromTest {

	public static void main(final String[] args) {

		final List<String> nameList = Arrays.asList("Biju", "Rames", "Ajaz", "Rajes", "Avinash");

		final List<String> namesWithA = nameList.stream().filter(a -> a.startsWith("A")).collect(Collectors.toList());
		namesWithA.forEach(System.out::println);

	}

}
