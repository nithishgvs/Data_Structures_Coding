package org.lcfresh.practice;

import java.util.Stack;
import org.junit.Test;

public class AsteroidCollision_735 {

  public int[] asteroidCollision(int[] asteroids) {

    Stack<Integer> stack = new Stack<>();

    stack.add(asteroids[0]);

    for (int i = 1; i < asteroids.length; i++) {
      stack.add(asteroids[i]);
      while (stack.size() > 1 && clashCondition(stack)) {
        int last = stack.pop();
        if (Math.abs(last) > stack.peek()) {
          stack.pop();
          stack.add(last);
        } else if (Math.abs(last) == stack.peek()) {
          stack.pop();
        }
      }
    }

    int[] output = new int[stack.size()];

    int i = stack.size() - 1;

    while (!stack.isEmpty()) {
      output[i] = stack.pop();
      i--;
    }
    return output;
  }

  private boolean clashCondition(Stack<Integer> stack) {
    int last = stack.pop();
    int peek = stack.peek();
    stack.add(last);
    if (peek > 0 && last < 0) {
      return true;
    }
    return false;
  }


  @Test
  public void test() {
    int[] asteroids = {-2,-1,1,2};
    asteroidCollision(asteroids);
  }

}
