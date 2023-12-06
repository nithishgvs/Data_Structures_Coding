package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class MinimumRemovetoMakeValidParentheses_1249 {


  private class StackElement {

    int position;
    char ch;

    public StackElement(int position, char ch) {
      this.position = position;
      this.ch = ch;
    }
  }

  public String minRemoveToMakeValid(String s) {

    Stack<StackElement> stack = new Stack<>();

    final Character opening = '(';
    final Character closing = ')';

    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == opening || ch == closing) {
        if (!stack.isEmpty() && ch == closing && stack.peek().ch == opening) {
          stack.pop();
        } else {
          stack.add(new StackElement(i, ch));
        }
      }
    }

    for (int i = s.length() - 1; i > -1; i--) {
      if (!stack.isEmpty() && stack.peek().position == i) {
        stack.pop();
      } else {
        stringBuffer.append(s.charAt(i));
      }
    }

    return stringBuffer.reverse().toString();

  }


  @Test
  public void test1() {
    System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    System.out.println(minRemoveToMakeValid("))(("));
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("a)b(c)d"));
  }
}
