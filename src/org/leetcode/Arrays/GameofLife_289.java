package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GameofLife_289 {

  public void gameOfLife(int[][] board) {
    int[][] output = new int[board.length][board[0].length];

    List<int[]> list = new ArrayList<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {

        int value = board[i][j];

        if (value == 1) {
          int liveNeighbours = helperGameOfLife(i, j, board);
          if (liveNeighbours < 2) {
            list.add(new int[]{i, j, -1});
          } else if (liveNeighbours > 3) {
            list.add(new int[]{i, j, -1});
          }
        } else {
          int liveNeighbours = helperGameOfLife(i, j, board);
          if (liveNeighbours == 3) {
            list.add(new int[]{i, j, 1});
          }
        }
      }
    }

    for (int[] arr : list) {
      board[arr[0]][arr[1]] += arr[2];
    }

  }

  private int helperGameOfLife(int i, int j, int[][] board) {
    int count = 0;
    int[][] neighbours = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    for (int[] entry : neighbours) {
      if (i + entry[0] > -1 && j + entry[1] > -1 && i + entry[0] < board.length
          && j + entry[1] < board[0].length) {
        if (board[i + entry[0]][j + entry[1]] == 1) {
          count++;
        }
      }
    }
    return count;
  }


  @Test
  public void test1() {
    int[][] board = {{0, 1, 0},
        {0, 0, 1},
        {1, 1, 1},
        {0, 0, 0}};

    gameOfLife(board);
  }
}
