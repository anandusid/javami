package com.example.JOB4.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;

	public Person(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}

public class StreamExample {
	public static void main(final String[] args) {
		final List<Person> people = new ArrayList<>();
		people.add(new Person("Alice", 30));
		people.add(new Person("Bob", 25));
		people.add(new Person("Charlie", 40));
		people.add(new Person("David", 28));
		people.add(new Person("Eve", 35));
		people.add(new Person("Alice", 30));

		final List<Person> sortedList = people.stream().sorted(Comparator.comparing(Person::getName)).skip(1)
				.collect(Collectors.toList());
		System.out.println(sortedList);
		final Map<String, Long> sortedMap = people.stream().sorted(Comparator.comparing(Person::getName))
				.collect(Collectors.groupingBy(Person::getName, TreeMap::new, Collectors.counting()));

		System.out.println(sortedMap);
	}
}
