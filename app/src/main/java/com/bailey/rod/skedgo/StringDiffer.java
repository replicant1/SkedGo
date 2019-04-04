package com.bailey.rod.skedgo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringDiffer {

	private final String str1;
	private final String str2;

	public StringDiffer(String str1, String str2) {
		this.str1 = str1;
		this.str2= str2;
		System.out.println("------------------------------");
		System.out.println("StringDiffer c'tor, str=" + str1 + ", str2=" + str2);
	}

	public IterablePair<Character> symmetricDiff() {
		List<Character> charList1 = stringToList(str1);
		List<Character> charList2 = stringToList(str2);

		System.out.println("charList1=" + charList1 + ", charList2=" + charList2);

		List<Character> diff1 = diff(charList1, charList2);
		List<Character> diff2 = diff(charList2, charList1);

		System.out.println("diff1="+ diff1 + ", diff2=" +diff2);

		return new IterablePair<>(diff1, diff2);
	}

	private List<Character> diff(List<Character> charSet1, List<Character> charSet2) {
		List<Character> charSet1Copy = new ArrayList<>(charSet1);
		charSet1Copy.removeAll(charSet2);
		return charSet1Copy;
	}

	private List<Character> stringToList(String str1) {
		List<Character> result = new ArrayList<>();

		char[] charArray1 = str1.toCharArray();
		for (int i = 0; i < charArray1.length; i++) {
			result.add(charArray1[i]);
		}

		System.out.println("string " + str1 + " converts to list " + result);

		return result;
	}
}
