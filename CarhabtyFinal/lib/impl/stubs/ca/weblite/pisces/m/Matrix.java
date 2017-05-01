package ca.weblite.pisces.m;


/**
 *  A double precision floating point 3 by 3 matrix in row major notation.
 */
public class Matrix extends ca.weblite.pisces.d.FPMath implements Cloneable {

	public double m00;

	public double m01;

	public double m02;

	public double m10;

	public double m11;

	public double m12;

	public double m20;

	public double m21;

	public double m22;

	public Matrix(double m00, double m01, double m10, double m11, double m20, double m21) {
	}

	public Matrix(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
	}

	public Matrix(double[] v) {
	}

	public Matrix(Matrix m1) {
	}

	public Matrix() {
	}

	public static final Matrix getRotateInstance(double theta) {
	}

	public static final Matrix getRotateInstance(double theta, double anchorx, double anchory) {
	}

	public static final Matrix getRotateInstance(double vecx, double vecy) {
	}

	public static final Matrix getRotateInstance(double vecx, double vecy, double anchorx, double anchory) {
	}

	public static final Matrix getScaleInstance(double sx, double sy) {
	}

	public static final Matrix getShearInstance(double shx, double shy) {
	}

	public static final Matrix getTranslateInstance(double tx, double ty) {
	}

	/**
	 *  Sets this Matrix to identity.
	 */
	public final Matrix setIdentity() {
	}

	/**
	 *  Sets the scale component of the current matrix by factoring
	 *  out the current scale (by doing an SVD) and multiplying by
	 *  the new scale.
	 *  @param scale  the new scale amount
	 */
	public final Matrix setScale(double scale) {
	}

	/**
	 *  Sets the specified element of this matrix3f to the value provided.
	 *  @param row the row number to be modified (zero indexed)
	 *  @param column the column number to be modified (zero indexed)
	 *  @param value the new value
	 */
	public final Matrix setElement(int row, int column, double value) {
	}

	/**
	 *  Retrieves the value at the specified row and column of the specified
	 *  matrix.
	 *  @param row the row number to be retrieved (zero indexed)
	 *  @param column the column number to be retrieved (zero indexed)
	 *  @return the value at the indexed element.
	 */
	public final double getElement(int row, int column) {
	}

	/**
	 *  Copies the matrix values in the specified row into the vector parameter.
	 *  @param row  the matrix row
	 *  @param v    the vector into which the matrix row values will be copied
	 */
	public final Vector getRow(int row, Vector v) {
	}

	/**
	 *  Copies the matrix values in the specified row into the array parameter.
	 *  @param row  the matrix row
	 *  @param v    the array into which the matrix row values will be copied
	 */
	public final double[] getRow(int row, double[] v) {
	}

	/**
	 *  Copies the matrix values in the specified column into the vector
	 *  parameter.
	 *  @param column  the matrix column
	 *  @param v    the vector into which the matrix row values will be copied
	 */
	public final Vector getColumn(int column, Vector v) {
	}

	/**
	 *  Copies the matrix values in the specified column into the array
	 *  parameter.
	 *  @param column  the matrix column
	 *  @param v    the array into which the matrix row values will be copied
	 */
	public final double[] getColumn(int column, double[] v) {
	}

	/**
	 *  Sets the specified row of this matrix to the 4 values provided.
	 *  @param row the row number to be modified (zero indexed)
	 *  @param x the first column element
	 *  @param y the second column element
	 *  @param z the third column element
	 */
	public final Matrix setRow(int row, double x, double y, double z) {
	}

	/**
	 *  Sets the specified row of this matrix to the Vector provided.
	 *  @param row the row number to be modified (zero indexed)
	 *  @param v the replacement row
	 */
	public final Matrix setRow(int row, Vector v) {
	}

	/**
	 *  Sets the specified row of this matrix to the three values provided.
	 *  @param row the row number to be modified (zero indexed)
	 *  @param v the replacement row
	 */
	public final Matrix setRow(int row, double[] v) {
	}

	/**
	 *  Sets the specified column of this matrix to the three values provided.
	 *  @param column the column number to be modified (zero indexed)
	 *  @param x the first row element
	 *  @param y the second row element
	 *  @param z the third row element
	 */
	public final Matrix setColumn(int column, double x, double y, double z) {
	}

	/**
	 *  Sets the specified column of this matrix to the vector provided.
	 *  @param column the column number to be modified (zero indexed)
	 *  @param v the replacement column
	 */
	public final Matrix setColumn(int column, Vector v) {
	}

	/**
	 *  Sets the specified column of this matrix to the three values provided.
	 *  @param column the column number to be modified (zero indexed)
	 *  @param v the replacement column
	 */
	public final Matrix setColumn(int column, double[] v) {
	}

	/**
	 *  Performs an SVD normalization of this matrix to calculate
	 *  and return the uniform scale factor. If the matrix has non-uniform
	 *  scale factors, the largest of the x, y, and z scale factors will
	 *  be returned. This matrix is not modified.
	 *  @return  the scale factor of this matrix
	 */
	public final double getScale() {
	}

