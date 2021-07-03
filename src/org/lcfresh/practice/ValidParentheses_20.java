package org.lcfresh.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.Test;

public class ValidParentheses_20 {


  public boolean isValid(String s) {

    Stack<Character> stack = new Stack<>();

    Map<Character, Character> helper = new HashMap<>();
    helper.put(']', '[');
    helper.put(')', '(');
    helper.put('}', '{');

    for (char ch : s.toCharArray()) {
      if (helper.keySet().contains(ch)) {
        if (!stack.isEmpty() && stack.peek() == helper.get(ch)) {
          stack.pop();
        } else {
          stack.add(ch);
        }
      } else {
        stack.push(ch);
      }

    }

    return stack.isEmpty();
  }

  @Test
  public void testValidParentheses() {
    String s = "()[]{}";
    System.out.println(isValid(s));
  }

}
