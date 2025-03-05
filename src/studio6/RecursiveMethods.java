package studio6;

import java.util.Arrays;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n == 1) {
			return 0.5;
		}
		else if (n == 0) {
			return 0;
		}
		return Math.pow(0.5, n) + geometricSum(n - 1);
	}

	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
		if (radius < radiusMinimumDrawingThreshold) {
			return;
		}
		StdDraw.circle(xCenter, yCenter, radius);
		
		circlesUponCircles(xCenter, yCenter + radius, radius / 3,  radiusMinimumDrawingThreshold); //top
		circlesUponCircles(xCenter, yCenter - radius, radius / 3,  radiusMinimumDrawingThreshold); //bottom
		circlesUponCircles(xCenter - radius, yCenter, radius / 3,  radiusMinimumDrawingThreshold); //left
		circlesUponCircles(xCenter + radius, yCenter, radius / 3,  radiusMinimumDrawingThreshold); //right
		// FIXME complete the recursive drawing
	}
	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] newArray = Arrays.copyOf(array, array.length);
		int index1 = 0;
		int index2 = array.length - 1;
		if (array.length == 1) {
			return newArray;
		}
		
		// FIXME create a helper method that can recursively reverse the given array
		return toReversedHelper(newArray, index1, index2);
		
	}
	
	public static int[] toReversedHelper(int[] array, int index1, int index2) {
		
		if (index1 >= index2) {
			return array;
		}
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
		return toReversedHelper(array, index1 + 1, index2 - 1);
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if(p % q == 0) {
			return q;
		}
		return gcd(q, p % q);
		
		// FIXME compute the gcd of p and q using recursion
		
		
	}


}
