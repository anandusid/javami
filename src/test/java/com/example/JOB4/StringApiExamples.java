package com.example.JOB4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StringApiExamples {

	public static void main(final String[] args) {

		final List<String> fruitList = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");

		final Stream<String> startsWitha = fruitList.stream().filter(s -> s.startsWith("A"));
		startsWitha.forEach(System.out::println);

		final List<Integer> integerList = Arrays.asList(2, 3, 8);

//		final List<Integer> eqr = integerList.stream().map(s -> s * s).collect(Collectors.toList());
//
//		final String lowest = fruitList.stream().sort(Comparator.comparing(s).re).orElse(null);
//		System.out.println(lowest);
//
//		final List<String> fruitListWithDummy = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");
//
//		final Map<Integer, String> fruitMap = IntStream.range(0, fruitListWithDummy.size()).boxed()
//				.collect(Collectors.toMap(i -> i, i -> fruitListWithDummy.get(i)));
//
//		System.out.println(fruitMap);

		final List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, 20, 50000));
		employees.add(new Employee(1, 30, 60000));

		final double averageSalary = employees.stream().filter(e -> e.getAge() > 50).mapToDouble(Employee::getSalary)
				.average().orElse(0.0);
		final Optional<Integer> a = integerList.stream().max(Comparator.naturalOrder());
	}

}

class Employee {
	private int id;
	private int age;
	private double salary;

	// Constructor, getters, and setters
	public Employee(final int id, final int age, final double salary) {
		this.id = id;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(final double salary) {
		this.salary = salary;
	}
}