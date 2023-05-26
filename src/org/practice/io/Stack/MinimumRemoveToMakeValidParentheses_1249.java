package org.practice.io.Stack;

import java.util.Stack;
import org.junit.Test;

public class MinimumRemoveToMakeValidParentheses_1249 {


  public String minRemoveToMakeValid(String s) {

    StringBuilder stringBuilder = new StringBuilder();


    Stack<StackElement> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!Character.isAlphabetic(ch)) {
        if (ch == ')' && !stack.isEmpty() && stack.peek().ch == '(') {
          stack.pop();
        } else {
          stack.push(new StackElement(ch, i));
        }
      }
    }

    for (int i = s.length() - 1; i > -1; i--) {
      char ch = s.charAt(i);
      if (!stack.isEmpty() && stack.peek().index == i) {
        stack.pop();
      } else {
        stringBuilder.append(ch);
      }

    }

    return stringBuilder.reverse().toString();

  }

  public class StackElement {

    private char ch;
    private int index;

    public StackElement(char ch, int index) {
      this.ch = ch;
      this.index = index;
    }
  }


  @Test
  public void test1() {
    System.out.println(minRemoveToMakeValid("))(("));
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("a)b(c)d"));
  }
}
