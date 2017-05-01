package ca.weblite.pisces.d;


/**
 *  The <code>Flattener</code> class rewrites a general path, which
 *  may include curved segments, into one containing only linear
 *  segments suitable for sending to a <code>LineSink</code>.
 * 
 *  <p> Curved segments specified by <code>quadTo</code> and
 *  <code>curveTo</code> commands will be subdivided into two pieces.
 *  When the control points of a segment lie sufficiently close
 *  togther, such that <code>max(x_i) - min(x_i) < flatness</code> and
 *  <code>max(y_i) - min(y_i) < flatness</code> for a user-supplied
 *  <code>flatness</code> parameter, a <code>lineTo</code> command is
 *  emitted between the first and last points of the curve.
 */
public class Flattener extends PathSink {

	public static final double MAX_CHORD_LENGTH_SQ = 16.0;

	public static final double MIN_CHORD_LENGTH_SQ = 0.25;

	public static final double LG_FLATNESS = 0.5;

	public static final int FLATNESS_SQ_SHIFT = -1;

	/**
	 *  Empty constructor.  <code>setOutput</code> and
	 *  <code>setFlatness</code> must be called prior to calling any
	 *  other methods.
	 */
	public Flattener() {
	}

	/**
	 *  Constructs a <code>Flattener</code> that will rewrite any
	 *  incoming <code>quadTo</code> and <code>curveTo</code> commands
	 *  into a series of <code>lineTo</code> commands with maximum X
	 *  and Y extents no larger than the supplied <code>flatness</code>
	 *  value.  The flat segments will be sent as commands to the given
	 *  <code>LineSink</code>.
	 * 
	 *  @param output a <code>LineSink</code> to which commands
	 *  should be sent.
	 *  @param flatness the maximum extent of a subdivided output line
	 *  segment
	 */
	public Flattener(LineSink output, double flatness) {
	}

	public void dispose() {
	}

	public void setOutput(LineSink output) {
	}

	public void setFlatness(double flatness) {
	}

	public void moveTo(double x0, double y0) {
	}

	public void lineJoin() {
	}

	public void lineTo(double x1, double y1) {
	}

	public void quadTo(double x1, double y1, double x2, double y2) {
	}

	public void cubicTo(double x1, double y1, double x2, double y2, double x3, double y3) {
	}

	public void close() {
	}

	public void end() {
	}
}
