package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void calculateMatrixDeterminant() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] third = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 8 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mThird = new Matrix(third, 3, 3);

    assertEquals("Determinant of 2*2 matrix", 0, mFirst.determinant());
    assertEquals("Determinant of 3*3 matrix", 3, mThird.determinant());
  }

  @Test
  public void checkEqualMethod() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mFirst1 = new Matrix(first, 2, 2);
    Matrix mSecond = new Matrix(second, 2, 2);

    assertTrue("should be equal when equal matrix", mFirst.equals(mFirst1));
    assertFalse(
      "should not be equal when different matrix",
      mFirst.equals(mSecond)
    );
  }

  @Test
  public void checkToStringMethod() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    Matrix mFirst = new Matrix(first, 2, 2);

    String string = "-----------\n1  2  \n1  2  \n-----------\n";
    assertEquals("should be equal to the expected", string, mFirst.toString());
  }

  @Test
  public void additionOfTwoMatrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };
    int[][] expectedArray = { { 3, 5 }, { 4, 4 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mSecond = new Matrix(second, 2, 2);
    Matrix expected = new Matrix(expectedArray, 2, 2);

    assertEquals(
      "should be equal to expected matrix (2*2 matrix)",
      expected,
      mFirst.add(mSecond)
    );
  }

  @Test
  public void subtractionOfTwoMatrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };
    int[][] expectedArray = { { -1, -1 }, { -2, 0 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mSecond = new Matrix(second, 2, 2);
    Matrix expected = new Matrix(expectedArray, 2, 2);

    assertEquals(
      "should be equal to expected matrix (2*2 matrix)",
      expected,
      mFirst.sub(mSecond)
    );
  }

  @Test
  public void multiplicationOfTwoMatrix() {
    int[][] first = { { 1, 2 }, { 1, 2 } };
    int[][] second = { { 2, 3 }, { 3, 2 } };
    int[][] third = { { 2, 3, 4 }, { 3, 2, 2 }, { 2, 3, 3 } };
    int[][] four = { { 2, 1, 4 }, { 5, 2, 2 }, { 3, 6, 2 } };
    int[][] expectedArray1 = { { 8, 7 }, { 8, 7 } };
    int[][] expectedArray2 = { { 31, 32, 22 }, { 22, 19, 20 }, { 28, 26, 20 } };

    Matrix mFirst = new Matrix(first, 2, 2);
    Matrix mSecond = new Matrix(second, 2, 2);
    Matrix mThird = new Matrix(third, 3, 3);
    Matrix mFourth = new Matrix(four, 3, 3);
    Matrix expected1 = new Matrix(expectedArray1, 2, 2);
    Matrix expected2 = new Matrix(expectedArray2, 3, 3);

    assertEquals(
      "should be equal to expected matrix (2*2 matrix)",
      expected1,
      mFirst.mul(mSecond)
    );

    assertEquals(
      "should be equal to expected matrix (3*3 and 3*3 matrix)",
      expected2,
      mThird.mul(mFourth)
    );
  }
}
