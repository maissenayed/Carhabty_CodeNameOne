package ca.weblite.pisces.d;


/**
 *  Floating point user interface (package driver).
 *  
 *  @see ca.weblite.pisces.Graphics
 *  @see ca.weblite.pisces.d2.Renderer
 */
public final class Pisces extends PathSink implements Surface.Sink {

	public Pisces(Surface.Sink surface) {
	}

	public void dispose() {
	}

	public int getDataType() {
	}

	public Object getData() {
	}

	public int getWidth() {
	}

	public int getHeight() {
	}

	public void getRGB(int[] argb, int offset, int scan, int x, int y, int w, int h) {
	}

	public void setRGB(int[] argb, int offset, int scan, int x, int y, int w, int h) {
	}

	public void blit(Surface ps, int srcX, int srcY, int dstX, int dstY, int w, int h, float opacity) {
	}

	public void blit(int[] argb, int offset, int scan, int x, int y, int w, int h, float opacity) {
	}

	public void setAntialiasing(boolean antialiasingOn) {
	}

	public boolean getAntialiasing() {
	}

	public ca.weblite.pisces.Color getColor() {
	}

	public void setColor(ca.weblite.pisces.Color color) {
	}

	public void setPaint(Paint paint, ca.weblite.pisces.m.Matrix transform) {
	}

	public PathSink getStroker() {
	}

	public PathSink getFiller() {
	}

	public PathSink getTextFiller() {
	}

	/**
	 *  Sets the current stroke parameters.
	 * 
	 *  @param lineWidth the sroke width
	 *  @param capStyle the line cap style, one of
	 *  <code>Stroker.CAP_*</code>.
	 *  @param joinStyle the line cap style, one of
	 *  <code>Stroker.JOIN_*</code>.
	 *  @param miterLimit the stroke miter limit
	 *  @param dashArray an <code>int</code> array containing the dash
	 *  segment lengths in S15.16 format, or <code>null</code>.
	 *  @param dashPhase the starting dash offset, in S15.16 format.
	 */
	public void setStroke(double lineWidth, int capStyle, int joinStyle, double miterLimit, double[] dashArray, double dashPhase) {
	}

	/**
	 *  Sets the current transform from user to window coordinates.
	 * 
	 *  @param transform an <code>Matrix</code> object.
	 */
	public void setTransform(ca.weblite.pisces.m.Matrix transform) {
	}

	public ca.weblite.pisces.m.Matrix getTransform() {
	}

	/**
	 *  Sets a clip rectangle for all primitives.  Each primitive will be
	 *  clipped to the intersection of this rectangle and the destination
	 *  image bounds.
	 */
	public void setClip(double minX, double minY, double width, double height) {
	}

	/**
	 *  Resets the clip rectangle.  Each primitive will be clipped only
	 *  to the destination image bounds.
	 */
	public void resetClip() {
	}

	public void beginRendering(int windingRule) {
	}

	/**
	 *  Begins the rendering of path data.  The supplied clipping
	 *  bounds are intersected against the current clip rectangle and
	 *  the destination image bounds; only pixels within the resulting
	 *  rectangle may be written to.
	 */
	public void beginRendering(double minX, double minY, double width, double height, int windingRule) {
	}

	public void moveTo(double x0, double y0) {
	}

	public void lineTo(double x1, double y1) {
	}

	public void lineJoin() {
	}

	public void quadTo(double x1, double y1, double x2, double y2) {
	}

	public void cubicTo(double x1, double y1, double x2, double y2, double x3, double y3) {
	}

	public void close() {
	}

	public void end() {
	}

	/**
	 *  Completes the rendering of path data.  Destination pixels will
	 *  be written at this time.
	 */
	public void endRendering() {
	}

	/**
	 *  Render a complex path, possibly caching the results in a form
	 *  that can be rendered more rapidly at a future time.  The cache
	 *  will be valid across changes in paint style, but not across
	 *  changes to the transform, stroke/fill mode setting, stroke
	 *  parameters, or winding rule.
	 * 
	 *  <p> The implementation does not check the validity of the cache
	 *  relative to changes in the renderer state.  It is up to the
	 *  caller to manually invalidate the cache object as needed.  The
	 *  other parameters must contain a valid description of the path
	 *  even if a valid cache is passed in.  If <code>cache</code> is
	 *  <code>null</code>, no caching is performed.
	 * 
	 *  <p> A command that would reference coordinates outside the
	 *  bounds of the arguments will be silently ignored.
	 * 
	 *  <p> Retrieval of the bounding box using
	 *  <code>getBoundingBox</code> following a call to
	 *  <code>render</code> is supported.
	 *  
	 *  @param commands One or more members of COMMAND_*, and implying
	 *  references to coords.
	 *  @param coords One or (X,Y) pairs referenced by commands.
	 *  @param windingRule Render fill rule, one of WIND_*.
	 *  @param cache Optional rendering cache.
	 */
	public void renderPath(byte[] commands, double[] coords, int windingRule, PiscesCache cache) {
	}

	/**
	 *  Returns a bounding box containing all pixels drawn during the
	 *  rendering of the most recent primitive
	 *  (beginRendering/endRendering pair).
	 *  
	 *  @return (x, y, width, height)
	 */
	public void getBoundingBox(double[] bbox) {
	}

	public void setStroke() {
	}

	public void setFill() {
	}

	public void setTextFill() {
	}

	public void drawLine(double x0, double y0, double x1, double y1) {
	}

	public void fillRect(double x, double y, double w, double h) {
	}

	public void drawRect(double x, double y, double w, double h) {
	}

	public void drawOval(double x, double y, double w, double h) {
	}

	public void fillOval(double x, double y, double w, double h) {
	}

	public void fillRoundRect(double x, double y, double w, double h, double aw, double ah) {
	}

	public void drawRoundRect(double x, double y, double w, double h, double aw, double ah) {
	}

	public void drawArc(double x, double y, double width, double height, double startAngle, double arcAngle, int arcType) {
	}

	public void fillArc(double x, double y, double width, double height, double startAngle, double arcAngle, int arcType) {
	}

	public void fillOrDrawArc(double x, double y, double width, double height, double startAngle, double arcAngle, int arcType, boolean stroke) {
	}

	public void clearRect(double x, double y, double w, double h) {
	}

	public Pisces clone() {
	}
}
