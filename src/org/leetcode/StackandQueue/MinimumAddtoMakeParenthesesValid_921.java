package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class MinimumAddtoMakeParenthesesValid_921 {

  public int minAddToMakeValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
        stack.pop();
      } else {
        stack.add(s.charAt(i));
      }
    }
    return stack.size();
  }

  @Test
  public void testMin() {
    System.out.println(minAddToMakeValid("()))(("));
  }

  @Test
  public void testMin1() {
    System.out.println(minAddToMakeValid("((("));
  }

}
