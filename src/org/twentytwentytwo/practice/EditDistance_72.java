package org.twentytwentytwo.practice;

import org.junit.Test;

public class EditDistance_72 {

  public int minDistance(String word1, String word2) {

    int[][] matrix = new int[word1.length() + 1][word2.length() + 1];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == 0 && j == 0) {
          matrix[i][j] = 0;
        } else if (i == 0) {
          matrix[i][j] = matrix[i][j - 1] + 1;
        } else if (j == 0) {
          matrix[i][j] = matrix[i - 1][j] + 1;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          matrix[i][j] = matrix[i - 1][j - 1];
        } else {
          matrix[i][j] = Math
              .min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + 1;
        }

      }
    }
    return matrix[word1.length()][word2.length()];

  }

  @Test
  public void test(){
    System.out.println(minDistance("horse","ros"));
  }

}
