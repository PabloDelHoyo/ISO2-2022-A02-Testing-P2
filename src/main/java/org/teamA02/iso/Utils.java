package org.teamA02.iso;

public class Utils {
	
	// For this specific application, we are not interested in very high accuracy
	public static double DEFAULT_EPSILON = 0.001;
	
	public static boolean doubleEquals(double d1, double d2) {
		// Not the best way but the fastest one to implement.
		return Math.abs(d1 - d2) < DEFAULT_EPSILON;
	}
	
	/**
	 * Compares two floating point numbers. If they are equal (according to doubleEquals), return 0
	 * If d1 is less than d2, it returns -1. Otherwise, it returns 1
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int doubleCompare(double d1, double d2) {
		// Again, this is not the best approach and it might fail in some edge cases
		// which, for this practice, will be ignored
		if (doubleEquals(d1, d2)) {
			return 0;
		}
		if (d1 < d2) {
			return -1;
		}
		return 1;
	}
}
