package org.teamA02.iso;

public class Triangle {

	double a, b, c;
	double alpha, beta, theta;

	public Triangle(Vector2D v1, Vector2D v2, Vector2D v3) {
		Vector2D firstSide = Vector2D.subtract(v2, v1);
		Vector2D secondSide = Vector2D.subtract(v3, v2);
		Vector2D thirdSide = Vector2D.subtract(v1, v3);

		this.a = firstSide.length();
		this.b = secondSide.length();
		this.c = thirdSide.length();

		this.alpha = 180 - firstSide.angleBetween(secondSide);
		this.beta = 180 - secondSide.angleBetween(thirdSide);
		this.theta = 180 - thirdSide.angleBetween(firstSide);
	}

	public SideType sideType() {
		if (Utils.doubleEquals(alpha, 60) && Utils.doubleEquals(beta, 60)) {
			return SideType.EQUILATERAL;
		} else if (Utils.doubleEquals(a, b) || Utils.doubleEquals(a, c) || Utils.doubleEquals(b, c)) {
			return SideType.ISOSCELES;
		} else {
			return SideType.SCALENE;
		}
	}

	public AngleType angleType() {
		int cmp = Utils.doubleCompare(getMaxAngle(), 90);

		if (cmp == 0) {
			return AngleType.RIGHT;
		} else if (cmp == 1) {
			return AngleType.OBTUSE;
		} else {
			return AngleType.ACUTE;
		}
	}

	public double getMaxAngle() {
		return Math.max(Math.max(a, b), c);
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public double getAlpha() {
		return alpha;
	}

	public double getBeta() {
		return beta;
	}

	public double getTheta() {
		return theta;
	}

}
