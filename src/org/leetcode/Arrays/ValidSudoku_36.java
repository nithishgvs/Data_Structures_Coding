package org.leetcode.Arrays;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class ValidSudoku_36 {


  public boolean isValidSudoku(char[][] board) {

    if (board.length != 9 || board[0].length != 9) {
      return false;
    }
    return sudokuHelper(board);
  }


  private boolean sudokuHelper(char[][] board) {

    for (char[] arr : board) {
      //Row check
      if (!helper(arr)) {
        return false;
      }
    }

    for (int i = 0; i < board.length; i++) {
      char[] column = getColumn(board, i);
      if (!helper(column)) {
        return false;
      }
    }

    for (int i = 0; i < 9; i = i + 3) {
      if (!gridValidate(board, i)) {
        return false;
      }
    }

    return true;
  }


  private boolean gridValidate(char[][] board, int row) {

    Set<Character> hashSet = new HashSet<>();
    int j = 0;
    for (int i = row; i < row + 3; i++) {
      for (j = 0; j < 3; j++) {
        if (board[i][j] != '.' && !hashSet.contains(board[i][j])) {
          hashSet.add(board[i][j]);
        } else if (board[i][j] != '.') {
          return false;
        }
      }
    }

    int k = j;

    hashSet = new HashSet<>();

    for (int i = row; i < row + 3; i++) {
      for (j = k; j < 6; j++) {
        if (board[i][j] != '.' && !hashSet.contains(board[i][j])) {
          hashSet.add(board[i][j]);
        } else if (board[i][j] != '.') {
          return false;
        }
      }
    }

    k = j;
    hashSet = new HashSet<>();

    for (int i = row; i < row + 3; i++) {
      for (j = k; j < 9; j++) {
        if (board[i][j] != '.' && !hashSet.contains(board[i][j])) {
          hashSet.add(board[i][j]);
        } else if (board[i][j] != '.') {
          return false;
        }
      }
    }

    return true;

  }


  private boolean helper(char[] arr) {
    Set<Character> hashSet = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != '.' && !hashSet.contains(arr[i])) {
        hashSet.add(arr[i]);
      } else if (arr[i] != '.') {
        return false;
      }
    }
    return true;
  }


  private char[] getColumn(char[][] array, int index) {
    char[] column = new char[array[0].length];
    for (int i = 0; i < column.length; i++) {
      column[i] = array[i][index];
    }
    return column;
  }


  @Test
  public void test1() {
    System.out.println(isValidSudoku(new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    }));
  }


  @Test
  public void test2() {
    System.out.println(isValidSudoku(new char[][]{{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}}));
  }


}
