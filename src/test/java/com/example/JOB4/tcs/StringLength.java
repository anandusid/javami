package com.example.JOB4.tcs;

import java.util.HashSet;
import java.util.Set;

public class StringLength {

	public static void main(final String[] args) {
		final String name = "malayalamn";
//		final int length1 = findStringLenght(name);
		System.out.println(palindromeCheck(name));

		fibinoki(7);// 0,1,1,2,3,5,8
	}

	private static void fibinoki(final int n) {

		int a = 0, b = 1, c = 1;

		for (int i = 1; i <= n; i++) {
			System.out.println(a);
			a = b;
			b = c;
			c = a + b;
		}

	}

	private static boolean palindromeCheck(final String name) {
		int i = 0;
		int j = name.length() - 1;
		while (i < j) {
			if (name.charAt(i) != name.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	private static int findStringLenght(final String name) {

		final Set<Character> longestSubString = new HashSet<>();

		int maxLength = 0;
		int i = 0;
		int j = 0;

		for (i = 0; i < name.length(); i++) {
			if (!longestSubString.contains(name.charAt(i))) {
				longestSubString.add(name.charAt(i));
				maxLength = Math.max(maxLength, i - j + 1);
			} else {
				while (longestSubString.contains(name.charAt(i))) {
					longestSubString.remove(name.charAt(j));
					j++;
				}
				longestSubString.add(name.charAt(i));
			}
		}
		System.out.println(maxLength);
		return maxLength;
	}

}