	/**
	 *   Adds a scalar to each component of this matrix.
	 *   @param scalar  the scalar adder
	 */
	public final Matrix add(double scalar) {
	}

	/**
	 *   Adds a scalar to each component of the matrix m1 and places
	 *   the result into this.  Matrix m1 is not modified.
	 *   @param scalar  the scalar adder
	 *   @param m1  the original matrix values
	 */
	public final Matrix add(double scalar, Matrix m1) {
	}

	/**
	 *  Sets the value of this matrix to the matrix sum of matrices m1 and m2.
	 *  @param m1 the first matrix
	 *  @param m2 the second matrix
	 */
	public final Matrix add(Matrix m1, Matrix m2) {
	}

	/**
	 *  Sets the value of this matrix to the sum of itself and matrix m1.
	 *  @param m1 the other matrix
	 */
	public final Matrix add(Matrix m1) {
	}

	/**
	 *  Sets the value of this matrix to the matrix difference
	 *  of matrices m1 and m2.
	 *  @param m1 the first matrix
	 *  @param m2 the second matrix
	 */
	public final Matrix sub(Matrix m1, Matrix m2) {
	}

	/**
	 *  Sets the value of this matrix to the matrix difference of itself and
	 *  matrix m1 (this = this - m1).
	 *  @param m1 the other matrix
	 */
	public final Matrix sub(Matrix m1) {
	}

	/**
	 *  Sets the value of this matrix to its transpose.
	 */
	public final Matrix transpose() {
	}

	/**
	 *  Sets the value of this matrix to the transpose of the argument matrix.
	 *  @param m1 the matrix to be transposed
	 */
	public final Matrix transpose(Matrix m1) {
	}

	/**
	 *  Sets the value of this matrix to the matrix conversion of the
	 *  double precision quaternion argument.
	 *  @param q1 the quaternion to be converted
	 */
	public final Matrix set(Quat q1) {
	}

	/**
	 *  Sets the value of this matrix to the matrix conversion of the
	 *  double precision axis and angle argument.
	 *  @param a1 the axis and angle to be converted
	 */
	public final Matrix set(AxisAngle a1) {
	}

	/**
	 *  Sets the value of this matrix to the value of the Matrix
	 *  argument.
	 *  @param m1 the source matrix
	 */
	public final Matrix set(Matrix m1) {
	}

	/**
	 *   Sets the values in this Matrix equal to the row-major
	 *   array parameter (ie, the first three elements of the
	 *   array will be copied into the first row of this matrix, etc.).
	 *   @param m  the double precision array of length 9
	 */
	public final Matrix set(double[] m) {
	}

	/**
	 *  Sets the value of this matrix to the matrix inverse
	 *  of the passed matrix m1.
	 *  @param m1 the matrix to be inverted
	 */
	public final Matrix invert(Matrix m1) {
	}

	/**
	 *  Inverts this matrix in place.
	 */
	public final Matrix invert() {
	}

	/**
	 *  Computes the determinant of this matrix.
	 *  @return the determinant of the matrix
	 */
	public final double determinant() {
	}

	/**
	 *  Sets the value of this matrix to a scale matrix with
	 *  the passed scale amount.
	 *  @param scale the scale factor for the matrix
	 */
	public final Matrix set(double scale) {
	}

	/**
	 *  Sets the value of this matrix to a counter clockwise rotation
	 *  about the x axis.
	 *  @param angle the angle to rotate about the X axis in radians
	 */
	public final Matrix rotX(double angle) {
	}

	/**
	 *  Sets the value of this matrix to a counter clockwise rotation
	 *  about the y axis.
	 *  @param angle the angle to rotate about the Y axis in radians
	 */
	public final Matrix rotY(double angle) {
	}

	/**
	 *  Sets the value of this matrix to a counter clockwise rotation
	 *  about the z axis.
	 *  @param angle the angle to rotate about the Z axis in radians
	 */
	public final Matrix rotZ(double angle) {
	}

	/**
	 *  Multiplies each element of this matrix by a scalar.
	 *  @param scalar  The scalar multiplier.
	 */
	public final Matrix mul(double scalar) {
	}

	/**
	 *  Multiplies each element of matrix m1 by a scalar and places
	 *  the result into this.  Matrix m1 is not modified.
	 *  @param scalar  the scalar multiplier
	 *  @param m1  the original matrix
	 */
	public final Matrix mul(double scalar, Matrix m1) {
	}

	/**
	 *  Sets the value of this matrix to the result of multiplying itself
	 *  with matrix m1.
	 *  @param m1 the other matrix
	 */
	public final Matrix mul(Matrix m1) {
	}

	/**
	 *  Sets the value of this matrix to the result of multiplying
	 *  the two argument matrices together.
	 *  @param m1 the first matrix
	 *  @param m2 the second matrix
	 */
	public final Matrix mul(Matrix m1, Matrix m2) {
	}

	/**
	 *   Multiplies this matrix by matrix m1, does an SVD normalization
	 *   of the result, and places the result back into this matrix
	 *   this = SVDnorm(this*m1).
	 *   @param  m1   the matrix on the right hand side of the multiplication
	 */
	public final Matrix mulNormalize(Matrix m1) {
	}

