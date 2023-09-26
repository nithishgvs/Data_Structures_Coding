package org.leetcode.Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import org.junit.Test;

public class InsertInterval_57 {


  public int[][] insert(int[][] intervals, int[] newInterval) {

    int[][] newIntervals = new int[intervals.length + 1][2];

    for (int i = 0; i < intervals.length; i++) {
      newIntervals[i] = intervals[i];
    }

    newIntervals[newIntervals.length - 1] = newInterval;
    Arrays.sort(newIntervals, Comparator.comparing(a -> a[0]));

    Stack<int[]> stack = new Stack<>();
    stack.add(newIntervals[0]);

    for (int i = 1; i < newIntervals.length; i++) {
      if (overlap(stack.peek(), newIntervals[i])) {
        int[] pop = stack.pop();
        stack.add(new int[]{Math.min(pop[0], newIntervals[i][0]), Math.max(pop[1], newIntervals[i][1])});
      } else {
        stack.add(newIntervals[i]);
      }
    }

    int[][] result = new int[stack.size()][2];

    int i = result.length - 1;

    while (!stack.isEmpty()) {
      result[i] = stack.pop();
      i--;
    }
    return result;

  }

  private boolean overlap(int[] peek, int[] newInterval) {
    int front = Math.max(peek[0], newInterval[0]);
    int back = Math.min(peek[1], newInterval[1]);
    return front - back <= 0;
  }


  @Test
  public void test1() {
    int[][] intervals = {{1, 3}, {6, 9}};
    insert(intervals, new int[]{2, 5});
  }

  @Test
  public void test2() {
    int[][] intervals = {};
    insert(intervals, new int[]{2, 5});
  }

  @Test
  public void test3() {
    int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    insert(intervals, new int[]{4,8});
  }
}
