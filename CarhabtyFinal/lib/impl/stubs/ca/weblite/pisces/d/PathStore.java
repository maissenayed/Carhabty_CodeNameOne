package ca.weblite.pisces.d;


/**
 *  Reproducible path sink
 */
public class PathStore extends PathSink implements PathSource {

	public PathStore() {
	}

	public PathStore(int inicap) {
	}

	public Point2D getCurrentPoint() {
	}

	/**
	 *  Will change the first path instruction from a moveTo to a lineTo of join is
	 *  true.  Will change to a moveTo if it is false.
	 *  @param join 
	 */
	public void join(boolean join) {
	}

	public void moveTo(double x0, double y0) {
	}

	public void lineJoin() {
	}

	public void lineTo(double x1, double y1) {
	}

	/**
	 *  Returns the number of points in this path.
	 *  @return 
	 */
	public int length() {
	}

	/**
	 *  Gets the coordinate of the point at the given index and stores it in the 
	 *  provided double[]
	 *  @param i
	 *  @param point 
	 */
	public void getPoint(int i, double[] point) {
	}

	/**
	 *  Gets the coordinate of the point at the given index and stores it in the 
	 *  provided float[]
	 *  @param i
	 *  @param point 
	 */
	public void getPoint(int i, float[] point) {
	}

	public void quadTo(double x1, double y1, double x2, double y2) {
	}

	public void cubicTo(double x1, double y1, double x2, double y2, double x3, double y3) {
	}

	public void close() {
	}

	public void end() {
	}

	public void produce(PathSink consumer) {
	}

	public void dispose() {
	}

	protected void ensureCapacity(int elements) {
	}

	public void transform(ca.weblite.pisces.m.Matrix transform) {
	}

	/**
	 *  CURRENTLY BROKEN!!!!  For some reason the path gets corrupted when using this
	 *  method.  Need to work it out.
	 *  @param it
	 *  @param append 
	 */
	public void append(PathIterator it, boolean append) {
	}

	public void append(PathStore path, boolean append) {
	}

	public Rectangle2D getBounds2D() {
	}

	public void getBounds2D(Rectangle2D rect) {
	}

	public PathIterator getPathIterator(ca.weblite.pisces.m.Matrix transform) {
	}
}
