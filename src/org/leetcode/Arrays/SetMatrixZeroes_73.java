package org.leetcode.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class SetMatrixZeroes_73 {


  public void setZeroes(int[][] matrix) {

    Set<Integer> row = new HashSet<>();
    Set<Integer> col = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          row.add(i);
          col.add(j);
        }
      }
    }

    for (Integer r : row) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[r][i] = 0;
      }
    }

    for (Integer c : col) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][c] = 0;
      }
    }

    for (int[] p : matrix) {
      System.out.println(Arrays.toString(p));
    }

  }


  @Test
  public void test1() {
    setZeroes(new int[][]{
        {1, 1, 1},
        {1, 0, 1},
        {1, 1, 1}
    });
  }

  @Test
  public void test2() {
    setZeroes(new int[][]{
        {1},
        {0}
    });
  }

  @Test
  public void test3() {
    setZeroes(new int[][]{
        {0, 1, 2, 3},
        {1, 2, 3, 4}
    });
  }
}
