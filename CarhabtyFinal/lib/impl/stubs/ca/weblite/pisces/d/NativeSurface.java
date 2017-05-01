package ca.weblite.pisces.d;


/**
 *  An INT ARGB {@link Surface$Sink}.
 */
public class NativeSurface implements Surface.Sink.Int {

	public NativeSurface(int width, int height) {
	}

	public NativeSurface(int[] data, int width, int height) {
	}

	/**
	 *  @see Surface
	 */
	public final int getWidth() {
	}

	/**
	 *  @see Surface
	 */
	public final int getHeight() {
	}

	/**
	 *  @see Surface$Sink
	 */
	public int getDataType() {
	}

	/**
	 *  @see Surface$Sink
	 */
	public int[] getData() {
	}

	/**
	 *  @see Surface
	 */
	public final void getRGB(int[] argb, int offset, int scanLength, int x, int y, int width, int height) {
	}

	/**
	 *  @see Surface
	 */
	public final void setRGB(int[] argb, int offset, int scanLength, int x, int y, int width, int height) {
	}

	/**
	 *  @see Surface$Sink
	 */
	public void blit(Surface ps, int srcX, int srcY, int dstX, int dstY, int width, int height, float opacity) {
	}

	/**
	 *  @see Surface$Sink
	 */
	public void blit(int[] argb, int offset, int scanLength, int x, int y, int width, int height, float opacity) {
	}
}
