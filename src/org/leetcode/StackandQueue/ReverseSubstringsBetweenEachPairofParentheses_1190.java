package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class ReverseSubstringsBetweenEachPairofParentheses_1190 {

  public String reverseParentheses(String s) {

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char entry = s.charAt(i);
      if (stack.isEmpty()) {
        stack.push(entry);
        continue;
      }

      if (entry != ')') {
        stack.push(entry);
      } else {
        StringBuilder sb = new StringBuilder();
        while (stack.peek() != '(') {
          sb.append(stack.pop());
        }
        stack.pop();

        String sbString = sb.toString();

        for (int j = 0; j <sbString.length(); j++) {
          stack.push(sb.charAt(j));
        }

      }

    }

    char[] arr=new char[stack.size()];

    int i=arr.length-1;

    while(!stack.isEmpty()){
      arr[i--]=stack.pop();
    }

    return String.valueOf(arr);
  }


  @Test
  public void test() {
    System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
  }

}
