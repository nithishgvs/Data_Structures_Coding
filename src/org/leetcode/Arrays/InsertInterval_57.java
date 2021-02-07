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
    newIntervals[intervals.length] = newInterval;
    Arrays.sort(newIntervals, Comparator.comparingInt(o -> o[0]));

    Stack<int[]> stack = new Stack<>();
    stack.push(newIntervals[0]);
    for (int i = 1; i < newIntervals.length; i++) {
      if (overlap(newIntervals[i], stack.peek())) {
        int[] popped = stack.pop();
        int[] newArray = new int[2];
        newArray[0] = Math.min(popped[0], newIntervals[i][0]);
        newArray[1] = Math.max(popped[1], newIntervals[i][1]);
        stack.push(newArray);
      }else{
        stack.push(newIntervals[i]);
      }
    }

    int[][] result = new int[stack.size()][2];
    int i = stack.size()-1;
    while (!stack.isEmpty()) {
      result[i][0] = stack.peek()[0];
      result[i][1] = stack.peek()[1];
      stack.pop();
      i--;
    }

    return result;

  }

  boolean overlap(int[] i1, int[] i2) {
    int front = Math.max(i1[0], i2[0]);
    int back = Math.min(i1[1], i2[1]);
    return back - front >= 0;
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


}
