package com.bailey.rod.skedgo;


import java.util.ArrayList;
import java.util.List;

/**
 * Class for taking the symmetric difference of two Strings.
 */
public class StringDiffer {

	private final String str1;
	private final String str2;

	public StringDiffer(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	/**
	 * Calculates the symmetric difference of str1 and str2 as supplied to the constructor.
	 *
	 * @return A pair of Iterables. The first iterable in this pair returns all the characters in str1 that are NOT
	 * in str2. Iteration order is preserved. The second iterable in this pair returns all the characters in str2
	 * that are NOT in str1. Iteration order is again preserved.
	 */
	public IterablePair<Character> symmetricDiff() {
		List<Character> charList1 = stringToList(str1);
		List<Character> charList2 = stringToList(str2);
		List<Character> diff1 = diff(charList1, charList2);
		List<Character> diff2 = diff(charList2, charList1);
		return new IterablePair<>(diff1, diff2);
	}

	/**
	 * Take the difference of two strings.
	 *
	 * @param str1chars The characters in str1, in order.
	 * @param str2chars The characters in str2, in orer.
	 * @return A list of characters that are in str1 but do NOT appear in str2
	 */
	private List<Character> diff(List<Character> str1chars, List<Character> str2chars) {
		List<Character> charSet1Copy = new ArrayList<>(str1chars);
		charSet1Copy.removeAll(str2chars);
		return charSet1Copy;
	}

	/**
	 * Convert a string to a list of Characters.
	 *
	 * @param str String to convert to a list
	 * @return The given string as a list of characters
	 */
	private List<Character> stringToList(String str) {
		List<Character> result = new ArrayList<>();

		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			result.add(charArray[i]);
		}

		return result;
	}
}
