package com.example.JOB4;

//Java program to illustrate
//optional class methods

import java.util.Optional;

class GFG {

	// Driver code
	public static void main(final String[] args) {

		// creating a string array
		final String[] str = new String[5];

		// Setting value for 2nd index
		str[2] = "Geeks Classes are coming soon";

		// It returns a non-empty Optional
		final Optional<String> value = Optional.of(str[3]);

		// It returns value of an Optional.
		// If value is not present, it throws
		// an NoSuchElementException
		System.out.println(value.get());

		// It returns hashCode of the value
		System.out.println(value.hashCode());

		// It returns true if value is present,
		// otherwise false
		System.out.println(value.isPresent());
	}
}
