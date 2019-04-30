package org.epi.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class WellFormedNess {


  public boolean isWellFormed(String input) {
    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < input.length(); i++) {

      if (input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '[') {
        stack.addFirst(input.charAt(i));
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        if (input.charAt(i) == '}' && stack.peekFirst() != '{'
            || input.charAt(i) == ')' && stack.peekFirst() != '('
            || input.charAt(i) == ']' && stack.peekFirst() != '[') {
          return false;
        }
        stack.removeFirst();
      }

    }

    return stack.isEmpty();
  }


  @Test
  public void testWellFormedNess() {
    System.out.println(isWellFormed("{}()()[]"));
    System.out.println(isWellFormed("{}{(}))}"));
  }


}
