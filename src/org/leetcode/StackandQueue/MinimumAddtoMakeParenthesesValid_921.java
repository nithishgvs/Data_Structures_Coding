package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class MinimumAddtoMakeParenthesesValid_921 {

  public int minAddToMakeValid(String S) {
    Stack<Character> stack = new Stack<>();
    Stack<Character> stack2 = new Stack<>();

    for (int j = 0; j < S.length(); j++) {
      stack.push(S.charAt(j));
    }

    while (!stack.isEmpty()) {
      char popped = stack.pop();
      if (popped == '(' && !stack2.isEmpty() && stack2.peek() == ')') {
        stack2.pop();

      } else {
        stack2.push(popped);
      }
    }

    return stack2.size();
  }

  @Test
  public void testMin() {
    System.out.println(minAddToMakeValid("()))(("));
  }

}
