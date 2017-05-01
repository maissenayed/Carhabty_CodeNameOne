package ca.weblite.pisces.m;


/**
 *  A generic 3-element tuple that is represented by double-precision 
 *  floating point x,y,z coordinates.
 */
public class Tuple extends ca.weblite.pisces.d.FPMath implements Cloneable {

	public double x;

	public double y;

	public double z;

	public Tuple(double x, double y, double z) {
	}

	public Tuple(double[] t) {
	}

	public Tuple(Tuple t1) {
	}

	public Tuple() {
	}

	public final Tuple set(double x, double y, double z) {
	}

	public final Tuple set(double[] t) {
	}

	public final Tuple set(Tuple t1) {
	}

	/**
	 *  Copies the x,y,z coordinates of this tuple into the array t
	 *  of length 3.
	 *  @param t  the target array 
	 */
	public final double[] get(double[] t) {
	}

	public final Tuple get(Tuple t) {
	}

	public final Tuple add(Tuple t1, Tuple t2) {
	}

	public final Tuple add(Tuple t1) {
	}

	public final Tuple sub(Tuple t1, Tuple t2) {
	}

	public final Tuple sub(Tuple t1) {
	}

	public final Tuple negate(Tuple t1) {
	}

	public final Tuple negate() {
	}

	public final Tuple scale(double s, Tuple t1) {
	}

	public final Tuple scale(double s) {
	}

	/**
	 *  Sets the value of this tuple to the scalar multiplication
	 *  of tuple t1 and then adds tuple t2 (this = s*t1 + t2).
	 *  @param s the scalar value
	 *  @param t1 the tuple to be multipled
	 *  @param t2 the tuple to be added
	 */
	public final Tuple scaleAdd(double s, Tuple t1, Tuple t2) {
	}

	/**
	 *  Sets the value of this tuple to the scalar multiplication
	 *  of itself and then adds tuple t1 (this = s*this + t1).
	 *  @param s the scalar value
	 *  @param t1 the tuple to be added
	 */
	public final Tuple scaleAdd(double s, Tuple t1) {
	}

	/**
	 *  Returns a string that contains the values of this Tuple.
	 *  The form is (x,y,z).
	 *  @return the String representation
	 */
	public String toString() {
	}

	/**
	 *  Returns a hash code value based on the data values in this
	 *  object.  Two different Tuple objects with identical data values
	 *  (i.e., Tuple.equals returns true) will return the same hash
	 *  code value.  Two objects with different data members may return the
	 *  same hash value, although this is not likely.
	 *  @return the integer hash code value
	 */
	public int hashCode() {
	}

	/**
	 *  Returns true if all of the data members of Tuple t1 are
	 *  equal to the corresponding data members in this Tuple.
	 *  @param t1  the tuple with which the comparison is made
	 *  @return  true or false
	 */
	public boolean equals(Tuple t1) {
	}

	/**
	 *  Returns true if the Object t1 is of type Tuple and all of the
	 *  data members of t1 are equal to the corresponding data members in
	 *  this Tuple.
	 *  @param t1  the Object with which the comparison is made
	 *  @return  true or false
	 */
	public boolean equals(Object t1) {
	}

	/**
	 *   Clamps the tuple parameter to the range [low, high] and 
	 *   places the values into this tuple.  
	 *   @param min   the lowest value in the tuple after clamping
	 *   @param max  the highest value in the tuple after clamping 
	 *   @param t   the source tuple, which will not be modified
	 */
	public final Tuple clamp(double min, double max, Tuple t) {
	}

	/**
	 * 
	 *   Clamps the minimum value of the tuple parameter to the min 
	 *   parameter and places the values into this tuple.
	 *   @param min   the lowest value in the tuple after clamping 
	 *   @param t   the source tuple, which will not be modified
	 */
	public final Tuple clampMin(double min, Tuple t) {
	}

	/**
	 * 
	 *   Clamps the maximum value of the tuple parameter to the max 
	 *   parameter and places the values into this tuple.
	 *   @param max the highest value in the tuple after clamping  
	 *   @param t   the source tuple, which will not be modified
	 */
	public final Tuple clampMax(double max, Tuple t) {
	}

	/**
	 * 
	 *   Sets each component of the tuple parameter to its absolute 
	 *   value and places the modified values into this tuple.
	 *   @param t   the source tuple, which will not be modified
	 */
	public final Tuple absolute(Tuple t) {
	}

	/**
	 *   Clamps this tuple to the range [low, high].
	 *   @param min  the lowest value in this tuple after clamping
	 *   @param max  the highest value in this tuple after clamping
	 */
	public final Tuple clamp(double min, double max) {
	}

	/**
	 *   Clamps the minimum value of this tuple to the min parameter.
	 *   @param min   the lowest value in this tuple after clamping
	 */
	public final Tuple clampMin(double min) {
	}

	/**
	 *   Clamps the maximum value of this tuple to the max parameter.
	 *   @param max   the highest value in the tuple after clamping
	 */
	public final Tuple clampMax(double max) {
	}

	/**
	 *   Sets each component of this tuple to its absolute value.
	 */
	public final Tuple absolute() {
	}

	/**
	 *   Linearly interpolates between tuples t1 and t2 and places the 
	 *   result into this tuple:  this = (1-alpha)*t1 + alpha*t2.
	 *   @param t1  the first tuple
	 *   @param t2  the second tuple  
	 *   @param alpha  the alpha interpolation parameter  
	 */
	public final Tuple interpolate(Tuple t1, Tuple t2, double alpha) {
	}

	/**
	 * 
	 *   Linearly interpolates between this tuple and tuple t1 and 
	 *   places the result into this tuple:  this = (1-alpha)*this + alpha*t1. 
	 *   @param t1  the first tuple 
	 *   @param alpha  the alpha interpolation parameter   
	 */
	public final Tuple interpolate(Tuple t1, double alpha) {
	}

	public Tuple clone() {
	}

	public final double getX() {
	}

	public final Tuple setX(double x) {
	}

	public final double getY() {
	}

	public final Tuple setY(double y) {
	}

	public final double getZ() {
	}

	public final Tuple setZ(double z) {
	}
}
