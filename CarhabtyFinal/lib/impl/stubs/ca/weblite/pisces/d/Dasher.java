package ca.weblite.pisces.d;


/**
 *  The <code>Dasher</code> class takes a series of linear commands
 *  (<code>moveTo</code>, <code>lineTo</code>, <code>close</code> and
 *  <code>end</code>) and breaks them into smaller segments according to a
 *  dash pattern array and a starting dash phase.
 * 
 *  <p> Issues: in J2Se, a zero length dash segment as drawn as a very
 *  short dash, whereas Pisces does not draw anything.  The PostScript
 *  semantics are unclear.
 */
public class Dasher extends LineSink {

	/**
	 *  Empty constructor.  <code>setOutput</code> and
	 *  <code>setParameters</code> must be called prior to calling any
	 *  other methods.
	 */
	public Dasher() {
	}

	public Dasher(LineSink output, double[] dash, double phase, ca.weblite.pisces.m.Matrix transform) {
	}

	public void dispose() {
	}

	public void setOutput(LineSink output) {
	}

	public void setParameters(double[] dash, double phase, ca.weblite.pisces.m.Matrix transform) {
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
