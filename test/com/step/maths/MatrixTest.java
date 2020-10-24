package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MatrixTest {

  // @Ignore("tests count decreases")

  private Matrix matrix_2x2(int a, int b, int c, int d) {
    return new Matrix(new int[][] { { a, b }, { c, d } }, 2, 2);
  }

  private Matrix matrix_3x3(int... args) {
    int[][] array = new int[3][];
    for (int index = 0; index < 3; index++) {
      array[index] = new int[] { args[index], args[1], args[2] };
    }

    return new Matrix(array, 3, 3);
  }

  @Test
  public void determinant_shouldCalculateDeterminantFor_2x2_Matrix() {
    Matrix matrix = matrix_2x2(1, 2, 1, 2);
    assertEquals(0, matrix.determinant());
  }

  @Test
  public void determinant_shouldCalculateDeterminantFor_3x3_Matrix() {
    Matrix matrix = matrix_3x3(1, 2, 5, 1, 2, 4, 2, 4, 6);
    assertEquals(0, matrix.determinant());
  }

  @Test
  public void equal_shouldReturnTrueForSameMatrices() {
    Matrix matrix = matrix_2x2(1, 2, 1, 2);
    Matrix matrix1 = matrix_2x2(1, 2, 1, 2);

    assertEquals(matrix1, matrix);
  }

  @Test
  public void equal_shouldReturnFalseForDifferentMatrices() {
    Matrix firstMatrix = matrix_2x2(1, 2, 1, 2);
    Matrix secondMatrix = matrix_2x2(2, 3, 3, 2);
    assertNotEquals(secondMatrix, firstMatrix);
  }

  @Test
  public void toString_shouldGiveStringRepresentationOfMatrix() {
    Matrix matrix = matrix_2x2(1, 2, 1, 2);

    String string = "-----------\n1  2  \n1  2  \n-----------\n";
    assertEquals(string, matrix.toString());
  }

  @Test
  public void add_shouldCalculateAdditionFor_2x2_Matrices() {
    Matrix expected = matrix_2x2(3, 5, 4, 4);
    Matrix firstMatrix = matrix_2x2(1, 2, 1, 2);
    Matrix secondMatrix = matrix_2x2(2, 3, 3, 2);

    assertEquals(expected, firstMatrix.add(secondMatrix));
  }

  @Test
  public void add_shouldCalculateAdditionFor_3x3_Matrices() {
    Matrix firstMatrix = matrix_3x3(1, 2, 5, 1, 2, 4, 2, 4, 6);
    Matrix secondMatrix = matrix_3x3(2, 3, 3, 3, 4, 2, 4, 2, 5);
    Matrix expected = matrix_3x3(3, 5, 8, 5, 5, 8, 8, 5, 8);

    assertEquals(expected, firstMatrix.add(secondMatrix));
  }

  @Test
  public void sub_shouldCalculateSubtractionFor_2x2_Matrices() {
    Matrix firstMatrix = matrix_2x2(1, 2, 1, 2);
    Matrix secondMatrix = matrix_2x2(2, 3, 3, 2);
    Matrix expected = matrix_2x2(-1, -1, -2, 0);

    assertEquals(expected, firstMatrix.sub(secondMatrix));
  }

  @Test
  public void sub_shouldCalculateSubtractionFor_3x3_Matrices() {
    Matrix firstMatrix = matrix_3x3(1, 2, 5, 1, 2, 4, 2, 4, 6);
    Matrix secondMatrix = matrix_3x3(2, 3, 3, 3, 4, 2, 4, 2, 5);
    Matrix expected = matrix_3x3(-1, -1, 2, -2, -2, 2, -2, 2, 1);

    assertEquals(expected, firstMatrix.sub(secondMatrix));
  }

  @Test
  public void mul_shouldCalculateMultiplicationFor_2x2__2x2_Matrices() {
    Matrix firstMatrix = matrix_2x2(1, 2, 1, 2);
    Matrix secondMatrix = matrix_2x2(2, 3, 3, 2);
    Matrix expected = matrix_2x2(8, 7, 8, 7);

    assertEquals(expected, firstMatrix.mul(secondMatrix));
  }

  @Test
  public void mul_shouldCalculateMultiplicationFor_3x2__2x3_Matrices() {
    int[][] array1 = { { 2, 3 }, { 3, 2 }, { 2, 3 } };
    int[][] array2 = { { 2, 1, 4 }, { 5, 2, 2 } };
    int[][] expectedArray = { { 19, 8, 14 }, { 16, 7, 16 }, { 19, 8, 14 } };

    Matrix matrix32 = new Matrix(array1, 3, 2);
    Matrix matrix23 = new Matrix(array2, 2, 3);
    Matrix expected = new Matrix(expectedArray, 3, 3);

    assertEquals(expected, matrix32.mul(matrix23));
  }
}
