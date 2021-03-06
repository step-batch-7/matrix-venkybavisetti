package com.step.maths;

import java.util.Arrays;

public class Matrix {
  private int rows;
  private int columns;
  private int[][] array;

  public Matrix(int[][] array, int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.array = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      this.array[i] = Arrays.copyOf(array[i], columns);
    }
  }

  public Matrix mul(Matrix secondMatrix) {
    int[][] matrix = new int[this.rows][(secondMatrix.array)[0].length];

    for (int row = 0; row < this.rows; row++) {
      for (int column = 0; column < secondMatrix.array[0].length; column++) {
        matrix[row][column] = 0;
        for (int position = 0; position < this.columns; position++) {
          matrix[row][column] +=
            this.array[row][position] * (secondMatrix.array)[position][column];
        }
      }
    }

    return new Matrix(matrix, matrix.length, matrix[0].length);
  }

  public Matrix add(Matrix secondMatrix) {
    int[][] matrix = new int[this.rows][this.columns];

    for (int row = 0; row < this.rows; row++) {
      for (int column = 0; column < this.columns; column++) {
        matrix[row][column] =
          this.array[row][column] + secondMatrix.array[row][column];
      }
    }

    return new Matrix(matrix, matrix.length, matrix[0].length);
  }

  public Matrix sub(Matrix secondMatrix) {
    int[][] matrix = new int[this.rows][this.columns];

    for (int row = 0; row < this.rows; row++) {
      for (int column = 0; column < this.columns; column++) {
        matrix[row][column] =
          this.array[row][column] - secondMatrix.array[row][column];
      }
    }
    return new Matrix(matrix, matrix.length, matrix[0].length);
  }

  private static int[][] createSubMatrix(int[][] matrix, int parentColumn) {
    int length = matrix.length;
    int[][] subMatrix = new int[length - 1][length - 1];

    for (int row = 1; row < length; row++) {
      for (int column = 0; column < length; column++) {
        int subColumn = column > parentColumn ? column - 1 : column;
        int subRow = row - 1;
        if (column != parentColumn) {
          subMatrix[subRow][subColumn] = matrix[row][column];
        }
      }
    }

    return subMatrix;
  }

  private int findDet(int[][] matrix) {
    if (matrix.length == 2) {
      return ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
    }
    int det = 0;

    for (int column = 0; column < matrix.length; column++) {
      int[][] subMatrix = createSubMatrix(matrix, column);

      int sign = (int) Math.pow(-1, column);
      int detOfSubMatrix = sign * matrix[0][column] * findDet(subMatrix);

      det += detOfSubMatrix;
    }

    return (det);
  }

  public int determinant() {
    return findDet(this.array);
  }

  @Override
  public boolean equals(Object expectedArr) {
    if (!(expectedArr instanceof Matrix)) return false;
    int[][] expArr = ((Matrix) expectedArr).array;

    return Arrays.deepEquals(expArr, this.array);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("-----------\n");
    for (int[] row : this.array) {
      for (int number : row) {
        builder.append(number).append("  ");
      }
      builder.append("\n");
    }
    builder.append("-----------\n");
    return builder.toString();
  }
}
