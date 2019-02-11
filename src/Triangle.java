/*=============================================================================
| Source code: Triangle.java
| Author: Luis Bauza
| Student ID: 5825548
| Assignment: Program #2 Triangle
|
| Course: COP 3337 - (Computer Programming II)
| Section: U06
| Instructor: William Feild
| Due Date: 2-7-19, at the beginning of class
|
| I hereby certify that this collective work is my own
| and none of it is the work of any other person or entity.
|
| ______________________________________ [Signature]
|
| Language: Java
| Compile/Run: None for this class.
|
| +-----------------------------------------------------------------------------+
|
| Description: The class that the TriangleTester class uses in order to find properties of methods.
|
| Input: None.
|
| Output: None.
|
| Process: Using the Point2D class methods, it is simple to find out the angles of each point and the distance
|          between those points for easy calculation of the perimeter and area, using Heron's Formula. There are
|          appropriate getter methods for the Triangle object in this class.
|
| Required Features Not Included: None.
|
| Known Bugs: None.
\*===========================================================================*/

import javafx.geometry.Point2D;

public class Triangle {

    // The Triangle's three points.
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;

    /**
     * Creates a triangle using three points.
     * The parameters are stored in points point1-3 respectively.
     *
     * @param x1 The x-coordinate of the first point.
     * @param y1 The y-coordinate of the first point.
     * @param x2 The x-coordinate of the second point.
     * @param y2 The y-coordinate of the second point.
     * @param x3 The x-coordinate of the third point.
     * @param y3 The y-coordinate of the third point.
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        point1 = new Point2D(x1, y1);
        point2 = new Point2D(x2, y2);
        point3 = new Point2D(x3, y3);
    } // end Triangle()

    /**
     * Empty constructor for the Triangle class, using a "Unit Triangle" as default.
     */
    public Triangle() {
        final int ZERO = 0;
        final int ONE = 1;
        final int NEGATIVE_ONE = -1;
        point1 = new Point2D(ZERO, ONE);
        point2 = new Point2D(NEGATIVE_ONE, NEGATIVE_ONE);
        point3 = new Point2D(ONE, NEGATIVE_ONE);
    } // end Triangle() empty constructor

    /**
     * Calculates the area of the triangle using Heron's Formula, where 'semip' is the semi-perimeter of the triangle.
     *
     * @return The calculated area of the triangle.
     */
    double getArea() {
        final double HALF = 0.5;
        double semip = HALF * getPerimeter();
        return Math.sqrt(semip * (semip - getSide1()) * (semip - getSide2()) * (semip - getSide3()));
    } // end getArea()

    /**
     * Calculates the length of the first side.
     *
     * @return The length of side 1.
     */
    double getSide1() {
        return point1.distance(point2);
    }

    /**
     * Calculates the length of the second side.
     *
     * @return The length of side 2.
     */
     double getSide2() {
        return point2.distance(point3);
    }

    /**
     * Calculates the length of the third side.
     *
     * @return The length of side 3.
     */
    double getSide3() {
        return point3.distance(point1);
    }

    /**
     * Returns the first Point2D object of the triangle.
     *
     * @return The first Point2D object.
     */
    Point2D getPoint1() {
        return point1;
    }

    /**
     * Returns the calculated angle of point 1 of the triangle using points 2 and 3 as a reference.
     *
     * @return The angle of point 1.
     */
    double getAngle1() {
        return point1.angle(point2, point3);
    }

    /**
     * Returns the second Point2D object of the triangle.
     *
     * @return The second Point2D object.
     */
    Point2D getPoint2() {
        return point2;
    }

    /**
     * Returns the calculated angle of point 2 of the triangle using points 1 and 3 as a reference.
     *
     * @return The angle of point 2.
     */
    double getAngle2() {
        return point2.angle(point1, point3);
    }

    /**
     * Returns the third Point2D object of the triangle.
     *
     * @return The third Point2D object.
     */
    Point2D getPoint3() {
        return point3;
    }

    /**
     * Returns the calvulates angle of point 3 of the triangle using points 1 and 2 as a reference.
     *
     * @return The angle of point 3.
     */
    double getAngle3() {
        return point3.angle(point1, point2);
    }

    /**
     * Calculates and returns the perimeter of the triangle.
     *
     * @return The perimeter of the triangle.
     */
    double getPerimeter() {
        return (getSide1() + getSide2() + getSide3());
    }

    /**
     * Returns true when the triangle is equilateral, otherwise returns false.
     * This is evaluated using the fact that an equilateral triangle always has angles equal to 60 degrees.
     *
     * @return Whether the triangle is equilateral.
     */
    boolean isEquilateral() {
        final int ANGLE_60 = 60;
        final double COMPARE_TO = 0.01;
        return Math.abs(getAngle1() - ANGLE_60) <= COMPARE_TO && Math.abs(getAngle2() - ANGLE_60) <= COMPARE_TO && Math.abs(getAngle3() - ANGLE_60) <= COMPARE_TO;
    } // end isEquilateral()

    /**
     * Returns true when the triangle is right-angled, otherwise returns false.
     *
     * @return Whether the triangle is right-angled.
     */
    boolean isRightAngled() {
        final int ANGLE_90 = 90;
        final double COMPARE_TO = 0.001;
        return Math.abs(getAngle1() - ANGLE_90) <= COMPARE_TO || Math.abs(getAngle2() - ANGLE_90) <= COMPARE_TO || Math.abs(getAngle3() - ANGLE_90) <= COMPARE_TO;
    } // end isRightAngled()

}
