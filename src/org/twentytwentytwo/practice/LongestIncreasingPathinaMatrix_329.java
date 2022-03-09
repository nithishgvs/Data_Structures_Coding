package org.twentytwentytwo.practice;

import org.junit.Test;

public class LongestIncreasingPathinaMatrix_329 {


  int maxPath = 0;

  public int longestIncreasingPath(int[][] matrix) {

    int[][] cache = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < cache.length; i++) {
      for (int j = 0; j < cache[0].length; j++) {
        maxPath = Math.max(maxPath, helper(cache, matrix, i, j, -1));
      }
    }

    return maxPath;

  }

  private int helper(int[][] cache, int[][] matrix, int row, int col, int prevValue) {

    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
        || matrix[row][col] <= prevValue) {
      return 0;
    }

    if (cache[row][col] != 0) {
      return cache[row][col];
    }

    System.out.println(row + "::::" + col + ":::" + ":::" + matrix[row][col]);
    int neigh1 = helper(cache, matrix, row - 1, col, matrix[row][col]) + 1;
    int neigh2 = helper(cache, matrix, row, col - 1, matrix[row][col]) + 1;
    int neigh3 = helper(cache, matrix, row, col + 1, matrix[row][col]) + 1;
    int neigh4 = helper(cache, matrix, row + 1, col, matrix[row][col]) + 1;

    cache[row][col] = Math.max(neigh1, Math.max(neigh2, Math.max(neigh3, neigh4)));
    return cache[row][col];
  }

  @Test
  public void test() {
    int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    int[][] matrix3 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
    int[][] matrix2 = {{1}};
    System.out.println(longestIncreasingPath(matrix));
  }
}
