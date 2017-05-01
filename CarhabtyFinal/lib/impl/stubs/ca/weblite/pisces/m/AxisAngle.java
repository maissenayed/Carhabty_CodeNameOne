package ca.weblite.pisces.m;


/**
 *  A four-element axis angle represented by double-precision floating point 
 *  x,y,z,angle components.  An axis angle is a rotation of angle (radians)
 *  about the vector (x,y,z).
 */
public class AxisAngle extends ca.weblite.pisces.d.FPMath implements Cloneable {

	public double x;

	public double y;

	public double z;

	public double angle;

	public AxisAngle(double x, double y, double z, double angle) {
	}

	public AxisAngle(double[] a) {
	}

	public AxisAngle(AxisAngle a1) {
	}

	/**
	 *  Constructs and initializes an AxisAngle from the specified 
	 *  axis and angle.
	 *  @param axis the axis
	 *  @param angle the angle of rotation in radian
	 */
	public AxisAngle(Vector axis, double angle) {
	}

	/**
	 *  Constructs and initializes an AxisAngle to (0,0,1,0).
	 */
	public AxisAngle() {
	}

	public final AxisAngle set(double x, double y, double z, double angle) {
	}

	public final AxisAngle set(double[] a) {
	}

	public final AxisAngle set(AxisAngle a1) {
	}

	public final AxisAngle set(Vector axis, double angle) {
	}

	public final double[] get(double[] a) {
	}

	/**
	 *  Sets the value of this axis-angle to the rotational component of
	 *  the passed matrix.
	 *  If the specified matrix has no rotational component, the value
	 *  of this AxisAngle is set to an angle of 0 about an axis of (0,1,0).
	 * 
	 *  @param m1 the matrix
	 */
	public final AxisAngle set(Matrix m1) {
	}

	/**
	 *  Sets the value of this axis-angle to the rotational equivalent
	 *  of the passed quaternion.
	 *  If the specified quaternion has no rotational component, the value
	 *  of this AxisAngle is set to an angle of 0 about an axis of (0,1,0).
	 *  @param q1  the Quat
	 */
	public final AxisAngle set(Quat q1) {
	}

	public String toString() {
	}

	public boolean equals(AxisAngle a1) {
	}

	public boolean equals(Object o1) {
	}

	/**
	 *  Returns a hash code value based on the data values in this
	 *  object.  Two different AxisAngle objects with identical data values
	 *  (i.e., AxisAngle.equals returns true) will return the same hash
	 *  code value.  Two objects with different data members may return the
	 *  same hash value, although this is not likely.
	 *  @return the integer hash code value
	 */
	public int hashCode() {
	}

	public AxisAngle clone() {
	}

	/**
	 *  Get the axis angle, in radians.<br>
	 *  An axis angle is a rotation angle about the vector (x,y,z).
	 *  
	 *  @return the angle, in radians.
	 */
	public final double getAngle() {
	}

	/**
	 *  Set the axis angle, in radians.<br>
	 *  An axis angle is a rotation angle about the vector (x,y,z).
	 *  
	 *  @param angle The angle to set, in radians.
	 */
	public final AxisAngle setAngle(double angle) {
	}

	public double getX() {
	}

	public final AxisAngle setX(double x) {
	}

	public final double getY() {
	}

	public final AxisAngle setY(double y) {
	}

	public double getZ() {
	}

	public final AxisAngle setZ(double z) {
	}
}
