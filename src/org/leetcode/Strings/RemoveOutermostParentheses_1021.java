package org.leetcode.Strings;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class RemoveOutermostParentheses_1021 {

  public String removeOuterParentheses(String S) {

    StringBuilder stringBuilder = new StringBuilder();

    Queue<Character> queue = new LinkedList<>();

    int count = 0;

    for (int i = 0; i < S.length(); i++) {

      if (S.charAt(i) == '(') {
        count++;
        queue.add(S.charAt(i));
      } else if (S.charAt(i) == ')') {
        count--;
        if (count == 0) {
          queue.poll();
          while (!queue.isEmpty()) {
            stringBuilder.append(queue.poll());
          }
        } else {
          queue.add(S.charAt(i));
        }
      }


    }

    return stringBuilder.toString();

  }


  @Test
  public void test1() {
    System.out.println(removeOuterParentheses("(()())(())(()(()))"));
  }


  @Test
  public void test2() {
    System.out.println(removeOuterParentheses("(()())(())"));
  }//"(((((())))))"

  @Test
  public void test3() {
    System.out.println(removeOuterParentheses("(((((())))))"));
  }

  @Test
  public void test4() {
    System.out.println(removeOuterParentheses("()()"));
  }
}
