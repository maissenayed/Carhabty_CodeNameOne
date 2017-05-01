package ca.weblite.pisces.f;


/**
 *  Pisces path font
 */
public class Path {

	public static final int PLAIN = 0;

	public static final int BOLD = 1;

	public static final int ITALIC = 2;

	public Path(String name, int style, double size) {
	}

	public String getName() {
	}

	public int getStyle() {
	}

	public double getSize() {
	}

	public void getBounds(String s, double[] bounds) {
	}

	public void produce(ca.weblite.pisces.d.PathSink consumer, String s, double x, double y) {
	}

	public static class Face {


		public Path.Face(java.io.InputStream in) {
		}
	}
}
