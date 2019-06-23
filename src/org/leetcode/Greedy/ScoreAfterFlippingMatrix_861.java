package org.leetcode.Greedy;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.Test;

public class ScoreAfterFlippingMatrix_861 {


  public int matrixScore(int[][] A) {
    int score = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i][0] == 0) {
        flipRow(i, A);
      }
    }

    for (int c = 1; c < A[0].length; c++) {
      int[] col = getColumn(A, c);
      int onesCount = getOnesCount(col);
      if (onesCount <= Math.ceil(A.length / 2)) {
        flipColumn(c, A);
      }
    }

    for (int[] arr : A) {
      score += totalSum(arr);
    }

    return score;
  }

  private void flipColumn(int c, int[][] a) {
    for (int i = 0; i < a.length; i++) {
      a[i][c] = a[i][c] == 0 ? 1 : 0;
    }
  }

  private int getOnesCount(int[] col) {
    int count = 0;
    for (int i = 0; i < col.length; i++) {
      if (col[i] == 1) {
        count++;
      }
    }
    return count;
  }

  private void flipRow(int i, int[][] a) {
    for (int k = 0; k < a[0].length; k++) {
      a[i][k] = a[i][k] == 0 ? 1 : 0;
    }
  }


  int[] getColumn(int[][] matrix, int column) {
    return IntStream.range(0, matrix.length)
        .map(i -> matrix[i][column]).toArray();
  }

  int totalSum(int[] arr) {
    String str = Arrays.toString(arr);
    str = str
        .replace(",", "")  //remove the commas
        .replace("[", "")  //remove the right bracket
        .replace("]", "")  //remove the left bracket
        .trim().replace(" ", "");

    return Integer.parseInt(str, 2);
  }


  @Test
  public void test1() {
    System.out.println(matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
  }

  @Test
  public void test2() {
    System.out.println(matrixScore(new int[][]{{0}}));
  }
}
