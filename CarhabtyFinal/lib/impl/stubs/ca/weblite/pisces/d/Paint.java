package ca.weblite.pisces.d;


/**
 *  Rendering plugin works on fixed point (S15.16) coordinate values.
 *  
 *  @see Renderer
 */
public abstract class Paint extends FXMath {

	protected ca.weblite.pisces.m.Matrix transform;

	protected ca.weblite.pisces.m.Matrix inverse;

	public Paint(ca.weblite.pisces.m.Matrix transform) {
	}

	public void setTransform(ca.weblite.pisces.m.Matrix transform) {
	}

	public void setQuality(int quality) {
	}

	/**
	 *  Fixed point S15.16 coordinate values
	 */
	public abstract void paint(int x, int y, int width, int height, int[] minTouched, int[] maxTouched, int[] dst, int dstOffset, int dstScanlineStride) {
	}
}
