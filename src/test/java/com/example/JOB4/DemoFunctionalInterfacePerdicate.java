package com.example.JOB4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface DemoFunctionalInterfacePerdicate {

	static void main(final String[] args) {
		final List<Employe> employeList = new ArrayList<>();
		employeList.add(new Employe("Anandu", "Kollam", 31));
		employeList.add(new Employe("Akhil", "Kollam", 32));
		employeList.add(new Employe("Manu", "Iduki", 27));
		employeList.add(new Employe("Igbal", "Bangalor", 21));

		final Predicate<Employe> isFromMumbai = e -> e.getAge() > 30;

		final List<Employe> filteredList = employeList.stream().filter(Predicate.not(isFromMumbai))
				.collect(Collectors.toList());
		System.out.println(filteredList);

	}

}
