package org.lcfresh.practice;

import java.util.Stack;
import org.junit.Test;

public class MinimumDeletionCosttoAvoidRepeatingLetters_1578 {


  public int minCost(String s, int[] cost) {

    int minCost = 0;

    Stack<Character> stack = new Stack<>();

    stack.add(s.charAt(0));

    int prevIndex = 0;

    for (int i = 1; i < s.length(); i++) {

      char ch = s.charAt(i);

      if (stack.peek().equals(ch)) {
        if (cost[prevIndex] < cost[i]) {
          minCost += cost[prevIndex];
          prevIndex = i;
          stack.pop();
          stack.push(s.charAt(i));
        } else {
          minCost += cost[i];
        }
      } else {
        stack.push(s.charAt(i));
        prevIndex = i;
      }

    }

    return minCost;

  }


  @Test
  public void test1() {
    int[] cost = {1, 2, 3, 4, 1};
    minCost("aabaa", cost);
  }
}
