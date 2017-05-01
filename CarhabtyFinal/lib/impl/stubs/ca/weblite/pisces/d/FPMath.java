package ca.weblite.pisces.d;


/**
 *  Floating point
 *  
 *  <h3>Epsilon scalar radii</h3>
 *  
 *  Because floating point numeric values are not uniformly distributed
 *  on the real number domain
 *  
 *  <pre>
 *  V = s * 1.f * 2**(e*-127)
 *  </pre>
 *  
 *  for sign 's', exponent 'e' and fraction 'f', rounding error checks
 *  must be scaled to the range of the value under test.
 *  
 */
public abstract class FPMath implements Constants {

	public FPMath() {
	}

	public static double Hypot(double x, double y) {
	}

	public static final boolean EEQ(double a, double b) {
	}

	public static final boolean ELE(double a, double b) {
	}

	public static final boolean ELT(double a, double b) {
	}

	public static final boolean EGE(double a, double b) {
	}

	public static final boolean EGT(double a, double b) {
	}

	/**
	 *  Scale FP epsilon
	 */
	public static final double E(double v) {
	}

	public static final double E(double u, double v) {
	}

	/**
	 *  Epsilon-zero
	 */
	public static final double Z(double v) {
	}

	/**
	 *  Epsilon-(zero or one)
	 */
	public static final double Z1(double v) {
	}
}
