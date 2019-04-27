package org.leetcode.Strings;

import java.util.Stack;
import org.junit.Test;

public class ScoreOfParentheses_856 {


  public int scoreOfParentheses(String S) {
    int score = 0;
    if (S == null || S.length() < 0) {
      return score;
    }

    char startChar = '(';
    char endChar = ')';

    Stack<Character> stack1 = new Stack<>();


    return score;
  }


  @Test
  public void testParenthesesScore() {
    System.out.println(scoreOfParentheses("(()(()))"));
  }

  @Test
  public void testParenthesesScore2() {
    System.out.println(scoreOfParentheses("(())()(())"));
  }
}
