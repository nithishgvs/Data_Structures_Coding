package org.leetcode.StackandQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.Test;

public class MinimumRemovetoMakeValidParentheses_1249 {


  public class StackElement {

    char character;
    int index;

    public StackElement(char character, int index) {
      this.character = character;
      this.index = index;
    }
  }

  public String minRemoveToMakeValid(String s) {

    StringBuffer stringBuffer = new StringBuffer();
    Stack<StackElement> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '(') {
        stack.add(new StackElement(ch, i));
      }

      if (ch == ')') {
        if (!stack.isEmpty() && stack.peek().character == '(') {
          stack.pop();
        } else {
          stack.add(new StackElement(ch, i));
        }
      }

    }

    if (stack.size() != s.length()) {

      List<Integer> list = new ArrayList<>();

      while (!stack.isEmpty()) {
        list.add(stack.pop().index);
      }
      for (int i = 0; i < s.length(); i++) {
        if (!list.contains(i)) {
          stringBuffer.append(s.charAt(i));
        }
      }

    }

    return stringBuffer.toString();

  }


  @Test
  public void test1(){
    System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    //))((
    System.out.println(minRemoveToMakeValid("))(("));
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("a)b(c)d"));
  }
}
