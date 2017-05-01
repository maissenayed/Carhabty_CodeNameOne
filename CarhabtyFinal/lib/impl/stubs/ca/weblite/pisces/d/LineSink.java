package ca.weblite.pisces.d;


/**
 *  The {@link LineSink} interface accepts a series of line
 *  drawing commands: <code>moveTo</code>, <code>lineTo</code>,
 *  <code>close</code> (equivalent to a <code>lineTo</code> command
 *  with an argument equal to the argument of the last
 *  <code>moveTo</code> command), and <code>end</code>.
 * 
 *  <p> A {@link Flattener} may be used to connect a general path
 *  source to a {@link LineSink}.
 * 
 *  <p> The {@link Renderer} class implements the
 *  {@link LineSink} interface.
 */
public abstract class LineSink extends FXMath implements Cloneable {

	public LineSink() {
	}

	/**
	 *  Moves the current drawing position to the point (x0, y0).
	 * 
	 *  @param x0 the X coordinate 
	 *  @param y0 the Y coordinate 
	 */
	public abstract void moveTo(double x0, double y0) {
	}

	/**
	 *  Provides a hint that the current segment should be joined to
	 *  the following segment using an explicit miter or round join if
	 *  required.
	 * 
	 *  <p> An application-generated path will generally have no need
	 *  to contain calls to this method; they are typically introduced
	 *  by a {@link Flattener} to mark segment divisions that appear in
	 *  its input, and consumed by a {@link Stroker} that is
	 *  responsible for emitting the miter or round join segments.
	 * 
	 *  <p> Other {@link LineSink} classes should simply pass this hint
	 *  to their output sink as needed.
	 */
	public abstract void lineJoin() {
	}

	/**
	 *  Draws a line from the current drawing position to the point
	 *  <code>(x1, y1)</code> and sets the current drawing position to
	 *  <code>(x1, y1)</code>.
	 * 
	 *  @param x1 the X coordinate 
	 *  @param y1 the Y coordinate 
	 */
	public abstract void lineTo(double x1, double y1) {
	}

	/**
	 *  Closes the current path by drawing a line from the current
	 *  drawing position to the point specified by the most recent
	 *  <code>moveTo</code> command.
	 */
	public abstract void close() {
	}

	/**
	 *  Ends the current path.  It may be necessary to end a path in
	 *  order to allow end caps to be drawn.
	 */
	public abstract void end() {
	}

	public abstract void dispose() {
	}

	public LineSink clone() {
	}
}
