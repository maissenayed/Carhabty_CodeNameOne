package ca.weblite.pisces.f;


/**
 *  <p> This class contains static tools for doing UTF-8 encoding and
 *  decoding.</p>
 * 
 *  <p> UTF-8 is ASCII- transparent.  It supports character sets
 *  requiring more than the seven bit ASCII base range of UTF-8,
 *  including Unicode, ISO-8859, ISO-10646, etc..</p>
 *  
 *  <p> ISO UCS code signature is not implemented.  </p>
 * 
 *  @author John Pritchard (jdp@syntelos)
 *  @since 1.1
 */
public abstract class Utf8 {

	public Utf8() {
	}

	/**
	 *  Decode UTF-8 input, terminates decoding at a null character,
	 *  value 0x0.
	 *  
	 *  @exception alto.sys.Error.State Bad format.
	 */
	public static final char[] decode(byte[] code) {
	}

	/**
	 *  Decode UTF-8 input, terminates decoding at a null character,
	 *  value 0x0.
	 *  
	 *  @exception alto.sys.Error.State Bad format.
	 */
	public static final char[] decode(byte[] code, int off, int many) {
	}

	/**
	 *  Encode string in UTF-8.
	 */
	public static final byte[] encode(char[] str) {
	}

	/**
	 *  Encode string in UTF-8.
	 */
	public static final byte[] encode(String s) {
	}

	/**
	 *  Returns the length of the string encoded in UTF-8.
	 */
	public static final int encoded(String s) {
	}

	/**
	 *  Returns the length of the string encoded in UTF-8.
	 */
	public static final int encoded(char[] str) {
	}
}
