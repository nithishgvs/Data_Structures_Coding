package org.practice.io.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class SetMatrixZeroes_73 {


  public void setZeroes(int[][] matrix) {

    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    for (Integer r : rows) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[r][i] = 0;
      }
    }

    for (Integer c : cols) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][c] = 0;
      }
    }
    System.out.println(Arrays.deepToString(matrix));
  }


  @Test
  public void test1() {
    setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
  }
}
