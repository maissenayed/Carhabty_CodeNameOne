package ca.weblite.pisces.d;


public interface Surface {

	/**
	 *  Constant indicating 8/8/8 RGB pixel data stored in an
	 *  <code>int</code> array.
	 */
	public static final int TYPE_INT_RGB = 1;

	/**
	 *  Constant indicating 8/8/8/8 ARGB pixel data stored in an
	 *  <code>int</code> array.
	 */
	public static final int TYPE_INT_ARGB = 2;

	/**
	 *  Constant indicating 8/8/8/8 ARGB alpha-premultiplied pixel data stored 
	 *  in a <code>int</code> array.
	 */
	public static final int TYPE_INT_ARGB_PRE = 3;

	/**
	 *  Constant indicating 5/6/5 RGB pixel data stored in an
	 *  <code>short</code> array.
	 */
	public static final int TYPE_USHORT_565_RGB = 8;

	/**
	 *  Constant indicating 8 bit grayscale pixel data stored in a
	 *  <code>byte</code> array.
	 */
	public static final int TYPE_BYTE_GRAY = 10;

	public int getWidth();

	public int getHeight();

	public void getRGB(int[] argb, int offset, int scanLength, int x, int y, int width, int height);

	public void setRGB(int[] argb, int offset, int scanLength, int x, int y, int width, int height);
}
