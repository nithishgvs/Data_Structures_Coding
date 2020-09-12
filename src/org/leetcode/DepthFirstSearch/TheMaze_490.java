package org.leetcode.DepthFirstSearch;

import org.junit.Test;

public class TheMaze_490 {

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    return dfsHelper(maze, start, destination, new boolean[maze.length][maze[0].length]);
  }

  private boolean dfsHelper(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
    int newX = start[0], newY = start[1];
    if (newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length) {
      return false;
    }

    boolean value = false;
    if (!visited[newX][newY] && maze[newX][newY] == 0) {
      if (newX == destination[0] && newY == destination[1]) {
        return true;
      }
      visited[newX][newY] = true;
      value = dfsHelper(maze, new int[]{newX - 1, newY}, destination, visited) ||
          dfsHelper(maze, new int[]{newX, newY + 1}, destination, visited) ||
          dfsHelper(maze, new int[]{newX, newY - 1}, destination, visited) ||
          dfsHelper(maze, new int[]{newX + 1, newY}, destination, visited);
    }

    return value;
  }


  public boolean hasPath2(int[][] maze, int[] s, int[] d) {
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int m = maze.length, n = maze[0].length;
    boolean[][] visited = new boolean[m][n];
    return visit(maze, s, d, visited, m, n, dirs);
  }
  private boolean visit(int[][] maze, int[] s, int[] d, boolean[][] visited, int m, int n, int[][] dirs){
    if(s[0]==d[0] && s[1]==d[1]){
      return true;
    }
    visited[s[0]][s[1]]=true;
    for(int[] dir: dirs){
      int x = s[0], y = s[1];
      while(x+dir[0]<m && y+dir[1]<n && x+dir[0]>=0 && y+dir[1]>=0 && maze[x+dir[0]][y+dir[1]]==0){
        x += dir[0];
        y += dir[1];
      }
      if(!visited[x][y] && visit(maze, new int[]{x,y}, d, visited, m, n, dirs)) return true;
    }
    return false;
  }
  @Test
  public void test1() {
    int[][] maze =
        {{0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}};
    int[] start = {0, 4};
    int[] destination = {4, 4};
    System.out.println(hasPath2(maze, start, destination));
  }

  @Test
  public void test2() {
    int[][] maze =
        {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
    int[] start = {0, 4};
    int[] destination = {3, 2};
    System.out.println(hasPath2(maze, start, destination));
  }

}
