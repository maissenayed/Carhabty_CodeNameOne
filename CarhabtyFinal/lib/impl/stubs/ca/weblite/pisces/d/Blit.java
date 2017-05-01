package ca.weblite.pisces.d;


/**
 *  Blit blender used by {@link Renderer}.
 */
public class Blit {

	public static final int COMPOSITE_SRC_OVER = 1;

	public Blit() {
	}

	/**
	 *  Coordinates in nominal integer format and coordinate space
	 */
	public static void clearRect(Object imageData, int imageType, int imageOffset, int imageScanlineStride, int imagePixelStride, int x, int y, int width, int height, int alpha, int red, int green, int blue) {
	}

	/**
	 *  (x0, y1, x1, y1) are in supersampled coordinate space
	 * 
	 *  (x0, y1, x1, y1) are >= 0
	 *  (x0, x1) are < width*SUBPIXEL_POSITIONS_X,
	 *  (y0, y1) are < height*SUBPIXEL_POSITIONS_Y
	 */
	public static void fillRectSrcOver(Renderer rdr, Object imageData, int imageType, int imageOffset, int imageScanlineStride, int imagePixelStride, int width, int height, int x0, int y0, int x1, int y1, int red, int green, int blue) {
	}

	public static void blit(Object imageData, int imageType, int imageOffset, int imageScanlineStride, int imagePixelStride, byte[] alphaData, int alphaOffset, int width, int height, int[] minTouched, int[] maxTouched, int[] rowOffsets, int compositeRule, int red, int green, int blue, int alpha, int[] alphaMap) {
	}

	public static void blit(Object imageData, int imageType, int imageOffset, int imageScanlineStride, int imagePixelStride, byte[] alphaData, int alphaOffset, int width, int height, int[] minTouched, int[] maxTouched, int[] rowOffsets, int compositeRule, int[] paintData, int paintOffset, int paintScanlineStride, int[] alphaMap) {
	}
}
