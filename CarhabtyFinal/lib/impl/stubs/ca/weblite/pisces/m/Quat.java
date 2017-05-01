package ca.weblite.pisces.m;


/**
 *  A 4-element quaternion represented by double precision floating 
 *  point x,y,z,w coordinates.  The quaternion is always normalized.
 */
public class Quat extends Tuple {

	public double w;

	public Quat(double x, double y, double z, double w) {
	}

	public Quat(double[] q) {
	}

	public Quat(Quat q) {
	}

	public Quat(Tuple t) {
	}

	/**
	 *  (0,0,0,0)
	 */
	public Quat() {
	}

	/**
	 *  Sets the value of this quaternion to the conjugate of quaternion q1.
	 *  @param q1 the source vector
	 */
	public final Quat conjugate(Quat q1) {
	}

	/**
	 *  Negate the value of of each of this quaternion's x,y,z coordinates 
	 *   in place.
	 */
	public final Quat conjugate() {
	}

	/**
	 *  Sets the value of this quaternion to the quaternion product of
	 *  quaternions q1 and q2 (this = q1 * q2).  
	 *  Note that this is safe for aliasing (e.g. this can be q1 or q2).
	 *  @param q1 the first quaternion
	 *  @param q2 the second quaternion
	 */
	public final Quat mul(Quat q1, Quat q2) {
	}

	/**
	 *  Sets the value of this quaternion to the quaternion product of
	 *  itself and q1 (this = this * q1).  
	 *  @param q1 the other quaternion
	 */
	public final Quat mul(Quat q1) {
	}

	/**
	 * 
	 *  Multiplies quaternion q1 by the inverse of quaternion q2 and places
	 *  the value into this quaternion.  The value of both argument quaternions 
	 *  is preservered (this = q1 * q2^-1).
	 *  @param q1 the first quaternion 
	 *  @param q2 the second quaternion
	 */
	public final Quat mulInverse(Quat q1, Quat q2) {
	}

	/**
	 *  Multiplies this quaternion by the inverse of quaternion q1 and places
	 *  the value into this quaternion.  The value of the argument quaternion
	 *  is preserved (this = this * q^-1).
	 *  @param q1 the other quaternion
	 */
	public final Quat mulInverse(Quat q1) {
	}

	/**
	 *  Sets the value of this quaternion to quaternion inverse of quaternion q1.
	 *  @param q1 the quaternion to be inverted
	 */
	public final Quat inverse(Quat q1) {
	}

	/**
	 *  Sets the value of this quaternion to the quaternion inverse of itself.
	 */
	public final Quat inverse() {
	}

	/**
	 *  Sets the value of this quaternion to the normalized value
	 *  of quaternion q1.
	 *  @param q1 the quaternion to be normalized.
	 */
	public final Quat set(double x, double y, double z, double w) {
	}

	/**
	 *  Normalizes the value of this quaternion in place.
	 */
	public final Quat normalize() {
	}

	/**
	 *  Sets the value of this quaternion to the rotational component of
	 *  the passed matrix.
	 *  @param m1 the matrix
	 */
	public final Quat set(Matrix m1) {
	}

	/**
	 *  Sets the value of this quaternion to the equivalent rotation
	 *  of the AxisAngle argument.
	 *  @param a  the AxisAngle to be emulated
	 */
	public final Quat set(AxisAngle a) {
	}

	/**
	 *   Performs a great circle interpolation between this quaternion
	 *   and the quaternion parameter and places the result into this
	 *   quaternion.
	 *   @param q1  the other quaternion
	 *   @param alpha  the alpha interpolation parameter
	 */
	public final Quat interpolate(Quat q1, double alpha) {
	}

	/**
	 *   Performs a great circle interpolation between quaternion q1
	 *   and quaternion q2 and places the result into this quaternion.
	 *   @param q1  the first quaternion
	 *   @param q2  the second quaternion
	 *   @param alpha  the alpha interpolation parameter
	 */
	public final Quat interpolate(Quat q1, Quat q2, double alpha) {
	}

	public Quat clone() {
	}
}
