package ca.weblite.pisces.png;


/**
 *  PNG Encoder adapted to pisces graphics.
 * 
 *  @author J. David Eisenberg, david@catcode.com
 *  @version 1.5, 19 Oct 2003
 */
public class Encoder {

	/**
	 * Constant specifying that alpha channel should be encoded. 
	 */
	public static final boolean ENCODE_ALPHA = true;

	/**
	 * Constant specifying that alpha channel should not be encoded. 
	 */
	public static final boolean NO_ALPHA = false;

	/**
	 * Constants for filter (NONE) 
	 */
	public static final int FILTER_NONE = 0;

	/**
	 * Constants for filter (SUB) 
	 */
	public static final int FILTER_SUB = 1;

	/**
	 * Constants for filter (UP) 
	 */
	public static final int FILTER_UP = 2;

	/**
	 * Constants for filter (LAST) 
	 */
	public static final int FILTER_LAST = 2;

	/**
	 * IHDR tag. 
	 */
	protected static final byte[] IHDR;

	/**
	 * IDAT tag. 
	 */
	protected static final byte[] IDAT;

	/**
	 * IEND tag. 
	 */
	protected static final byte[] IEND;

	/**
	 * The png bytes. 
	 */
	protected byte[] pngBytes;

	/**
	 * The prior row. 
	 */
	protected byte[] priorRow;

	/**
	 * The left bytes. 
	 */
	protected byte[] leftBytes;

	/**
	 * The image. 
	 */
	protected ca.weblite.pisces.d.Surface surface;

	/**
	 * The width. 
	 */
	protected int width;

	/**
	 * The width. 
	 */
	protected int height;

	/**
	 * The byte position. 
	 */
	protected int bytePos;

	/**
	 * The byte position. 
	 */
	protected int maxPos;

	/**
	 * CRC. 
	 */
	protected com.codename1.io.gzip.CRC32 crc;

	/**
	 * The CRC value. 
	 */
	protected long crcValue;

	/**
	 * Encode alpha? 
	 */
	protected boolean encodeAlpha;

	/**
	 * The filter type. 
	 */
	protected int filter;

	/**
	 * The bytes-per-pixel. 
	 */
	protected int bytesPerPixel;

	/**
	 * The compression level. 
	 */
	protected int compressionLevel;

	public Encoder(ca.weblite.pisces.d.Surface surface) {
	}

	public Encoder(ca.weblite.pisces.d.Surface surface, boolean encodeAlpha) {
	}

	public Encoder(ca.weblite.pisces.d.Surface surface, boolean encodeAlpha, int whichFilter) {
	}

	public Encoder(ca.weblite.pisces.d.Surface surface, boolean encodeAlpha, int whichFilter, int compLevel) {
	}

	public byte[] encode() {
	}

	/**
	 *  @param encodeAlpha boolean false=no alpha, true=encode alpha
	 *  @return an array of bytes, or null if there was a problem
	 */
	public byte[] encode(boolean encodeAlpha) {
	}

	public void setEncodeAlpha(boolean encodeAlpha) {
	}

	public boolean getEncodeAlpha() {
	}

	public void setFilter(int whichFilter) {
	}

	public int getFilter() {
	}

	public void setCompressionLevel(int level) {
	}

	public int getCompressionLevel() {
	}

	/**
	 *  Write an array of bytes into the pngBytes array.
	 *  Note: This routine has the side effect of updating
	 *  maxPos, the largest element written in the array.
	 *  The array is resized by 1000 bytes or the length
	 *  of the data to be written, whichever is larger.
	 * 
	 *  @param data The data to be written into pngBytes.
	 *  @param offset The starting point to write to.
	 *  @return The next place to be written to in the pngBytes array.
	 */
	protected int writeBytes(byte[] data, int offset) {
	}

	/**
	 *  Write an array of bytes into the pngBytes array, specifying number of bytes to write.
	 *  Note: This routine has the side effect of updating
	 *  maxPos, the largest element written in the array.
	 *  The array is resized by 1000 bytes or the length
	 *  of the data to be written, whichever is larger.
	 * 
	 *  @param data The data to be written into pngBytes.
	 *  @param nBytes The number of bytes to be written.
	 *  @param offset The starting point to write to.
	 *  @return The next place to be written to in the pngBytes array.
	 */
	protected int writeBytes(byte[] data, int nBytes, int offset) {
	}

	/**
	 *  Write a two-byte integer into the pngBytes array at a given position.
	 * 
	 *  @param n The integer to be written into pngBytes.
	 *  @param offset The starting point to write to.
	 *  @return The next place to be written to in the pngBytes array.
	 */
	protected int writeInt2(int n, int offset) {
	}

	/**
	 *  Write a four-byte integer into the pngBytes array at a given position.
	 * 
	 *  @param n The integer to be written into pngBytes.
	 *  @param offset The starting point to write to.
	 *  @return The next place to be written to in the pngBytes array.
	 */
	protected int writeInt4(int n, int offset) {
	}

	/**
	 *  Write a single byte into the pngBytes array at a given position.
	 * 
	 *  @param b The integer to be written into pngBytes.
	 *  @param offset The starting point to write to.
	 *  @return The next place to be written to in the pngBytes array.
	 */
	protected int writeByte(int b, int offset) {
	}

	/**
	 *  Write a PNG "IHDR" chunk into the pngBytes array.
	 */
	protected void writeHeader() {
	}

	/**
	 *  Perform "sub" filtering on the given row.
	 *  Uses temporary array leftBytes to store the original values
	 *  of the previous pixels.  The array is 16 bytes long, which
	 *  will easily hold two-byte samples plus two-byte alpha.
	 * 
	 *  @param pixels The array holding the scan lines being built
	 *  @param startPos Starting position within pixels of bytes to be filtered.
	 *  @param width Width of a scanline in pixels.
	 */
	protected void filterSub(byte[] pixels, int startPos, int width) {
	}

	/**
	 *  Perform "up" filtering on the given row.
	 *  Side effect: refills the prior row with current row
	 * 
	 *  @param pixels The array holding the scan lines being built
	 *  @param startPos Starting position within pixels of bytes to be filtered.
	 *  @param width Width of a scanline in pixels.
	 */
	protected void filterUp(byte[] pixels, int startPos, int width) {
	}

	/**
	 *  Write the image data into the pngBytes array.
	 *  This will write one or more PNG "IDAT" chunks. In order
	 *  to conserve memory, this method grabs as many rows as will
	 *  fit into 32K bytes, or the whole image; whichever is less.
	 * 
	 * 
	 *  @return true if no errors; false if error grabbing pixels
	 */
	protected boolean writeImageData() {
	}

	/**
	 *  Write a PNG "IEND" chunk into the pngBytes array.
	 */
	protected void writeEnd() {
	}

	protected static byte[] Resize(byte[] array, int newLength) {
	}
}
