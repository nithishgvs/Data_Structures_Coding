package org.leetcode.DepthFirstSearch;

import org.junit.Test;

public class NumberofEnclaves_1020 {

  int count = 0;

  public int numEnclaves(int[][] A) {

    boolean[][] visited = new boolean[A.length][A[0].length];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        if (A[i][j] == 1 && !visited[i][j]) {
          canEscape(i, j, A, visited);
        }

      }
    }

    return count;
  }

  private boolean canEscape(int row, int col, int[][] A, boolean[][] visited) {

    if (row < 0 || row >= A.length || col < 0 || col >= A[0].length) {
      return true;
    }

    if (row > -1 && row < A.length && col > -1 && col < A[0].length) {

      if (A[row][col] == 0) {
        return false;
      }

      if (A[row][col] == 1) {
        if (!visited[row][col]) {
          visited[row][col] = true;
          if (canEscape(row - 1, col, A, visited) ||
              canEscape(row, col - 1, A, visited) ||
              canEscape(row, col + 1, A, visited) ||
              canEscape(row + 1, col, A, visited)) {
            return true;
          } else {
            System.out.println(row + "     " + col);
            count++;
          }
        }

      }
    }
    return false;
  }


  @Test
  public void test1() {

    int[][] board = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
    System.out
        .println(numEnclaves(board));
  }

  @Test
  public void test2() {

    int[][] board = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
    System.out
        .println(numEnclaves(board));
  }

  @Test
  public void test3() {

    int[][] board = {{0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
        {0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
        {0, 1, 1, 1, 1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
        {0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};
    System.out
        .println(numEnclaves(board));
  }
}
