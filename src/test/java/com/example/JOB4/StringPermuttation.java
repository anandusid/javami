package com.example.JOB4;

import java.util.ArrayList;
import java.util.List;

public class StringPermuttation {
	static int count = 0;

	public static void main(final String[] args) {
		final String orginal = "abc";
		final List<String> permutetedStringList = new ArrayList<>();

		permutation(orginal, permutetedStringList, "");
		System.out.println(permutetedStringList);

	}

	private static void permutation(final String orginal, final List<String> permutetedStringList,
			final String permutedString) {

		if (permutedString.length() == orginal.length()) {
			System.out.println("permutation method 1 :" + permutedString);
			permutetedStringList.add(permutedString);
			return;
		}
		System.out.println("permutation method 2 :" + permutedString);
		swap(orginal, permutedString, permutetedStringList, count++);

	}

	private static void swap(final String orginal, final String permutedString, final List<String> permutetedStringList,
			final int count) {
		System.out.println("permutaation call swap   count :" + count + " :permuted String: " + permutedString);
		for (int i = 0; i < orginal.length(); i++) {
			System.out.println("swap in index : " + i + " on count : " + count);
			final char charArr = orginal.charAt(i);// 2
			if (permutedString.indexOf(charArr) == -1) {
				String permutedString2 = permutedString + charArr;
				permutation(orginal, permutetedStringList, permutedString2);
				System.out.println("swap call permutation : " + permutedString + " on count : " + count);
			}
			System.out.println("Swap out index: " + i + " on count : " + count);
		}

	}

}
