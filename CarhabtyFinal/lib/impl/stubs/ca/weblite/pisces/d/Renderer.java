package ca.weblite.pisces.d;


/**
 *  The backend blender is {@link Blit}.  This front end to the blender
 *  computes an alpha plane (from Renderer field rowAA to Blit argument
 *  alphaData) between a sink (source) and a surface (target) for
 *  subpixel blending (antialiasing).
 *  
 *  @see ca.weblite.pisces
 *  @see Blit
 */
public final class Renderer extends RendererBase {

	public static final int INITIAL_EDGES = 1000;

	public static final int DEFAULT_INDICES_SIZE = 8192;

	public static final int DEFAULT_CROSSINGS_SIZE = 32768;

	public static final int NUM_ALPHA_ROWS = 8;

	public Renderer(Object imageData, int width, int height, int imageOffset, int imageScanlineStride, int imagePixelStride, int imageType) {
	}

	public void dispose() {
	}

	public void setAntialiasing(int subpixelLgPositionsX, int subpixelLgPositionsY) {
	}

	public int getSubpixelLgPositionsX() {
	}

	public int getSubpixelLgPositionsY() {
	}

	public void setColor(int red, int green, int blue, int alpha) {
	}

	public void setPaint(Paint paint) {
	}

	public void getBoundingBox(double[] bbox) {
	}

	public void beginRendering(double boundsX, double boundsY, double boundsWidth, double boundsHeight, int windingRule) {
	}

	public void moveTo(double x0, double y0) {
	}

	public void lineTo(double x1, double y1) {
	}

	public void clearRect(double x, double y, double w, double h) {
	}

	public void close() {
	}

	public void endRendering() {
	}

	public void setCache(PiscesCache cache) {
	}

	public void renderFromCache(PiscesCache cache) {
	}

	public Renderer clone() {
	}
}
