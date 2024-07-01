package com.example.JOB4.tcs;

public class StringStreamOperation {
	public static void main(final String[] args) {

		countCharacters();
		countNumbers();
	}

	private static void countNumbers() {
		final String input = "12a34";

		System.out.println(input.chars().filter(Character::isDigit).map(Integer::valueOf).count());

	}

	private static void countCharacters() {
		final String input = "JavaJavaEEJavaJavaEE ";

		System.out.println(input.chars().mapToObj(s -> s).count());

	}

}
