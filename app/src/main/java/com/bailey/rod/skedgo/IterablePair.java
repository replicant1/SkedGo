package com.bailey.rod.skedgo;

/**
 * A pair of objects that implement the Iterable<T> interface.
 */
public class IterablePair<T> {

	private final Iterable<T> iterable1;
	private final Iterable<T> iterable2;

	/**
	 * Constructs an IterablePair.
	 *
	 * @param iterable1 The first iterable
	 * @param iterable2 The second iterable
	 */
	public IterablePair(Iterable<T> iterable1, Iterable<T> iterable2) {
		this.iterable1 = iterable1;
		this.iterable2 = iterable2;
	}

	public Iterable<T> getIterable1() {
		return iterable1;
	}

	public Iterable<T> getIterable2() {
		return iterable2;
	}
}
