package ca.weblite.pisces.d;


/**
 *  
 */
public interface Constants {

	/**
	 *  Path commands
	 */
	public static final byte COMMAND_MOVE_TO = 0;

	public static final byte COMMAND_LINE_TO = 1;

	public static final byte COMMAND_QUAD_TO = 2;

	public static final byte COMMAND_CUBIC_TO = 3;

	public static final byte COMMAND_CLOSE = 4;

	/**
	 *  Arc types
	 */
	public static final int ARC_OPEN = 0;

	public static final int ARC_CHORD = 1;

	public static final int ARC_PIE = 2;

	/**
	 *  Winding rules
	 */
	public static final int WIND_EVEN_ODD = 0;

	public static final int WIND_NON_ZERO = 1;

	/**
	 *  Stroke join style
	 */
	public static final int JOIN_MITER = 0;

	public static final int JOIN_ROUND = 1;

	public static final int JOIN_BEVEL = 2;

	/**
	 *  Stroke end cap style
	 */
	public static final int CAP_BUTT = 0;

	public static final int CAP_ROUND = 1;

	public static final int CAP_SQUARE = 2;

	/**
	 *  Common Math constants, epsilon for values 0.0 to 10.0.
	 */
	public static final double EPS = 1.0E-8;

	public static final double EPS_M2 = 2.0E-8;

	public static final double EPS_D2 = 5.0E-9;

	public static final double EPS_1D2 = 0.999999995;

	public static final double Zero = 1.0E-8;

	public static final double PI = 3.141592653589793;

	public static final double PI_D2 = 1.5707963267948966;

	public static final double PI_M2 = 6.283185307179586;

	public static final double PI_D3 = 1.0471975511965976;

	/**
	 *  Multiply Degrees for Radians
	 */
	public static final double Radians = 0.017453292519943295;

	/**
	 *  1.414
	 */
	public static final double SQRT_TWO;
}
