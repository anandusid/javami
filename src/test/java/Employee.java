public class Employee {
	private Integer employeeId;
	private String name;
	private Integer salary;
	private Integer salaryB;

	// Constructor
	public Employee(final Integer employeeId, final String name, final Integer salary, final Integer salaryB) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.salaryB = salaryB;
	}

	// Getters and setters
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(final Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(final Integer salary) {
		this.salary = salary;
	}

	public Integer getSalaryB() {
		return salaryB;
	}

	public void setSalaryB(final Integer salaryB) {
		this.salaryB = salaryB;
	}
}
