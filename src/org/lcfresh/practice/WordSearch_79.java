package org.lcfresh.practice;

import org.junit.Test;

public class WordSearch_79 {



  public boolean wordSearchHelper(char[][] board, int i, int j, String word, int index, boolean[][] bool) {
    if (index == word.length()) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || bool[i][j]) {
      return false;
    }
    if (board[i][j] == word.charAt(index)) {
      bool[i][j] = true;
      if (wordSearchHelper(board, i, j - 1, word, index + 1, bool) || wordSearchHelper(board, i, j + 1, word,
          index + 1, bool)
          || wordSearchHelper(board, i + 1, j, word, index + 1, bool) || wordSearchHelper(board, i - 1, j, word,
          index + 1, bool)) {
        return true;
      }
      bool[i][j] = false;
    }
    return false;
  }

  public boolean exist(char[][] board, String word) {

    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
          if (wordSearchHelper(board, i, j, word, 0, visited)) {
            return true;
          }
        }
      }

    return false;

  }

  @Test
  public void test1() {
    char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    System.out.println(exist(board, "ABCB"));
  }


}
