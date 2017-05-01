package ca.weblite.pisces.d;


public class Stroker extends LineSink {

	/**
	 *  Empty constructor.  <code>setOutput</code> and
	 *  <code>setParameters</code> must be called prior to calling any
	 *  other methods.
	 */
	public Stroker() {
	}

	/**
	 *  Constructs a <code>Stroker</code>.
	 * 
	 *  @param output an output <code>LineSink</code>.
	 *  @param lineWidth the desired line width in pixels, in S15.16
	 *  format.
	 *  @param capStyle the desired end cap style, one of
	 *  <code>CAP_BUTT</code>, <code>CAP_ROUND</code> or
	 *  <code>CAP_SQUARE</code>.
	 *  @param joinStyle the desired line join style, one of
	 *  <code>JOIN_MITER</code>, <code>JOIN_ROUND</code> or
	 *  <code>JOIN_BEVEL</code>.
	 *  @param miterLimit the desired miter limit
	 *  @param transform a <code>Matrix</code> object indicating
	 *  the transform that has been previously applied to all incoming
	 *  coordinates.  This is required in order to produce consistently
	 *  shaped end caps and joins.
	 */
	public Stroker(LineSink output, double lineWidth, int capStyle, int joinStyle, double miterLimit, ca.weblite.pisces.m.Matrix transform) {
	}

	public void dispose() {
	}

	/**
	 *  Sets the output <code>LineSink</code> of this
	 *  <code>Stroker</code>.
	 * 
	 *  @param output an output <code>LineSink</code>.
	 */
	public void setOutput(LineSink output) {
	}

	/**
	 *  Sets the parameters of this <code>Stroker</code>.
	 *  @param lineWidth the desired line width in pixels, in S15.16
	 *  format.
	 *  @param capStyle the desired end cap style, one of
	 *  <code>CAP_BUTT</code>, <code>CAP_ROUND</code> or
	 *  <code>CAP_SQUARE</code>.
	 *  @param joinStyle the desired line join style, one of
	 *  <code>JOIN_MITER</code>, <code>JOIN_ROUND</code> or
	 *  <code>JOIN_BEVEL</code>.
	 *  @param miterLimit the desired miter limit, in S15.16 format.
	 *  @param transform a <code>Matrix</code> object indicating
	 *  the transform that has been previously applied to all incoming
	 *  coordinates.  This is required in order to produce consistently
	 *  shaped end caps and joins.
	 */
	public void setParameters(double lineWidth, int capStyle, int joinStyle, double miterLimit, ca.weblite.pisces.m.Matrix transform) {
	}

	public void moveTo(double x0, double y0) {
	}

	public void lineJoin() {
	}

	public void lineTo(double x1, double y1) {
	}

	public void close() {
	}

	public void end() {
	}
}
