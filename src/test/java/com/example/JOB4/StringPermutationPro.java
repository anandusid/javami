package com.example.JOB4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutationPro {

	public static void main(final String[] args) {

		final List<String> stringObj = Arrays.asList("grape", "mango", "orange", "apple");
		final List<String> stringObjReversed = new ArrayList<>();
		for (int i = stringObj.size() - 1; i >= 0; i--) {
			stringObjReversed.add(stringObj.get(i));
		}
		System.out.println(stringObjReversed);

		final String obj = "abcd";
		final List<String> objList = new ArrayList<>();
		permuteString(obj, objList, "");
//		System.out.println(objList);

		final String variable = "abc";

		final List<String> possiblePermutations = new ArrayList<>();

		permute(variable, possiblePermutations, "");
		System.out.println(possiblePermutations);

	}

	private static void permute(final String real, final List<String> possiblePermutations, final String reel) {

		if (real.length() == reel.length()) {
			possiblePermutations.add(reel);
			return;
		}
		swapString(real, possiblePermutations, reel);

	}

	private static void swapString(final String real, final List<String> possiblePermutations, final String reel) {
		// TODO Auto-generated method stub
		for (int index = 0; index < real.length(); index++) {
			final char c = real.charAt(index);
			if (reel.indexOf(c) == -1) {
				permute(real, possiblePermutations, reel + c);
			}
		}
	}

	private static void permuteString(final String obj, final List<String> objList, final String permutedString) {

		if (obj.length() == permutedString.length()) {
			objList.add(permutedString);
//			return;
		}
		swap(obj, objList, permutedString);

	}

	private static void swap(final String obj, final List<String> objList, final String permutedString) {
		for (int i = 0; i < obj.length(); i++) {
			final char a = obj.charAt(i);
			if (permutedString.indexOf(a) == -1) {
				permuteString(obj, objList, permutedString + a);
			}

		}

	}

}
