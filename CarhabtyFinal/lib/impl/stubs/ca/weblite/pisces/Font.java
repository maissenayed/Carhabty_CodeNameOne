package ca.weblite.pisces;


/**
 *  Vector fonts must be drawn, and will throw an
 *  UnsupportedOperationException on blitting.
 *  
 *  Bitmap fonts must be blitted, and will throw an
 *  UnsupportedOperationException on drawing.
 *  
 *  @see ca.weblite.pisces.f.Psf2
 */
public class Font implements Iterable {

	public Font(String name, Font.Glyph.Collection collection) {
	}

	/**
	 *  @param name Font file name, for example "sun12x22.psfu".
	 */
	public Font(String name) {
	}

	/**
	 *  Adds a font provider that can be used to load fonts.
	 *  @param provider 
	 */
	public static void addProvider(Font.FontProvider provider) {
	}

	/**
	 *  Removes a font provider.
	 *  @param provider 
	 */
	public static void removeProvider(Font.FontProvider provider) {
	}

	/**
	 *  Gets a font with the specified name and size.
	 *  @param name The name of the font to load.
	 *  @param size The size (in pixels).
	 *  @return The font or null if it could not be found.
	 */
	public static Font getFont(String name, float size) {
	}

	public int getAscent() {
	}

	public int getDescent() {
	}

	public void setAscent(int ascent) {
	}

	public void setDescent(int descent) {
	}

	public Font deriveFont(float size) {
	}

	public Font.Kind getKind() {
	}

	public Font.Glyph getGlyph(char id) {
	}

	/**
	 *  Bitmap font
	 */
	public Font blit(Graphics g, String string, int x, int y, float op) {
	}

	public Font draw(d.PathSink sink, String string, int x, int y, float op) {
	}

	/**
	 *  Vector font
	 */
	public Font draw(Graphics g, String string, int x, int y, float op) {
	}

	public int getMaxWidth() {
	}

	public int getMaxHeight() {
	}

	public java.util.Iterator iterator() {
	}

	/**
	 *  Vector or Bitmap
	 */
	public static final class Kind {


		public static final Font.Kind Draw;

		public static final Font.Kind Blit;

		public static Font.Kind[] values() {
		}

		public static Font.Kind valueOf(String name) {
		}
	}

	/**
	 *  Interface that can be implemented by any class that wishes to provide
	 *  fonts to Pisces.  
	 */
	public static interface class FontProvider {


		/**
		 *  Returns the specified font in the given size.
		 *  @param name The name of the font.
		 *  @param size The size of the font (in pixels);
		 *  @return 
		 */
		public Font getFont(String name, float size) {
		}
	}

	/**
	 *  
	 */
	public static interface class Glyph {


		public char getId() {
		}

		public int getWidth() {
		}

		public int getHeight() {
		}

		/**
		 *  Blit the glyph in its ideal box as defined for all glyphs
		 *  in the collection.  The argument coordinates locate the
		 *  glyph box at its top left location.  
		 *  
		 *  Glyph coordinates are not relative to a font baseline.
		 *  
		 *  Bitmap fonts are typically blitted.  
		 *  
		 *  Vector fonts will throw an UnsupportedOperationException on
		 *  blitting.
		 *  
		 *  In future the rendering engine may expose methods to draw a
		 *  bitmap font with transformations and antialiasing.
		 */
		public Font.Glyph blit(Graphics g, int x, int y, float op) {
		}

		/**
		 *  Draw the glyph.
		 *  
		 *  Stroke or vector fonts must be drawn.  
		 *  
		 *  Bitmap fonts may throw an UnsupportedOperationException on
		 *  drawing.
		 */
		public Font.Glyph draw(Graphics g, int x, int y, float op) {
		}

		public Font.Glyph draw(d.PathSink sink, int x, int y, float op) {
		}

		/**
		 *  The implementor defines a public constructor for no
		 *  arguments.  An instance is created with this constructor,
		 *  and then initialized via the read method.
		 */
		public static interface class Collection {


			public Font.Kind getKind() {
			}

			public Font.Glyph getGlyph(char id) {
			}

			public int getMaxWidth() {
			}

			public int getMaxHeight() {
			}

			public void read(java.io.InputStream in) {
			}
		}
	}

	/**
	 *  Map from font (file) name extension to implementation class.
	 */
	public static final class Type {


		public static final Font.Type PSFU;

		public final Class jclass;

		public static Font.Type[] values() {
		}

		public static Font.Type valueOf(String name) {
		}

		public Font.Glyph.Collection newInstance() {
		}

		public static final Font.Type Of(String name) {
		}

		public static final Font.Glyph.Collection Create(String name) {
		}
	}
}
