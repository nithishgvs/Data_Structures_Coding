package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class RemoveAllAdjacentDuplicatesInString_1047 {

  public String removeDuplicates(String S) {

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < S.length(); i++) {

      char entry = S.charAt(i);

      if (stack.isEmpty()) {
        stack.push(entry);
        continue;
      }

      if (stack.peek() == entry) {
        stack.pop();
      } else {
        stack.push(entry);
      }
    }

    char[] arr = new char[stack.size()];

    int i = arr.length - 1;

    while (!stack.isEmpty()) {
      arr[i] = stack.pop();
      i--;
    }

    return String.valueOf(arr);
  }


  @Test
  public void test() {
    System.out.println(removeDuplicates("abbaca"));
  }

}
