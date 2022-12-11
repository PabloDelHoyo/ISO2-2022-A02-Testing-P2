package org.teamA02.iso;

public class Vector2D {

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
	
	/**
	 * Returns the angle (in degrees) between this vector and another one
	 * @param other
	 * @return an angle in degrees
	 */
	public double angleBetween(Vector2D other) {
		return Math.acos(dot(other) / (length() * other.length())) * 180 / Math.PI;
	}
	
	/**
	 * Performs the dot product between this vector and another one
	 * @param other
	 * @return a scalar 
	 */
	public double dot(Vector2D other) {
		return x * other.x + y * other.y;
	}
	
	/**
	 * Calculates the length of this vector
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
