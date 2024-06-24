import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapWorking {
	public static void main(final String[] args) {
		final Student obj1 = new Student(1, "Anandu");
		final Student obj2 = new Student(2, "Bilal");

		final Map<Student, String> map = new HashMap<>();
		map.put(obj1, "first");
		map.put(obj2, "second");
		System.out.println(map.get(obj1));

		final List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1, "John", 50000, 10000));
		employees.add(new Employee(2, "Jane", 45000, 15000));
		employees.add(new Employee(3, "Doe", 60000, 5000));

		// Sort using Stream API
		final List<Employee> sortedEmployees = employees.stream()
				.sorted(Comparator.comparingInt(e -> e.getSalary() + e.getSalaryB())).collect(Collectors.toList());

		final Employee seconddEmployees = employees.stream()
				.sorted(Comparator.comparingInt(e -> e.getSalary() + e.getSalaryB())).skip(1).findFirst().orElse(null);

		final Employee seconddEmployeesSalery = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary))
				.skip(1).findFirst().orElse(null);

		System.out.println(seconddEmployees.getSalary());

		// Print sorted employees
		sortedEmployees.forEach(employee -> System.out
				.println(employee.getName() + ": " + (employee.getSalary() + employee.getSalaryB())));

	}

}

class Student {
	public Student(final int i, final String string) {
		this.rollNo = i;
		this.name = string;
	}

	@Override
	public int hashCode() {
		return 1111;
	}

	@Override
	public boolean equals(final Object obj) {

		return false;
	}

	int rollNo;
	String name;

}