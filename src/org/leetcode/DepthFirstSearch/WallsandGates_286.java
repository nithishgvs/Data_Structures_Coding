package org.leetcode.DepthFirstSearch;

import org.junit.Test;

public class WallsandGates_286 {


  public void wallsAndGates(int[][] rooms) {

    helper(rooms);
  }

  private void helper(int[][] rooms) {


    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 0) {
          dfsHelper(i, j, rooms, 0);
        }
      }
    }

  }

  private void dfsHelper(int i, int j, int[][] rooms, int currentValue) {

    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == -1|| rooms[i][j]<currentValue) {
      return;
    }

    rooms[i][j] = currentValue;

    dfsHelper(i - 1, j, rooms, currentValue + 1);
    dfsHelper(i, j + 1, rooms, currentValue + 1);
    dfsHelper(i, j - 1, rooms, currentValue + 1);
    dfsHelper(i + 1, j, rooms, currentValue + 1);

  }


  @Test
  public void test() {

    int INF = Integer.MAX_VALUE;
    int[][] rooms = new int[][]{{INF, -1, 0, INF},
        {INF, INF, INF, -1},
        {INF, -1, INF, -1},
        {0, -1, INF, INF}};
    wallsAndGates(rooms);
    System.out.println(rooms.length);
  }

  @Test
  public void test1() {

    int INF = Integer.MAX_VALUE;
    int[][] rooms = new int[][]{{INF, -1},
        {0, INF}};
    wallsAndGates(rooms);
    System.out.println(rooms.length);
  }
}
