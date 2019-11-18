package org.leetcode.StackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class DecodeString_394 {

  public String decodeString(String s) {

    if (s == null || s.length() < 0) {
      return null;
    }

    String decodedString = "";
    Deque<String> stack1 = new ArrayDeque<>();
    Deque<String> stack2 = new ArrayDeque<>();

    for (char ch : s.toCharArray()) {
      stack1.push(String.valueOf(ch));
    }

    while (!stack1.isEmpty()) {

      String poppedElement = "";

      while (!stack1.isEmpty() && Character.isDigit(stack1.peek().charAt(0))) {
        poppedElement += stack1.pop();
      }

      if (poppedElement.equals("")) {
        poppedElement = stack1.pop();
      } else {
        poppedElement = new StringBuilder(poppedElement).reverse().toString();
      }

      if (Character.isDigit(poppedElement.charAt(0))) {
        String temp = "";
        while (!stack2.isEmpty() && !stack2.peek().equals("]")) {
          String poppedStack2 = stack2.pop();
          if (!poppedStack2.equals("[")) {
            temp += poppedStack2;
          }
        }
        if (!stack2.isEmpty()) {
          stack2.pop();
        }
        stack2.push(new String(new char[Integer.valueOf(poppedElement)]).replace("\0", temp));
      } else {
        stack2.push(poppedElement);
      }
    }

    while (!stack2.isEmpty()) {
      decodedString += stack2.pop();
    }

    return decodedString;
  }

  @Test
  public void testDecodeString() {
    System.out.println(decodeString("3[a2[c]]"));
    System.out.println(decodeString("2[abc]3[cd]ef"));
    System.out.println(decodeString("3[a]2[bc]"));
    System.out.println(decodeString("100[leetcode]"));

  }

}
