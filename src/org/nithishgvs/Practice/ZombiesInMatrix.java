package org.nithishgvs.Practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.Test;

public class ZombiesInMatrix {


  public class Position {

    int r;
    int c;

    public Position(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }


  public int minHours(List<List<Integer>> grid) {
    int hours = 0;

    int peopleFound = 0;

    int[][] diagonols = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    Queue<Position> queue = new ArrayDeque<>();

    for (int row = 0; row < grid.size(); row++) {
      for (int col = 0; col < grid.get(0).size(); col++) {
        //Zombie Found
        if (grid.get(row).get(col) == 1) {
          queue.add(new Position(row, col));
        } else {
          peopleFound++;
        }
      }
    }

    while (!queue.isEmpty()) {
      int size = queue.size();
      hours++;
      for (int i = 0; i < size; i++) {
        Position position = queue.poll();
        for (int[] diagonol : diagonols) {
          if (isSafe(position.r + diagonol[0], position.c + diagonol[1], grid)
              && grid.get(position.r + diagonol[0]).get(position.c + diagonol[1]) == 0) {
            peopleFound--;
            if (peopleFound == 0) {
              return hours;
            }
            grid.get(position.r + diagonol[0]).set(position.c + diagonol[1], 1);
            queue.add(new Position(position.r + diagonol[0], position.c + diagonol[1]));

          }
        }

      }
    }
    return hours;

  }

  private boolean isSafe(int x, int y, List<List<Integer>> grid) {
    if (x > -1 && x < grid.size() && y > -1 && y < grid.get(0).size()) {
      return true;
    }
    return false;
  }


  @Test
  public void test1() {
    Integer[][] grid = new Integer[][]{{0, 1, 1, 0, 1},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 0, 1},
        {0, 1, 0, 0, 0}};
    List<List<Integer>> collection = Arrays.stream(grid).map(Arrays::asList)
        .collect(Collectors.toList());
    System.out.println(minHours(collection));
  }
}
