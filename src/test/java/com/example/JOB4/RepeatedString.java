package com.example.JOB4;

import java.util.HashMap;
import java.util.Map;

public class RepeatedString {
	public static void main(final String[] args) {

		final String abc = "anandu";
		final StringBuilder notrepeatedString = new StringBuilder();
		final StringBuilder repeatedString = new StringBuilder();
		final char[] abcChars = abc.toCharArray();
		final char[] duplicated = abc.toCharArray();

		for (int i = 0; i < abc.length(); i++) {
			for (int j = 0; j < abc.length(); j++) {

				if (i != j && (abcChars[i] == abcChars[j])
						&& repeatedString.indexOf(String.valueOf(abcChars[i])) == -1) {
					repeatedString.append(abcChars[i]);
				}

			}
		}
		System.out.println(" repeatedString : " + repeatedString);
		System.out.println("notrepeatedString :" + notrepeatedString);

		final String sentence = "This is a test. This test is only a test.";

		final String cleanSentace = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		final String[] cleanSentaceArr = cleanSentace.split("\\s+");
		final Map<String, Integer> wordCountMap = new HashMap<>();
		for (final String a : cleanSentaceArr) {

			wordCountMap.put(a, wordCountMap.getOrDefault(a, 0) + 1);

		}
		System.out.println(wordCountMap);

	}

}
