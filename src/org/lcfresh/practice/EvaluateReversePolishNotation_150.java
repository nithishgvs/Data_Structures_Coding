package org.lcfresh.practice;

import java.util.Stack;
import org.junit.Test;

public class EvaluateReversePolishNotation_150 {

  public int evalRPN(String[] tokens) {

    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      if ("+-/*".contains(token)) {
        int element1 = stack.pop();
        int element2 = stack.pop();
        switch (token) {
          case ("+"):
            stack.push(element2 + element1);
            break;
          case ("-"):
            stack.push(element2 - element1);
            break;
          case ("*"):
            stack.push(element2 * element1);
            break;
          case ("/"):
            stack.push(element2 / element1);
            break;
        }
      } else {
        stack.push(Integer.valueOf(token));
      }

    }
    return stack.pop();
  }

  @Test
  public void testRPN() {
    String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(evalRPN(tokens));
  }

}
