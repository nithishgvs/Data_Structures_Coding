package org.leetcode.Strings;

import org.junit.Test;

public class WordSearch_79 {

  public boolean exist(char[][] board, String word) {
    if (word == null && word.length() == 0) {
      return false;
    }
    boolean[][] bool = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfsWord(board, i, j, word, 0, bool)) {
          return true;
        }
      }
    }
    return false;
  }


  public boolean dfsWord(char[][] board, int i, int j, String word, int index, boolean[][] bool) {
    if (index == word.length()) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || bool[i][j]) {
      return false;
    }
    if (board[i][j] == word.charAt(index)) {
      bool[i][j] = true;
      if (dfsWord(board, i, j - 1, word, index + 1, bool) || dfsWord(board, i, j + 1, word,
          index + 1, bool)
          || dfsWord(board, i + 1, j, word, index + 1, bool) || dfsWord(board, i - 1, j, word,
          index + 1, bool)) {
        return true;
      }
      bool[i][j] = false;
    }
    return false;
  }

  @Test
  public void testWordSearch() {
    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    char[][] board2 = {{'A', 'A'}};
    //System.out.println(exist(board2, "AAA"));
    char[][] board3 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
    System.out.println(exist(board3, "AAB"));

  }

}
