package ca.weblite.pisces;


/**
 *  
 *  
 *  @see Graphics
 */
public class Color implements Cloneable {

	public static final Color White;

	public static final Color LightGray;

	public static final Color Gray;

	public static final Color DarkGray;

	public static final Color Black;

	public static final Color Red;

	public static final Color Pink;

	public static final Color Orange;

	public static final Color Yellow;

	public static final Color Green;

	public static final Color Magenta;

	public static final Color Cyan;

	public static final Color Blue;

	public final int alpha;

	public final int red;

	public final int green;

	public final int blue;

	public final int argb;

	public Color(int argb) {
	}

	public Color(int r, int g, int b) {
	}

	public Color(int a, int r, int g, int b) {
	}

	public Color clone() {
	}

	public int hashCode() {
	}

	public boolean equals(Object that) {
	}

	public String toString() {
	}

	public static class Transparent {


		public static final Color.Transparent White;

		public static final Color.Transparent LightGray;

		public static final Color.Transparent Gray;

		public static final Color.Transparent DarkGray;

		public static final Color.Transparent Black;

		public static final Color.Transparent Red;

		public static final Color.Transparent Pink;

		public static final Color.Transparent Orange;

		public static final Color.Transparent Yellow;

		public static final Color.Transparent Green;

		public static final Color.Transparent Magenta;

		public static final Color.Transparent Cyan;

		public static final Color.Transparent Blue;

		public Color.Transparent(int r, int g, int b) {
		}
	}
}
