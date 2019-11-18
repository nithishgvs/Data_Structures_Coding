package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class RemoveAllAdjacentDuplicatesinStringII_1209 {


  private class StackElement {

    Character ch;
    Integer count;

    StackElement(Character ch, Integer count) {
      this.ch = ch;
      this.count = count;
    }
  }


  public String removeDuplicates(String s, int k) {

    Stack<StackElement> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {

      char element = s.charAt(i);
      if (stack.isEmpty()) {
        stack.push(new StackElement(element, 1));
        continue;
      }

      if (element == stack.peek().ch) {
        if (stack.peek().count == k - 1) {
          int poppingVal = k - 1;
          while (poppingVal > 0) {
            stack.pop();
            poppingVal--;
          }
        } else {
          stack.push(new StackElement(element, stack.peek().count + 1));
        }
      } else {
        stack.push(new StackElement(element, 1));
      }

    }

    char[] arr = new char[stack.size()];
    int i = arr.length - 1;
    while (!stack.isEmpty()) {
      arr[i] = stack.pop().ch;
      i--;
    }

    return String.valueOf(arr);

  }


  @Test
  public void test() {
    System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
  }

  @Test
  public void test1() {
    System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
  }


}
