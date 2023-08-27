package org.practice.io.ArraysAndHashing;

import java.util.Arrays;
import org.junit.Test;

public class SurroundedRegions_130 {


  /**
   * Nick White https://www.youtube.com/watch?v=ztTLGMeleco You check all boundaries and adjacent 0
   * from the boundary 0 can't be made X so we make them as asterisk *
   */
  public void solve(char[][] board) {

    if (board.length == 0 || board[0].length == 0) {
      return;
    }

    int rows = board.length;

    int cols = board[0].length;

    for (int i = 0; i < rows; i++) {
      if (board[i][0] == 'O') {
        boundaryHelper(board, i, 0);
      }
      if (board[i][cols - 1] == 'O') {
        boundaryHelper(board, i, cols - 1);
      }
    }

    for (int j = 0; j < cols; j++) {
      if (board[0][j] == 'O') {
        boundaryHelper(board, 0, j);
      }
      if (board[rows - 1][j] == 'O') {
        boundaryHelper(board, rows - 1, j);
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == '*') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }

    System.out.println(Arrays.deepToString(board));

  }

  private void boundaryHelper(char[][] board, int row, int col) {

    if (row > board.length - 1 || row < 0 || col > board[0].length - 1 || col < 0) {
      return;
    }

    if (board[row][col] == 'O') {
      board[row][col] = '*';
    }

    if (col > 0 && board[row][col - 1] == 'O') {
      boundaryHelper(board, row, col - 1);
    }

    if (row > 0 && board[row - 1][col] == 'O') {
      boundaryHelper(board, row - 1, col);
    }

    if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
      boundaryHelper(board, row, col + 1);
    }

    if (row < board.length - 1 && board[row + 1][col] == 'O') {
      boundaryHelper(board, row + 1, col);
    }
  }

  @Test
  public void test() {
    solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}, {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}});

  }
}
