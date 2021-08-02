package org.lcfresh.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import org.junit.Test;

public class MergeIntervals_56 {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    Stack<int[]> stack = new Stack<>();
    stack.push(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      if (overlap(intervals[i], stack.peek())) {
        int[] popped = stack.pop();
        int[] newArray = new int[2];
        newArray[0] = Math.min(popped[0], intervals[i][0]);
        newArray[1] = Math.max(popped[1], intervals[i][1]);
        stack.push(newArray);
      }else{
        stack.push(intervals[i]);
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
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    System.out.println(merge(intervals));
  }

}
