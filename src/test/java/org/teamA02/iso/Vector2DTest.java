package org.teamA02.iso;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Vector2DTest {
	
	@Test(expected = Vector2DException.class)
	public void MCDCCoverageAngleBetweenZeroFirst() {
		new Vector2D(0, 0).angleBetween(new Vector2D(5, 6));
	}
	
	public void MCDCCoverageAngleBetweenZeroSecond() {
		new Vector2D(3, 4).angleBetween(new Vector2D(0, 0));
	}
	
	public void MCDCoverageAngleBetweenNonZero() {
		new Vector2D(0, 0).angleBetween(new Vector2D(0, 0));
	}
}
