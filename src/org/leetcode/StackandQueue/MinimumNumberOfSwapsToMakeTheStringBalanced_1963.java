package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class MinimumNumberOfSwapsToMakeTheStringBalanced_1963 {

  public int minSwaps(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '[') {
        stack.pop();
      } else if (s.charAt(i) == '[') {
        stack.push(s.charAt(i));
      }
    }
    if (stack.size() % 2 == 0) {
      return stack.size() / 2;
    }
    return (stack.size() + 1) / 2;
  }


  @Test
  public void test() {
    System.out.println(minSwaps("]][["));
    System.out.println(minSwaps("[][]"));
  }

}
