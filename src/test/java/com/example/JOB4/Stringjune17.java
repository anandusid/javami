package com.example.JOB4;

import java.util.ArrayList;
import java.util.List;

public class Stringjune17 {
	public static void main(final String[] args) {
		final String val = "abc";
		final List<String> combinationList = new ArrayList<>();

		permute(val, "", combinationList);
		System.out.println(combinationList);

	}

	private static void permute(final String val, final String duplicate, final List<String> combinationList) {
		if (val.length() == duplicate.length()) {
			combinationList.add(duplicate);
			return;
		}
		createPermute(val, duplicate, combinationList);

	}

	private static void createPermute(final String val, final String duplicate, final List<String> combinationList) {

		for (int i = 0; i < val.length(); i++) {
			final var chara = val.charAt(i);
			if (duplicate.indexOf(chara) == -1) {
				permute(val, duplicate + chara, combinationList);
			}

		}

	}
}
