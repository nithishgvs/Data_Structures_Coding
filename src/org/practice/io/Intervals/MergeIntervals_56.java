package org.practice.io.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import org.junit.Test;

public class MergeIntervals_56 {

  public int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    Stack<int[]> stack = new Stack<>();
    stack.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] currentInterval = intervals[i];
      if (overlap(stack.peek(), currentInterval)) {
        int[] popped = stack.pop();
        stack.push(new int[]{Math.min(popped[0], currentInterval[0]),
            Math.max(popped[1], currentInterval[1])});
      } else {
        stack.push(currentInterval);
      }

    }

    int[][] result = new int[stack.size()][2];

    int index = stack.size() - 1;

    while (!stack.isEmpty()) {
      result[index][0] = stack.peek()[0];
      result[index][1] = stack.pop()[1];
      index--;
    }

    return result;

  }

  private boolean overlap(int[] peek, int[] currentInterval) {

    int front = Math.max(peek[0], currentInterval[0]);
    int back = Math.min(peek[1], currentInterval[1]);

    return back - front >= 0;
  }

  @Test
  public void test1() {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    System.out.println(merge(intervals));
  }


  @Test
  public void test2() {
    int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
    System.out.println(merge(intervals));
  }
}
