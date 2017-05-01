package ca.weblite.pisces.f;


/**
 *  
 */
public abstract class Collection implements ca.weblite.pisces.Font.Glyph.Collection {

	public Collection() {
	}

	public ca.weblite.pisces.Font.Glyph getGlyph(char id) {
	}

	public int getMaxWidth() {
	}

	public int getMaxHeight() {
	}

	protected void add(ca.weblite.pisces.Font.Glyph glyph) {
	}

	public java.util.Iterator iterator() {
	}

	/**
	 *  Sparse list iterator
	 */
	public static class Iterator {


		public Collection.Iterator(ca.weblite.pisces.Font.Glyph[] set) {
		}

		public boolean hasNext() {
		}

		public ca.weblite.pisces.Font.Glyph next() {
		}

		public void remove() {
		}
	}
}
