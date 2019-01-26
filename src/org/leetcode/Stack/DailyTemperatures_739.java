package org.leetcode.Stack;

import java.util.Stack;
import org.junit.Test;

//Copied have to look into it soon
public class DailyTemperatures_739 {

  public int[] dailyTemperatures(int[] T) {
    int[] res = new int[T.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < T.length; i++) {
      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        int p = stack.pop();
        res[p] = i - p;
      }
      stack.push(i);
    }

    return res;

  }


  @Test
  public void testDailyTemperatures() {
    int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
    dailyTemperatures(T);
  }

}
