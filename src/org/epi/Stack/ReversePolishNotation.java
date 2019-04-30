package org.epi.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class ReversePolishNotation {


  public int evaluateRPN(String input) {
    String[] rpnArray = input.split(",");
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < rpnArray.length; i++) {
      if (rpnArray[i].length() == 1 && "*+/-".contains(rpnArray[i])) {
        int firstElement = stack.removeFirst();
        int secondElement = stack.removeFirst();
        switch (rpnArray[i]) {
          case "+":
            stack.addFirst(firstElement + secondElement);
            break;
          case "-":
            stack.addFirst(firstElement - secondElement);
            break;
          case "*":
            stack.addFirst(firstElement * secondElement);
            break;
          case "/":
            stack.addFirst(firstElement / secondElement);
            break;
        }

      } else {
        stack.addFirst(Integer.valueOf(rpnArray[i]));
      }
    }

    return stack.peekFirst();
  }


  @Test
  public void testRPN() {
    System.out.println(evaluateRPN("3,4,+,2,*,1,+"));
  }


}
