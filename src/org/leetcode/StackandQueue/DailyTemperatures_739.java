package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

//Copied have to look into it soon
public class DailyTemperatures_739 {

  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int poppedIndex = stack.pop();
        result[poppedIndex] = i - poppedIndex;
      }
      stack.add(i);
    }
    return result;

  }


  @Test
  public void testDailyTemperatures() {
    int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
    dailyTemperatures(T);
  }

}
