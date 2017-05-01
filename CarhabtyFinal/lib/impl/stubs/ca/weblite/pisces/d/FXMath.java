package ca.weblite.pisces.d;


/**
 *  S15.16 fixed point
 *  
 *  @see Renderer
 */
public abstract class FXMath extends FPMath {

	public static final int FRACTION_BITS = 16;

	public static final int ONE = 65536;

	public static final int MAX_VALUE = 2147483647;

	public static final int MIN_VALUE = -2147483648;

	public static final double MAX_DOUBLE_VALUE = 32767.999992370602;

	public static final double MIN_DOUBLE_VALUE = -32768.0;

	public FXMath() {
	}

	public static final int ToFixed(double n) {
	}

	public static final int ToFixed(int n) {
	}

	public static final double ToFloat(int f) {
	}

	public static int Clamp(int x, int min, int max) {
	}
}
