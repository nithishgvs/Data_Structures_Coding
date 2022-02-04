package org.leetcode.Strings;

import java.util.Stack;
import org.junit.Test;

public class ScoreOfParentheses_856 {


  public int scoreOfParentheses(String s) {
    if (s == null || s.length() < 0) {
      return 0;
    }

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        stack.push(-1);
      } else {
        if (stack.peek() == -1) {
          stack.pop();
          stack.push(1);
        } else {
          int sum = 0;
          while (stack.peek() != -1) {
            sum += stack.pop();
          }
          sum = 2 * (sum);
          stack.pop();
          stack.push(sum);
        }

      }
    }

    int score = 0;
    while (!stack.empty()) {
      score += stack.pop();
    }
    return score;
  }


  @Test
  public void testParenthesesScore() {
    System.out.println(scoreOfParentheses("()()"));
  }

  @Test
  public void testParenthesesScore2() {
    System.out.println(scoreOfParentheses("(())()(())"));
  }

  //(()(()))
  @Test
  public void testParenthesesScore1() {

    //System.out.println(scoreOfParentheses("((())())"));
    //System.out.println(scoreOfParentheses("(())()"));
    System.out.println(scoreOfParentheses("(()(())((()((()))()))((())((())()(()()(())))))"));
    //System.out.println(scoreOfParentheses("(()(()))"));
  }
}
