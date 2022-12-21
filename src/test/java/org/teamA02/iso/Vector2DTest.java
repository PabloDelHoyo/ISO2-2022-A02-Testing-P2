package org.teamA02.iso;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Vector2DTest {

	@Test(expected = Vector2DException.class)
	public void MCDCCoverageAngleBetweenZeroFirst() {
		new Vector2D(0, 0).angleBetween(new Vector2D(5, 6));
	}

	@Test(expected = Vector2DException.class)
	public void MCDCCoverageAngleBetweenZeroSecond() {
		new Vector2D(3, 4).angleBetween(new Vector2D(0, 0));
	}

	@Test(expected = Vector2DException.class)
	public void MCDCoverageAngleBetweenNonZero() {
		new Vector2D(0, 0).angleBetween(new Vector2D(0, 0));
	}

	@Test(expected = Vector2DException.class)
	public void decisionCoverageOneZeroAngleBetween() {
		new Vector2D(0, 0).angleBetween(new Vector2D(3, 2));

	}

	@Test
	public void decisionCoverageNonOneZeroAngleBetween() {
		new Vector2D(3, 4).angleBetween(new Vector2D(2, 1));
	}
}
