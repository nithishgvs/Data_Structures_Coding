package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class MergeIntervals_56 {


  public int[][] merge(int[][] intervals) {

    List<Coordinates> sortedList = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      sortedList.add(new Coordinates(intervals[i][0], intervals[i][1]));
    }

    Collections.sort(sortedList, (Coordinates o1, Coordinates o2) -> o1.x - o2.x);

    List<Coordinates> outputList = new ArrayList<>();
    for (int i = 0; i < sortedList.size(); i++) {
      if (outputList.size() == 0) {
        outputList.add(new Coordinates(sortedList.get(i).x, sortedList.get(i).y));
      } else {
        Coordinates temp = outputList.get(outputList.size() - 1);
        if (temp.y >= sortedList.get(i).y || temp.y >= sortedList.get(i).x) {
          outputList.remove(outputList.size() - 1);
          outputList.add(
              new Coordinates(Math.min(temp.x, sortedList.get(i).x),
                  Math.max(temp.y, sortedList.get(i).y)));
        } else {
          outputList.add(
              new Coordinates(sortedList.get(i).x,
                  sortedList.get(i).y));
        }
      }
    }

    int[][] output = new int[outputList.size()][2];

    for (int i = 0; i < outputList.size(); i++) {
      output[i][0] = outputList.get(i).x;
      output[i][1] = outputList.get(i).y;
    }

    return output;

  }

  public class Coordinates {

    int x;
    int y;

    public Coordinates(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


  @Test
  public void testIntervals() {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    merge(intervals);
  }


  @Test
  public void testIntervals1() {
    int[][] intervals = {{1, 4}, {4, 5}};
    merge(intervals);
  }

  @Test
  public void testIntervals2() {
    int[][] intervals = {{1, 4}, {0, 4}};
    merge(intervals);
  }

  @Test
  public void testIntervals3() {
    int[][] intervals = {{1, 4}, {2, 3}};
    merge(intervals);
  }


  @Test
  public void testIntervals4() {
    int[][] intervals = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
    merge(intervals);
  }


}
