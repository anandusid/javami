import java.util.Arrays;

import com.example.JOB4.IterfaceDemo;

public class MainTestClass {

	public static void main(final String[] args) {
		final IterfaceDemo a = new ChildInterface();

		final int[] intArr = { 10, 1, 20, 0, 59, 63, 0, 88, 0 };

		final int j = intArr.length - 1;
		int k = 8;
		for (int i = j; i >= 0; i--) {
			if (intArr[i] != 0) {
				intArr[k] = intArr[i];
				k--;
			}
		}
		System.out.println("left aligned " + Arrays.toString(intArr));
		while (k >= 0) {
			System.out.println("k :" + k);
			intArr[k] = 0;
			k--;
			System.out.println("k after:" + k);
		}
		System.out.println("left aligned " + Arrays.toString(intArr));

		k = 0;
		int p = 0;
		int t = 0;

		for (t = 0; t < intArr.length; t++) {
			if (intArr[t] != 0) {
				intArr[p] = intArr[t];
				p++;
			}
		}
		System.out.println("right aligned " + Arrays.toString(intArr));

		while (p <= intArr.length - 1) {
			intArr[p] = 0;
			p++;
		}
		System.out.println("right aligned " + Arrays.toString(intArr));

		final int[] arr = { 12, 34, 45, 9, 8, 90, 3 };
		final int[] findPairArr = { 1, 5, 7, -1, 5 };

		final int[] arrToSort = { 12, 34, 45, 9, 8, 90, 3 };

		for (int x = 0; x < arrToSort.length - 1; x++) {
			for (int y = 0; y < arrToSort.length - 1 - x; y++) {
				if (arrToSort[y] > arrToSort[y + 1]) {
					final int temp = arrToSort[y];
					arrToSort[y] = arrToSort[y + 1];
					arrToSort[y + 1] = temp;

				}
			}
		}

		final String s1 = "coding ninjas";
		final String s2 = "coding ninjas";
		System.out.println(s1.hashCode() + " ==  " + s2.hashCode());
		System.out.println(s1 == s2);
		final int number[] = new int[5];
		number[1] = 3;
		System.out.println(Arrays.toString(number));

		MainTestClass.invokeTry();
	}

	private static void invokeTry() {

		try {
			final int n = 1 / 1;
			System.exit(0);
			return;

		} catch (final Exception e) {
			throw e;
		} finally {
			System.out.println(" i will invoke...");
		}

	}

}
