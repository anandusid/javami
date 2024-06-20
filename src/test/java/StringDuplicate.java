import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StringDuplicate {

	public static void main(final String[] args) {
		final String line = " i am a java developer and java is a powerfull language";
		final String[] lineArr = line.replaceAll("^[a-zA-Z]", "").split(" ");

		final String word = Arrays.asList(lineArr).stream().max(Comparator.comparingInt(String::length)).orElse("");
		System.out.println(word);
		final Employee embObject = new Employee(1, "anandu", 1000, 500);
		final Employee embObject1 = new Employee(2, "ahmed", 2000, 300);
		final Employee embObject2 = new Employee(3, "aravind", 3000, 10);

		// Create a list of employees
		final List<Employee> employeeList = new ArrayList<>();
		employeeList.add(embObject);
		employeeList.add(embObject1);
		employeeList.add(embObject2);

		// Find employee with highest combined salary using streams
		final OptionalDouble employeeWithHighestSalary = employeeList.stream().mapToDouble(Employee::getSalary)
				.average();

		final Optional<Employee> employeeWithHighestCombinedSalary = employeeList.stream()
				.max(Comparator.comparingInt(e -> e.getSalary() + e.getSalaryB()));

		// Process the optional result if present
		System.out.println(employeeWithHighestSalary);

	}

}
