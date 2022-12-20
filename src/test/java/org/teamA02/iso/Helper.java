package org.teamA02.iso;

/**
 * Collection of functions to help in the implementation of the test cases.
 *
 */
public class Helper {

	/**
	 * Applies the triangle inequality to check whether the three given sides can
	 * create a triangle
	 */
	public static boolean areValidTriangleSides(double a, double b, double c) {
		return a < b + c && b < a + c && c < a + b;
	}

	/**
	 * Creates a Triangle using the tree sides. If they do not correspond to the
	 * sides of a triangle, return null
	 */
	public static Triangle triangleFromSides(double a, double b, double c) {
		if (!areValidTriangleSides(a, b, c)) {
			return null;
		}

		// Law of cosines
		double alpha = Math.acos((b * b + a * a - c * c) / (2 * a * b)) * 180 / Math.PI;
		return triangleFromAngle(a, b, alpha);
	}

	/**
	 * Creates a triangle given the base and two angles
	 */

	public static Triangle triangleFromTwoAngles(double base, double alpha, double theta) {
		double beta = (180 - alpha - theta) * Math.PI / 180;

		// Law of sines
		double b = base * Math.sin(alpha * Math.PI / 180) / Math.sin(beta);
		return triangleFromAngle(base, b, alpha);
	}
	
	/**
	 * Create a rectangle whose maximum angle is 'maxAngle' and a base of 'base'. The base is
	 * assumed to be parallel to the x axis.  
	 */
	
	public static Triangle withMaxAngle(double base, double maxAngle) {
		double remaining = 180 - maxAngle;
		return triangleFromTwoAngles(base, remaining / 2, remaining / 2);
	}

	/**
	 * Creates a triangle given the base length, a side and the angle (in degrees)
	 * between them. The base is assumed to be parallel to the x axis.
	 */
	public static Triangle triangleFromAngle(double base, double side, double alpha) {
		Vector2D sideVec = Vector2D.fromAngle(180 - alpha, side);
		Vector2D baseVec = new Vector2D(base, 0);
		Vector2D thirdPoint = Vector2D.add(sideVec, baseVec);

		return new Triangle(new Vector2D(0, 0), baseVec, thirdPoint);
	}
}
