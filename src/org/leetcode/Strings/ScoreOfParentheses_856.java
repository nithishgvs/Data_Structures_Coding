package org.leetcode.Strings;

import java.util.Stack;
import org.junit.Test;

public class ScoreOfParentheses_856 {


  public int scoreOfParentheses(String S) {
    if (S == null || S.length() < 0) {
      return 0;
    }

    Stack<Character> stack1 = new Stack<>();

    for (char ch : S.toCharArray()) {
      if (!stack1.isEmpty() && stack1.peek() == '(' && ch == ')') {
        stack1.pop();
        stack1.add('1');
      } else {
        stack1.push(ch);
      }
    }

    Stack<Character> stack2 = new Stack<>();
    while (!stack1.isEmpty()) {
      char popped1 = stack1.pop();
      if (popped1 == '(') {
        int num = 0;
        while (!stack2.isEmpty()) {
          char popped2 = stack2.pop();
          if (Character
              .isDigit(popped2)) {
            num = Character.getNumericValue(popped2);
          }
          if (popped2 == ')' && num != 0) {
            if (!stack2.isEmpty() && Character
                .isDigit(stack2.peek())) {
              stack2
                  .push(Character.forDigit(2 * num + Character.getNumericValue(stack2.pop()), 10));
            } else {
              stack2.push(Character.forDigit(2 * num, 10));
            }
            break;
          }
        }

      } else if (!stack2.isEmpty() && Character
          .isDigit(popped1) && Character
          .isDigit(stack2.peek())) {
        stack2.push(Character
            .forDigit(Character.getNumericValue(popped1) + Character.getNumericValue(stack2.pop()),
                10));
      } else {
        stack2.push(popped1);
      }

    }

    return Character.getNumericValue(stack2.peek());
  }


  @Test
  public void testParenthesesScore() {
    System.out.println(scoreOfParentheses("(()(()))"));
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
