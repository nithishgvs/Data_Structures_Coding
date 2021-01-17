package org.leetcode.Arrays;

import org.junit.Test;

public class FindWinneronaTicTacToeGame_1275 {


  private static final String PENDING = "Pending";

  public String tictactoe(int[][] moves) {

    char[][] matrix = new char[3][3];

    boolean aMove = true;

    int i = 0;

    for (int[] move : moves) {
      if (aMove) {
        matrix[move[0]][move[1]] = 'A';
      } else {
        matrix[move[0]][move[1]] = 'B';
      }
      aMove = !aMove;
      i++;
    }

    String column = validateColumn(matrix);

    if (!column.equals(PENDING)) {
      return column;
    }

    String row = validateRow(matrix);

    if (!row.equals(PENDING)) {
      return row;
    }

    String diagonal = validateDiagonal(matrix);

    if (!diagonal.equals(PENDING)) {
      return diagonal;
    }

    if (i == 9) {
      return "Draw";
    }

    return PENDING;

  }


  public String validateRow(char[][] matrix) {
    for (int i = 0; i < 3; i++) {
      if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]
          && matrix[i][2] != Character.MIN_VALUE) {
        return String.valueOf(matrix[i][0]);
      }
    }
    return PENDING;
  }

  public String validateColumn(char[][] matrix) {
    for (int i = 0; i < 3; i++) {
      if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]
          && matrix[2][i] != Character.MIN_VALUE) {
        return String.valueOf(matrix[0][i]);
      }
    }
    return PENDING;
  }

  public String validateDiagonal(char[][] matrix) {
    if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]
        && matrix[1][1] != Character.MIN_VALUE) {
      return String.valueOf(matrix[0][0]);
    } else if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]
        && matrix[1][1] != Character.MIN_VALUE) {
      return String.valueOf(matrix[0][2]);
    }
    return PENDING;
  }


  @Test
  public void test1() {
    int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
    System.out.println(tictactoe(moves));
  }

  @Test
  public void test2() {
    int[][] moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
    System.out.println(tictactoe(moves));
  }

  @Test
  public void test3() {
    int[][] moves = {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
    System.out.println(tictactoe(moves));
  }


  @Test
  public void test4() {
    int[][] moves = {{0, 0}, {1, 1}};
    System.out.println(tictactoe(moves));
  }

}
