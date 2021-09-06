package org.lcfresh.practice;

import java.util.Stack;
import org.junit.Test;

public class MinimumAddtoMakeParenthesesValid_921 {

  public int minAddToMakeValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char character = s.charAt(i);
      if (!stack.isEmpty() && character == ')' && stack.peek() == '(') {
        stack.pop();
      } else {
        stack.push(character);
      }
    }

    return stack.size();

  }

  @Test
  public void test1() {
    System.out.println(minAddToMakeValid("()"));
  }

}
