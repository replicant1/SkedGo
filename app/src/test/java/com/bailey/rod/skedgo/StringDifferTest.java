package com.bailey.rod.skedgo;

import org.junit.Test;

import java.util.Iterator;

import static junit.framework.Assert.assertTrue;

/**
 * Unit tests for the StringDiffer class.
 */
public class StringDifferTest {

	@Test
	public void emptyDiffEmpty() {
		StringDiffer sd = new StringDiffer("", "");
		IterablePair<Character> pair = sd.symmetricDiff();
		assertTrue(iterableIsEmpty(pair.getIterable1()));
		assertTrue(iterableIsEmpty(pair.getIterable2()));
	}

	@Test
	public void diffDisjoint() {
		StringDiffer sd = new StringDiffer("abc", "def");
		IterablePair<Character> pair = sd.symmetricDiff();
		assertTrue(iterableIsString("abc", pair.getIterable1()));
		assertTrue(iterableIsString("def", pair.getIterable2()));
	}

	@Test
	public void diffRandomOrderWithIntersection() {
		StringDiffer sd = new StringDiffer("1qanp", "z+1we");
		IterablePair<Character> pair = sd.symmetricDiff();
		assertTrue(iterableIsString("qanp", pair.getIterable1()));
		assertTrue(iterableIsString("z+we", pair.getIterable2()));
	}

	@Test
	public void diffOneCharIntersection() {
		StringDiffer sd = new StringDiffer("abcd", "defg");
		IterablePair<Character> pair = sd.symmetricDiff();
		assertTrue(iterableIsString("abc", pair.getIterable1()));
		assertTrue(iterableIsString("efg", pair.getIterable2()));
	}

	@Test
	public void diffSame() {
		StringDiffer sd = new StringDiffer("ab", "ab");
		IterablePair<Character> pair = sd.symmetricDiff();
		assertTrue(iterableIsEmpty(pair.getIterable1()));
		assertTrue(iterableIsEmpty(pair.getIterable2()));
	}


	@Test
	public void diffCaseSensitive() {
		StringDiffer sd = new StringDiffer("bad", "BAD");
		IterablePair<Character> pair = sd.symmetricDiff();
		assertTrue(iterableIsString("bad", pair.getIterable1()));
		assertTrue(iterableIsString("BAD", pair.getIterable2()));
	}

	@Test
	public void diffPunctuation() {
		StringDiffer sd = new StringDiffer("!@#$", "%^&*");
		IterablePair<Character> pair = sd.symmetricDiff();
		assertTrue(iterableIsString("!@#$", pair.getIterable1()));
		assertTrue(iterableIsString("%^&*", pair.getIterable2()));
	}

	@Test
	public void diffRepeatedChars() {
		StringDiffer sd = new StringDiffer("aaa", "bbb");
		IterablePair<Character> pair = sd.symmetricDiff();
		assertTrue(iterableIsString("aaa", pair.getIterable1()));
		assertTrue(iterableIsString("bbb", pair.getIterable2()));
	}

	private boolean iterableIsEmpty(Iterable<Character> it) {
		return !it.iterator().hasNext();
	}

	private boolean iterableIsString(String str, Iterable<Character> it) {
		Iterator<Character> charit = it.iterator();
		StringBuilder sb = new StringBuilder();
		while (charit.hasNext()) {
			sb.append(charit.next());
		}
		return str.equals(sb.toString());
	}

	/**
	 * For debugging
	 */
	private String iterableToString(Iterable<Character> it) {
		StringBuilder sb = new StringBuilder();
		Iterator<Character> charit = it.iterator();
		while (charit.hasNext()) {
			sb.append(charit.next());
		}
		return sb.toString();
	}
}
