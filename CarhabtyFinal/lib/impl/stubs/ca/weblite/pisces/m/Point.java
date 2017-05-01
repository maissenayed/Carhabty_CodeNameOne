package ca.weblite.pisces.m;


/**
 *  A 3 element point that is represented by double precision floating point 
 *  x,y,z coordinates.
 */
public class Point extends Tuple {

	public Point(double x, double y, double z) {
	}

	public Point(double[] p) {
	}

	public Point(Point p1) {
	}

	public Point(Tuple t1) {
	}

	public Point() {
	}

	/**
	 *  Returns the square of the distance between this point and point p1.
	 *  @param p1 the other point 
	 *  @return the square of the distance
	 */
	public final double distanceSquared(Point p1) {
	}

	/**
	 *  Returns the distance between this point and point p1.
	 *  @param p1 the other point
	 *  @return the distance 
	 */
	public final double distance(Point p1) {
	}

	/**
	 *  Computes the L-1 (Manhattan) distance between this point and
	 *  point p1.  The L-1 distance is equal to:
	 *   abs(x1-x2) + abs(y1-y2) + abs(z1-z2).
	 *  @param p1 the other point
	 *  @return  the L-1 distance
	 */
	public final double distanceL1(Point p1) {
	}

	/**
	 *  Computes the L-infinite distance between this point and
	 *  point p1.  The L-infinite distance is equal to
	 *  MAX[abs(x1-x2), abs(y1-y2), abs(z1-z2)].
	 *  @param p1 the other point
	 *  @return  the L-infinite distance
	 */
	public final double distanceLinf(Point p1) {
	}

	public Point clone() {
	}
}
