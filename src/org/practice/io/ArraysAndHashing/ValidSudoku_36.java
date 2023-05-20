package org.practice.io.ArraysAndHashing;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

public class ValidSudoku_36 {

  /**
   * https://www.youtube.com/watch?v=Pl7mMcBm2b8
   * Followed the video my solution was complex
   * @param board
   * @return
   */

  public boolean isValidSudoku(char[][] board) {
    Set seen = new LinkedHashSet();
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        char number = board[i][j];
        if (number != '.') {
          if (!seen.add(number + " in Row " + i) ||
              !seen.add(number + " in Column " + j) ||
              !seen.add(number + " in Block " + i / 3 + "-" + j / 3)) {
            return false;
          }
        }
      }
    }
    return true;
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
