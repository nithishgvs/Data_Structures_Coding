package org.twentytwentytwo.practice;

import org.junit.Test;

public class WordSearch_79 {

  public boolean exist(char[][] board, String word) {

    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (wordSearchHelper(0, visited, board, word, i, j)) {
          return true;
        }
      }
    }

    return false;

  }

  private boolean wordSearchHelper(int index, boolean[][] visited, char[][] board, String word,
      int row,
      int col) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return false;
    }
    if (visited[row][col]) {
      return false;
    }
    if (word.charAt(index) == board[row][col]) {
      if (index == word.length() - 1) {
        return true;
      }
      visited[row][col] = true;
      boolean neigh1 = wordSearchHelper(index+1, visited, board, word, row, col - 1);
      boolean neigh2 = wordSearchHelper(index+1, visited, board, word, row - 1, col);
      boolean neigh3 = wordSearchHelper(index+1, visited, board, word, row, col + 1);
      boolean neigh4 = wordSearchHelper(index+1, visited, board, word, row + 1, col);
      visited[row][col] = false;
      return neigh1 || neigh2 || neigh3 || neigh4;
    }
    return false;
  }

  @Test
  public void test1() {
    char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    System.out.println(exist(board,"SEE"));

  }

}
