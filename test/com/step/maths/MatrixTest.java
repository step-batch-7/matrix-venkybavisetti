package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void calculateMatrixDeterminantOf2_2Matrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    Matrix mFirst = new Matrix(first, 2, 2);

    assertEquals(0, mFirst.determinant());
  }

  @Test
  public void calculateMatrixDeterminantOf3_3Matrix() {
    int[][] third = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 8 } };
    Matrix mThird = new Matrix(third, 3, 3);

    assertEquals(3, mThird.determinant());
  }

  @Test
  public void checkEqualMethodForSameMatrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mFirst1 = new Matrix(first, 2, 2);

    assertTrue(mFirst.equals(mFirst1));
  }

  @Test
  public void checkEqualMethodForDifferentMatrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mSecond = new Matrix(second, 2, 2);

    assertFalse(mFirst.equals(mSecond));
  }

  @Test
  public void checkToStringMethod() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    Matrix mFirst = new Matrix(first, 2, 2);

    String string = "-----------\n1  2  \n1  2  \n-----------\n";
    assertEquals(string, mFirst.toString());
  }

  @Test
  public void calculateAdditionFor2_2And2_2Matrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };
    int[][] expectedArray = { { 3, 5 }, { 4, 4 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mSecond = new Matrix(second, 2, 2);
    Matrix expected = new Matrix(expectedArray, 2, 2);

    assertEquals(expected, mFirst.add(mSecond));
  }

  @Test
  public void calculateAdditionFor3_3And3_3Matrix() {
    int[][] first = { { 1, 2, 4 }, { 1, 2, 3 }, { 2, 5, 7 } };
    int[][] second = { { 2, 3, 3 }, { 3, 4, 2 }, { 4, 2, 5 } };
    int[][] expectedArray = { { 3, 5, 7 }, { 4, 6, 5 }, { 6, 7, 12 } };

    Matrix mFirst = new Matrix(first, 3, 3);
    Matrix mSecond = new Matrix(second, 3, 3);
    Matrix expected = new Matrix(expectedArray, 3, 3);

    assertEquals(expected, mFirst.add(mSecond));
  }

  @Test
  public void calculateSubtractionFor2_2And2_2Matrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };
    int[][] expectedArray = { { -1, -1 }, { -2, 0 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mSecond = new Matrix(second, 2, 2);
    Matrix expected = new Matrix(expectedArray, 2, 2);

    assertEquals(expected, mFirst.sub(mSecond));
  }

  @Test
  public void calculateSubtractionFor3_3And3_3Matrix() {
    int[][] first = { { 1, 2, 5 }, { 1, 2, 4 }, { 2, 4, 6 } };
    int[][] second = { { 2, 3, 5 }, { 3, 2, 3 }, { 3, 5, 2 } };
    int[][] expectedArray = { { -1, -1, 0 }, { -2, 0, 1 }, { -1, -1, 4 } };

    Matrix mFirst = new Matrix(first, 3, 3);
    Matrix mSecond = new Matrix(second, 3, 3);
    Matrix expected = new Matrix(expectedArray, 3, 3);

    assertEquals(expected, mFirst.sub(mSecond));
  }

  @Test
  public void calculateMultiplicationFor2_2And2_2Matrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };
    int[][] expectedArray = { { 8, 7 }, { 8, 7 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mSecond = new Matrix(second, 2, 2);
    Matrix expected = new Matrix(expectedArray, 2, 2);

    assertEquals(expected, mFirst.mul(mSecond));
  }

  @Test
  public void calculateMultiplicationFor3_2And2_3Matrix() {
    int[][] first = { { 2, 3 }, { 3, 2 }, { 2, 3 } };
    int[][] second = { { 2, 1, 4 }, { 5, 2, 2 } };
    int[][] expectedArray = { { 19, 8, 14 }, { 16, 7, 16 }, { 19, 8, 14 } };

    Matrix mThird = new Matrix(first, 3, 2);
    Matrix mFourth = new Matrix(second, 2, 3);
    Matrix expected = new Matrix(expectedArray, 3, 3);

    assertEquals(expected, mThird.mul(mFourth));
  }
}