	/**
	 *   Multiplies matrix m1 by matrix m2, does an SVD normalization
	 *   of the result, and places the result into this matrix
	 *   this = SVDnorm(m1*m2).
	 *   @param  m1  the matrix on the left hand side of the multiplication
	 *   @param  m2  the matrix on the right hand side of the multiplication
	 */
	public final Matrix mulNormalize(Matrix m1, Matrix m2) {
	}

	/**
	 *   Multiplies the transpose of matrix m1 times the transpose of matrix
	 *   m2, and places the result into this.
	 *   @param m1  the matrix on the left hand side of the multiplication
	 *   @param m2  the matrix on the right hand side of the multiplication
	 */
	public final Matrix mulTransposeBoth(Matrix m1, Matrix m2) {
	}

	/**
	 *   Multiplies matrix m1 times the transpose of matrix m2, and
	 *   places the result into this.
	 *   @param m1  the matrix on the left hand side of the multiplication
	 *   @param m2  the matrix on the right hand side of the multiplication
	 */
	public final Matrix mulTransposeRight(Matrix m1, Matrix m2) {
	}

	/**
	 *   Multiplies the transpose of matrix m1 times matrix m2, and
	 *   places the result into this.
	 *   @param m1  the matrix on the left hand side of the multiplication
	 *   @param m2  the matrix on the right hand side of the multiplication
	 */
	public final Matrix mulTransposeLeft(Matrix m1, Matrix m2) {
	}

	/**
	 *  Performs singular value decomposition normalization of this matrix.
	 */
	public final Matrix normalize() {
	}

	/**
	 *  Perform singular value decomposition normalization of matrix m1 and
	 *  place the normalized values into this.
	 *  @param m1  Provides the matrix values to be normalized
	 */
	public final Matrix normalize(Matrix m1) {
	}

	/**
	 *  Perform cross product normalization of this matrix.
	 */
	public final Matrix normalizeCP() {
	}

	/**
	 *  Perform cross product normalization of matrix m1 and place the
	 *  normalized values into this.
	 *  @param m1  Provides the matrix values to be normalized
	 */
	public final Matrix normalizeCP(Matrix m1) {
	}

	/**
	 *  Returns true if all of the data members of Matrix m1 are
	 *  equal to the corresponding data members in this Matrix.
	 *  @param m1  the matrix with which the comparison is made
	 *  @return  true or false
	 */
	public boolean equals(Matrix m1) {
	}

	/**
	 *  Returns true if the Object t1 is of type Matrix and all of the
	 *  data members of t1 are equal to the corresponding data members in
	 *  this Matrix.
	 *  @param t1  the matrix with which the comparison is made
	 *  @return  true or false
	 */
	public boolean equals(Object t1) {
	}

	/**
	 *  Returns a hash code value based on the data values in this
	 *  object.  Two different Matrix objects with identical data values
	 *  (i.e., Matrix.equals returns true) will return the same hash
	 *  code value.  Two objects with different data members may return the
	 *  same hash value, although this is not likely.
	 *  @return the integer hash code value
	 */
	public int hashCode() {
	}

	/**
	 *   Sets this matrix to all zeros.
	 */
	public final Matrix setZero() {
	}

	/**
	 *  Negates the value of this matrix: this = -this.
	 */
	public final Matrix negate() {
	}

	/**
	 *   Sets the value of this matrix equal to the negation of
	 *   of the Matrix parameter.
	 *   @param m1  the source matrix
	 */
	public final Matrix negate(Matrix m1) {
	}

	/**
	 *  Multiply this matrix by the tuple t and place the result
	 *  back into the tuple (t = this*t).
	 *  @param t  the tuple to be multiplied by this matrix and then replaced
	 */
	public final Tuple transform(Tuple t) {
	}

	/**
	 *  Multiply this matrix by the tuple t and and place the result
	 *  into the tuple "result" (result = this*t).
	 *  @param t  the tuple to be multiplied by this matrix
	 *  @param result  the tuple into which the product is placed
	 */
	public final Tuple transform(Tuple t, Tuple result) {
	}

	public Matrix clone() {
	}

	public final double getM00() {
	}

	public final Matrix setM00(double m00) {
	}

	public final double getM01() {
	}

	public final Matrix setM01(double m01) {
	}

	public final double getM02() {
	}

	public final Matrix setM02(double m02) {
	}

	public final double getM10() {
	}

	public final Matrix setM10(double m10) {
	}

	public final double getM11() {
	}

	public final Matrix setM11(double m11) {
	}

	public final double getM12() {
	}

	public final Matrix setM12(double m12) {
	}

	public final double getM20() {
	}

	public final Matrix setM20(double m20) {
	}

	public final double getM21() {
	}

	public final Matrix setM21(double m21) {
	}

	public final double getM22() {
	}

	public final Matrix setM22(double m22) {
	}

	public boolean isIdentity() {
	}

	public String toString() {
	}

	public Matrix scale(double sx, double sy) {
	}

	public Matrix translate(double tx, double ty) {
	}
}
