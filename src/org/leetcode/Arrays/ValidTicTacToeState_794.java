package org.leetcode.Arrays;

import org.junit.Test;

public class ValidTicTacToeState_794 {

  char[][] tictac = new char[3][3];

  public boolean validTicTacToe(String[] board) {

    if (board.length != 3 || board[0].length() != 3) {
      return false;
    }

    int xCount = 0;
    int oCount = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i].charAt(j) == 'X') {
          xCount++;
        } else if (board[i].charAt(j) == 'O') {
          oCount++;
        }
        tictac[i][j] = board[i].charAt(j);
      }
    }

    if (xCount > oCount + 1) {
      return false;
    }

    if (oCount > xCount) {
      return false;
    }

    //Filter not possible cases
    if (validateWinner('X') && validateWinner('O')) {
      return false;
    }

    if (validateWinner('X') && xCount == oCount) {
      return false;
    }

    if (validateWinner('O') && xCount > oCount) {
      return false;
    }

    return true;
  }


  public boolean validateWinner(char value) {

    if (validateColumn(value) || validateRows(value) || validateDiagonal(value)) {
      return true;
    }

    return false;
  }


  private boolean validateRows(char value) {

    for (int i = 0; i < 3; i++) {
      if (tictac[i][0] == value && tictac[i][1] == value && tictac[i][2] == value) {
        return true;
      }
    }

    return false;

  }


  private boolean validateColumn(char value) {

    for (int i = 0; i < 3; i++) {
      if (tictac[0][i] == value && tictac[1][i] == value && tictac[2][i] == value) {
        return true;
      }
    }

    return false;

  }


  private boolean validateDiagonal(char value) {

    if ((tictac[0][0] == value && tictac[1][1] == value && tictac[2][2] == value) || (
        tictac[0][2] == value && tictac[1][1] == value && tictac[2][0] == value)) {
      return true;
    }

    return false;

  }

  @Test
  public void test() {
    System.out.println(validTicTacToe(new String[]{"X  ", "   ", "   "}));

  }

  @Test
  public void test1() {
    System.out.println(validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
    //"XXX", "   ", "OOO"
  }

  @Test
  public void test2() {
    System.out.println(validTicTacToe(new String[]{"XXX", "OOX", "OOX"}));
    //
    //["XOX","O O","XOX"]
  }

  @Test
  public void test3() {
    System.out.println(validTicTacToe(new String[]{"OXX","XOX","OXO"}));
    //
    //["XOX","O O","XOX"]
  }
}
