package ca.weblite.pisces;


/**
 *  Pisces user interface.
 *  
 *  Most operations pass through the graphics pipeline including
 *  stroking and filling and transformations.  
 *  
 *  Blit operations skip the pipeline and pass directly into the pixel
 *  blender and onto the surface (framebuffer).  The blit pixels
 *  include transparency for blending into the surface, but subpixel
 *  sampling for antialiasing is not performed.  
 *  
 *  @see Path
 *  @see Polygon
 */
public class Graphics implements Cloneable {

	public final int width;

	public final int height;

	protected final d.Surface.Sink surface;

	public Graphics(int w, int h) {
	}

	public Graphics(Image img) {
	}

	public com.codename1.ui.Image toImage() {
	}

	public com.codename1.ui.Image toImage(int x, int y, int w, int h) {
	}

	public final byte[] toPNG() {
	}

	public final byte[] toPNG(boolean alpha) {
	}

	public final byte[] toPNG(boolean alpha, int compression) {
	}

	public final Graphics create() {
	}

	public final Graphics create(double x, double y, double w, double h) {
	}

	public void dispose() {
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
	 *  @return Self for chaining.
	 */
	public final Graphics setStroke(double lineWidth, int capStyle, int joinStyle, double miterLimit, double[] dashArray, double dashPhase) {
	}

	public final Graphics setAntialiasing(boolean antialiasingOn) {
	}

	public final boolean getAntialiasing() {
	}

	public final Color getColor() {
	}

	public final Graphics setColor(Color color) {
	}

	public final Font getFont() {
	}

	public final Graphics setFont(Font font) {
	}

	public final Graphics setTransform(m.Matrix transform) {
	}

	public final m.Matrix getTransform() {
	}

	public final Graphics setClip(double x, double y, double width, double height) {
	}

	public final Graphics resetClip() {
	}

	public final Graphics setStroke() {
	}

	public final Graphics setFill() {
	}

	/**
	 *  Begin path operations
	 */
	public final Graphics beginRendering(int windingRule) {
	}

	public final Graphics moveTo(double x0, double y0) {
	}

	public final Graphics lineTo(double x1, double y1) {
	}

	public final Graphics lineJoin() {
	}

	public final Graphics quadTo(double x1, double y1, double x2, double y2) {
	}

	public final Graphics cubicTo(double x1, double y1, double x2, double y2, double x3, double y3) {
	}

	/**
	 *  Close a path by emitting a line from the last point "pen down"
	 *  (e.g. last lineTo) to the last point "pen up" (last moveTo).
	 */
	public final Graphics close() {
	}

	/**
	 *  End path operations
	 */
	public final Graphics endRendering() {
	}

	public final Graphics getBoundingBox(double[] bbox) {
	}

	public final Graphics draw(Path p) {
	}

	public final Graphics fill(Path p) {
	}

	public final Graphics blit(d.Surface image) {
	}

	public final Graphics blit(com.codename1.ui.Image image) {
	}

	public final Graphics blit(d.Surface image, int x, int y) {
	}

	public final Graphics blit(com.codename1.ui.Image image, int x, int y) {
	}

	public final Graphics blit(d.Surface image, int x, int y, float opacity) {
	}

	public final Graphics blit(com.codename1.ui.Image image, int x, int y, float opacity) {
	}

	public final Graphics blit(d.Surface image, int srcX, int srcY, int dstX, int dstY, float opacity) {
	}

	public final Graphics blit(com.codename1.ui.Image image, int srcX, int srcY, int dstX, int dstY, float opacity) {
	}

	public final Graphics blit(d.Surface image, int srcX, int srcY, int dstX, int dstY, int w, int h, float opacity) {
	}

	public final Graphics blit(com.codename1.ui.Image image, int srcX, int srcY, int dstX, int dstY, int w, int h, float opacity) {
	}

	/**
	 *  Bitmap font
	 */
	public final Graphics blit(String string, int x, int y) {
	}

	/**
	 *  Bitmap font
	 */
	public final Graphics blit(String string, int x, int y, float op) {
	}

	/**
	 *  Vector font
	 */
	public final Graphics draw(String string, int x, int y) {
	}

	/**
	 *  Vector font
	 */
	public final Graphics draw(String string, int x, int y, float op) {
	}

	public final Graphics drawLine(double x0, double y0, double x1, double y1) {
	}

	public final Graphics fillRect(double x, double y, double w, double h) {
	}

	public final Graphics drawRect(double x, double y, double w, double h) {
	}

	public final Graphics drawOval(double x, double y, double w, double h) {
	}

	public final Graphics fillOval(double x, double y, double w, double h) {
	}

	public final Graphics drawArc(double x, double y, double width, double height, double startAngle, double arcAngle, int arcType) {
	}

	public final Graphics fillArc(double x, double y, double width, double height, double startAngle, double arcAngle, int arcType) {
	}

	public final Graphics fillOrDrawArc(double x, double y, double width, double height, double startAngle, double arcAngle, int arcType, boolean stroke) {
	}

	public final Graphics clearRect(double x, double y, double w, double h) {
	}

	protected Graphics clone() {
	}
}
