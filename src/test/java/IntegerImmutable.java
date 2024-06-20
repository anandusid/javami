import java.util.ArrayList;
import java.util.List;

public class IntegerImmutable {

	public static void main(final String[] args) {
		// Create an ArrayList to store Integer objects
		final List<Integer> numberList = new ArrayList<>();

		// Add some numbers to the list
		numberList.add(10);
		numberList.add(20);
		numberList.add(30);

		// Attempt to modify an element in the list
		// This operation is not allowed for Integer, as it is immutable
		numberList.set(0, numberList.get(0) + 5); // This line causes a compilation error

		// Print the updated list
		System.out.println("Updated List: " + numberList); // Output: Updated List: [15, 20, 30]

	}
}
