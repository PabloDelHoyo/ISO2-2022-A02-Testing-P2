package org.teamA02.iso;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleTest {

	@Test(expected = DegenerateTriangleException.class)
	public void eachUseConstructorRaisesExceptions() {
		new Triangle(new Vector2D(0, 0), new Vector2D(0, 0), new Vector2D(0, 0));
	}

	@Test
	public void eachUseTriangleSuccessfulCreation() {
		new Triangle(new Vector2D(3, 4), new Vector2D(5, 9), new Vector2D(10, -22));
		new Triangle(new Vector2D(-3, 4), new Vector2D(-6, 3), new Vector2D(3, 4));
		new Triangle(new Vector2D(5, -10), new Vector2D(4, -5), new Vector2D(-5, -10));
		new Triangle(new Vector2D(-2, -2), new Vector2D(-4, -4), new Vector2D(10, 15));
	}

	@Test
	public void eachUseSideType() {
		assertEquals(Helper.triangleFromSides(8, 8, 8).sideType(), SideType.EQUILATERAL);
		assertEquals(Helper.triangleFromSides(26, 16, 23).sideType(), SideType.SCALENE);
		assertEquals(Helper.triangleFromSides(30, 14, 25).sideType(), SideType.SCALENE);
		assertEquals(Helper.triangleFromSides(46, 20, 46).sideType(), SideType.ISOSCELES);
		assertEquals(Helper.triangleFromSides(57, 31, 34).sideType(), SideType.SCALENE);
	}

	@Test
	public void eachUseAngleType() {
		// The base is arbitrary and does not affect what is being tested

		assertEquals(Helper.withMaxAngle(10, 60).angleType(), AngleType.ACUTE);
		assertEquals(Helper.withMaxAngle(10, 75).angleType(), AngleType.ACUTE);
		assertEquals(Helper.withMaxAngle(10, 90).angleType(), AngleType.RIGHT);
		assertEquals(Helper.withMaxAngle(10, 150).angleType(), AngleType.OBTUSE);
		assertEquals(Helper.withMaxAngle(10, 175).angleType(), AngleType.OBTUSE);
	}

	@Test(expected = DegenerateTriangleException.class)
	public void MCDCCoverageTriangleConstructorDegenerate() {
		// This triangle is created in this way so that the three vertices are
		// collinear.
		// With Helper.withMaxAngle(), at least one pair of vertices is on top of
		// another and
		// as a consequence, an exception is raised before reaching this point.
		new Triangle(new Vector2D(0, 0), new Vector2D(3, 0), new Vector2D(10, 0));
	}

	@Test
	public void MCDCCoverageTriangleConstructorNonDegenerate() {
		assertEquals(Helper.withMaxAngle(10, 90).getMaxAngle(), 90, Utils.DEFAULT_EPSILON);
	}

	@Test
	public void MCDCCoverageAngleTypeFirstDecision() {
		assertEquals(Helper.withMaxAngle(10, 90).getMaxAngle(), 90, Utils.DEFAULT_EPSILON);
		assertEquals(Helper.withMaxAngle(10, 70).getMaxAngle(), 70, Utils.DEFAULT_EPSILON);
	}

	@Test
	public void MCDCCoverageAngleTypeSecondDecision() {
		assertEquals(Helper.withMaxAngle(10, 135).getMaxAngle(), 135, Utils.DEFAULT_EPSILON);
		assertEquals(Helper.withMaxAngle(10, 85).getMaxAngle(), 85, Utils.DEFAULT_EPSILON);
	}

	@Test
	public void MCDCCoverageSideTypeFirstDecision() {
		assertEquals(Helper.triangleFromTwoAngles(10, 60, 60).sideType(), SideType.EQUILATERAL);
		assertEquals(Helper.triangleFromTwoAngles(10, 60, 90).sideType(), SideType.SCALENE);
		assertEquals(Helper.triangleFromTwoAngles(10, 45, 45).sideType(), SideType.ISOSCELES);
	}

	@Test
	public void MCDCCoverageSideTypeSecondDecision() {
		assertEquals(Helper.triangleFromSides(10, 10, 8).sideType(), SideType.ISOSCELES);
		assertEquals(Helper.triangleFromSides(13, 6, 13).sideType(), SideType.ISOSCELES);
		assertEquals(Helper.triangleFromSides(12, 15, 15).sideType(), SideType.ISOSCELES);
		assertEquals(Helper.triangleFromSides(10, 16, 14).sideType(), SideType.SCALENE);
	}

	@Test(expected = DegenerateTriangleException.class)
	public void decisionCoverageConstructorDegenerate() {
		new Triangle(new Vector2D(0, 0), new Vector2D(3, 0), new Vector2D(10, 0));
	}

	@Test
	public void decisionCoverageConstructorNonDegenerate() {
		assertEquals(Helper.withMaxAngle(10, 65).getMaxAngle(), 65, Utils.DEFAULT_EPSILON);
	}

	@Test
	public void decisionCoverageAngleType() {
		assertEquals(Helper.withMaxAngle(10, 90).getMaxAngle(), 90, Utils.DEFAULT_EPSILON);
	}

	@Test
	public void decisionCoverageSideType() {
		assertEquals(Helper.triangleFromTwoAngles(20, 60, 60).sideType(), SideType.EQUILATERAL);
		assertEquals(Helper.triangleFromSides(8, 5, 5).sideType(), SideType.ISOSCELES);
		assertEquals(Helper.triangleFromSides(15 * Math.sqrt(3), 30, 15).sideType(), SideType.SCALENE);
	}

}
