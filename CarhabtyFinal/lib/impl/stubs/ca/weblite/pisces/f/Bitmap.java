package ca.weblite.pisces.f;


/**
 *  Row ordered and padded bitmap.
 *  
 *  Example: width 12
 * 
 *     Row order pixel offsets with padding
 *  <pre>
 *     +---+---+---+---+---+---+---+---++---+---+---+---+---+---+---+---+
 *     | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 || 8 | 9 | 10| 11| p | p | p | p |
 *     +---+---+---+---+---+---+---+---++---+---+---+---+---+---+---+---+
 *  </pre>
 * 
 *     Row shift keys
 *  <pre>
 *     +---+---+---+---+---+---+---+---++---+---+---+---+---+---+---+---+
 *     | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 || 7 | 6 | 5 | 4 | p | p | p | p |
 *     +---+---+---+---+---+---+---+---++---+---+---+---+---+---+---+---+
 *  </pre>
 */
public class Bitmap implements ca.weblite.pisces.Font.Glyph, ca.weblite.pisces.d.Surface {

	protected byte[] bits;

	protected char id;

	protected int width;

	protected int height;

	protected int stride;

	protected int pad;

	protected int fill;

	protected Bitmap() {
	}

	public char getId() {
	}

	public int getWidth() {
	}

	public int getHeight() {
	}

	public ca.weblite.pisces.Font.Glyph blit(ca.weblite.pisces.Graphics g, int x, int y, float op) {
	}

	public ca.weblite.pisces.Font.Glyph draw(ca.weblite.pisces.Graphics g, int x, int y, float op) {
	}

	public void getRGB(int[] dstRGB, int dstOffset, int dstScanLength, int x, int y, int width, int height) {
	}

	public void setRGB(int[] argb, int offset, int scanLength, int x, int y, int width, int height) {
	}

	/**
	 *  @param ofs Bitmap offset index
	 *  @return Bitmap pixel value
	 */
	public boolean bit(int ofs) {
	}

	/**
	 *  Subclass method to fill bitmap bytes
	 */
	protected void read(java.io.InputStream in, int many) {
	}

	/**
	 *  Subclass method to define bitmap properties
	 */
	protected void init(int width, int height) {
	}

	public ca.weblite.pisces.Font.Glyph draw(ca.weblite.pisces.d.PathSink sink, int x, int y, float op) {
	}
}
