package ca.weblite.pisces.m;


/**
 *  A 3-element vector that is represented by double-precision floating point 
 *  x,y,z coordinates.  If this value represents a normal, then it should
 *  be normalized.
 */
public class Vector extends Tuple {

	public Vector(double x, double y, double z) {
	}

	public Vector(double[] v) {
	}

	public Vector(Vector v1) {
	}

	public Vector(Tuple t1) {
	}

	public Vector() {
	}

	/**
	 *  Sets this vector to the vector cross product of vectors v1 and v2.
	 *  @param v1 the first vector
	 *  @param v2 the second vector
	 */
	public final Vector cross(Vector v1, Vector v2) {
	}

	/**
	 *  Sets the value of this vector to the normalization of vector v1.
	 *  @param v1 the un-normalized vector
	 */
	public final Vector normalize(Vector v1) {
	}

	/**
	 *  Normalizes this vector in place.
	 */
	public final Vector normalize() {
	}

	/**
	 *  Returns the dot product of this vector and vector v1.
	 *  @param v1 the other vector
	 *  @return the dot product of this and v1
	 */
	public final double dot(Vector v1) {
	}

	/**
	 *  Returns the squared length of this vector.
	 *  @return the squared length of this vector
	 */
	public final double lengthSquared() {
	}

	/**
	 *  Returns the length of this vector.
	 *  @return the length of this vector
	 */
	public final double length() {
	}

	/**
	 * 
	 *    Returns the angle in radians between this vector and the vector
	 *    parameter; the return value is constrained to the range [0,PI]. 
	 *    @param v1    the other vector 
	 *    @return   the angle in radians in the range [0,PI] 
	 */
	public final double angle(Vector v1) {
	}

	public Vector clone() {
	}
}
