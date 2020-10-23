package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MatrixTest {
  private Matrix mFirst;
  private Matrix mSecond;
  private Matrix mThird;
  private Matrix mFourth;

  @Before
  public void setup() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };
    int[][] third = { { 1, 2, 5 }, { 1, 2, 4 }, { 2, 4, 6 } };
    int[][] fourth = { { 2, 3, 3 }, { 3, 4, 2 }, { 4, 2, 5 } };

    this.mFirst = new Matrix(first, 2, 2);
    this.mSecond = new Matrix(second, 2, 2);
    this.mThird = new Matrix(third, 3, 3);
    this.mFourth = new Matrix(fourth, 3, 3);
  }

  // @Ignore("tests count decreases")

  @Test
  public void calculateMatrixDeterminantOf2_2Matrix() {
    assertEquals(0, this.mFirst.determinant());
  }

  @Test
  public void calculateMatrixDeterminantOf3_3Matrix() {
    assertEquals(0, this.mThird.determinant());
  }

  @Test
  public void checkEqualMethodForSameMatrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    Matrix mFirst1 = new Matrix(first, 2, 2);

    assertEquals(mFirst1, this.mFirst);
  }

  @Test
  public void checkEqualMethodForDifferentMatrix() {
    assertFalse(this.mFirst.equals(this.mSecond));
  }

  @Test
  public void checkToStringMethod() {
    String string = "-----------\n1  2  \n1  2  \n-----------\n";
    assertEquals(string, this.mFirst.toString());
  }

  @Test
  public void calculateAdditionFor2_2And2_2Matrix() {
    int[][] expectedArray = { { 3, 5 }, { 4, 4 } };
    Matrix expected = new Matrix(expectedArray, 2, 2);

    assertEquals(expected, this.mFirst.add(this.mSecond));
  }

  @Test
  public void calculateAdditionFor3_3And3_3Matrix() {
    int[][] expectedArray = { { 3, 5, 8 }, { 4, 6, 6 }, { 6, 6, 11 } };
    Matrix expected = new Matrix(expectedArray, 3, 3);

    assertEquals(expected, this.mThird.add(this.mFourth));
  }

  @Test
  public void calculateSubtractionFor2_2And2_2Matrix() {
    int[][] expectedArray = { { -1, -1 }, { -2, 0 } };
    Matrix expected = new Matrix(expectedArray, 2, 2);

    assertEquals(expected, this.mFirst.sub(this.mSecond));
  }

  @Test
  public void calculateSubtractionFor3_3And3_3Matrix() {
    int[][] expectedArray = { { -1, -1, 2 }, { -2, -2, 2 }, { -2, 2, 1 } };
    Matrix expected = new Matrix(expectedArray, 3, 3);

    assertEquals(expected, this.mThird.sub(this.mFourth));
  }

  @Test
  public void calculateMultiplicationFor2_2And2_2Matrix() {
    int[][] expectedArray = { { 8, 7 }, { 8, 7 } };
    Matrix expected = new Matrix(expectedArray, 2, 2);

    assertEquals(expected, this.mFirst.mul(this.mSecond));
  }

  @Test
  public void calculateMultiplicationFor3_2And2_3Matrix() {
    int[][] array1 = { { 2, 3 }, { 3, 2 }, { 2, 3 } };
    int[][] array2 = { { 2, 1, 4 }, { 5, 2, 2 } };
    int[][] expectedArray = { { 19, 8, 14 }, { 16, 7, 16 }, { 19, 8, 14 } };

    Matrix matrix32 = new Matrix(array1, 3, 2);
    Matrix matrix23 = new Matrix(array2, 2, 3);
    Matrix expected = new Matrix(expectedArray, 3, 3);

    assertEquals(expected, matrix32.mul(matrix23));
  }
}
