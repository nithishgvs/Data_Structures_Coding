package org.twentytwentytwo.practice;

import java.util.Stack;
import org.junit.Test;

public class RemoveAllAdjacentDuplicatesInString_1047 {

  public String removeDuplicates(String s) {

    Stack<Character> stack = new Stack<>();
    stack.add(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {

      if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
        stack.pop();
      } else {
        stack.push(s.charAt(i));
      }
    }

    StringBuilder stringBuilder = new StringBuilder();

    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }

    return stringBuilder.reverse().toString();

  }


  @Test
  public void test() {
    System.out.println(removeDuplicates("azxxzy"));
    System.out.println((float)5/60);
    System.out.println((float)12%12+(float)59/60);
    System.out.println(0.98*360);
  }

}
