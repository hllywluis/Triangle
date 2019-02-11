/*=============================================================================
| Source code: TriangleTester.java
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
| Compile/Run: javac TriangleTester.java
|              java TriangleTester
|
| +-----------------------------------------------------------------------------+
|
| Description: A tester class for the Triangle class. This class prompts the user for input and displays output.
|
| Input: 6 values for each of the coordinates of the triangle.
|
| Output: A comprehensive listing of properties of the triangle, aligned for easy comparison.
|
| Process: A DecimalFormat object is created in order to format the decimals to 4 places, and a new Triangle object is
|          created using the method createTriangle(). Finally, the output is presented using the Triangle and
|          DecimalFormat objects passed into the printTriangle() method.
|
| Required Features Not Included: None.
|
| Known Bugs: None.
\*===========================================================================*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class TriangleTester {

    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat("###.####");

        Triangle triangle = createTriangle();

        System.out.println(printTriangle(triangle, decimalFormat));
    } // end main()

    /**
     * Creates a new triangle using user input for its coordinates.
     *
     * @return The newly created Triangle.
     */
    private static Triangle createTriangle() {

        System.out.println("Enter 6 coordinates for the triangle, in order x1 -> y1 -> x2 -> y2 -> x3 -> y3.\n" +
                "Please press 'return' after entering each one.");

        double point1x = setPoint();
        double point1y = setPoint();
        double point2x = setPoint();
        double point2y = setPoint();
        double point3x = setPoint();
        double point3y = setPoint();

        return new Triangle(point1x, point1y, point2x, point2y, point3x, point3y);
    } // end createTriangle()

    /**
     * Validates input to only accept numerical input.
     *
     * @return The value of the coordinate.
     */
    private static double setPoint() {
        Scanner scanner = new Scanner(System.in);
        double coordinateValue = 0;
        boolean valueObtained = false;

        do {
            if (scanner.hasNextDouble()) {
                coordinateValue = scanner.nextDouble();
                valueObtained = true;
            }
            else {
                System.out.println("Invalid input, please enter numbers only.");
                scanner.next();
            }
        } while(!valueObtained);

        return coordinateValue;
    }

    /**
     * Prints a description of the newly created triangle.
     *
     * @param triangle      The Triangle object which contains all values.
     * @param decimalFormat The decimal formatter used to format the decimals.
     * @return The String containing the description of the triangle.
     */
    private static String printTriangle(Triangle triangle, DecimalFormat decimalFormat) {
        return ("Point 1 Coordinates: \t(" + triangle.getPoint1().getX() + ", " + triangle.getPoint1().getY() + ")\n" +
                "Point 2 Coordinates: \t(" + triangle.getPoint2().getX() + ", " + triangle.getPoint2().getY() + ")\n" +
                "Point 3 Coordinates: \t(" + triangle.getPoint3().getX() + ", " + triangle.getPoint3().getY() + ")\n" +
                "Length of Side 1: \t\t" + decimalFormat.format(triangle.getSide1()) + " units\n" +
                "Length of Side 2: \t\t" + decimalFormat.format(triangle.getSide2()) + " units\n" +
                "Length of Side 3: \t\t" + decimalFormat.format(triangle.getSide3()) + " units\n" +
                "Angle of Point 1: \t\t" + decimalFormat.format(triangle.getAngle1()) + " degrees\n" +
                "Angle of Point 2: \t\t" + decimalFormat.format(triangle.getAngle2()) + " degrees\n" +
                "Angle of Point 3: \t\t" + decimalFormat.format(triangle.getAngle3()) + " degrees\n" +
                "Perimeter of Triangle: \t" + decimalFormat.format(triangle.getPerimeter()) + " units\n" +
                "Area of the Triangle: \t" + decimalFormat.format(triangle.getArea()) + " square units\n" +
                "Triangle Equilateral: \t" + triangle.isEquilateral() + "\n" +
                "Triangle Right-Angled: \t" + triangle.isRightAngled());
    } // end printTriangle()

}
