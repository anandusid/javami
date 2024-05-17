package com.example.JOB4;

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

	}

}
