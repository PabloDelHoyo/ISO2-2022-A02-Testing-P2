package org.teamA02.iso;

public class Vector2D {

	public static double ZERO_VECTOR_EPSILON = 0.00001;

	private double x;
	private double y;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the result of subtracting the first vector to the second one as a new
	 * vector
	 * 
	 * @param first
	 * @param second
	 * @return the subtraction of second from first
	 */
	public static Vector2D subtract(Vector2D first, Vector2D second) {
		return new Vector2D(first.x - second.x, first.y - second.y);
	}
	
	public static Vector2D add(Vector2D first, Vector2D second) {
		return new Vector2D(first.x + second.x, first.y + second.y);
	}
	
	/**
	 * Creates a vector rotated 'angle' degress. The point of rotation is (0, 0)
	 * @param angle in degrees
	 * @param length the length of the vector
	 * @return
	 */
	public static Vector2D fromAngle(double angle, double length) {
		double radians = angle * Math.PI / 180;
		return new Vector2D(length * Math.cos(radians), length * Math.sin(radians));
	}

	/**
	 * Returns the angle (in degrees) between this vector and another one. If this
	 * vector or the other is the zero vector, raise an exception because the
	 * formula is not valid
	 * 
	 * @param other
	 * @return an angle in degrees
	 */
	public double angleBetween(Vector2D other) {
		if (isZero() || other.isZero()) {
			throw new Vector2DException("Cannot obtain angle of the zero vector");
		}
		return Math.acos(dot(other) / (length() * other.length())) * 180 / Math.PI;
	}

	/**
	 * Returns whether this vector is the zero vector (0, 0)
	 * 
	 * @return
	 */
	public boolean isZero() {
		return Utils.doubleEquals(x, ZERO_VECTOR_EPSILON) && Utils.doubleEquals(y, ZERO_VECTOR_EPSILON);
	}

	/**
	 * Performs the dot product between this vector and another one.
	 * 
	 * @param other
	 * @return a scalar
	 */
	public double dot(Vector2D other) {
		return x * other.x + y * other.y;
	}

	/**
	 * Calculates the length of this vector
	 * 
	 * @return the length of this vector
	 */
	public double length() {
		return Math.sqrt(x * x + y * y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
