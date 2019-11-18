package org.leetcode.StackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class EvaluateReversePolishNotation_150 {


  public int evalRPN(String[] tokens) {

    if(tokens.length<1){
      return 0;
    }

    Deque<Integer> stack = new ArrayDeque<>();

    for (String token : tokens) {
      if (!token.isEmpty() && "+/*-".contains(token)) {
        Integer firstValue = stack.pollFirst();
        Integer secondValue = stack.pollFirst();
        switch (token) {
          case "+":
            stack.addFirst(firstValue + secondValue);
            break;
          case "-":
            stack.addFirst(secondValue - firstValue);
            break;
          case "*":
            stack.addFirst(firstValue * secondValue);
            break;
          case "/":
            stack.addFirst(secondValue / firstValue);
            break;
          default:
            break;
        }
      } else {
        stack.addFirst(Integer.parseInt(token));
      }
    }

    return stack.peekFirst();
  }


  @Test
  public void testRPN1() {

    String[] tokens = {"2", "1", "+", "3", "*"};
    System.out.println(evalRPN(tokens));
  }

  @Test
  public void testRPN2() {
    String[] tokens = {"4", "13", "5", "/", "+"};
    System.out.println(evalRPN(tokens));
  }


  @Test
  public void testRPN3() {
    String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(evalRPN(tokens));
  }

}
