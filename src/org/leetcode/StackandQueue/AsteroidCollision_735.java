package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class AsteroidCollision_735 {

  //The XOR of x and y will have the sign bit as 1 iff they have opposite sign

  public int[] asteroidCollision(int[] asteroids) {

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < asteroids.length; i++) {

      if (stack.isEmpty() || !oppositeSigns(stack.peek(), asteroids[i])) {
        stack.push(asteroids[i]);
        continue;
      }

      boolean pushFlag = true;

      while (!stack.isEmpty() && oppositeSigns(stack.peek(), asteroids[i])) {
        if (stack.peek() < 0 && asteroids[i] > 0) {
          stack.push(asteroids[i]);
          pushFlag = false;
          break;
        }
        if (stack.peek() > 0 && asteroids[i] < 0) {
          if (Math.abs(asteroids[i]) == stack.peek()) {
            stack.pop();
            pushFlag = false;
            break;
          } else if (Math.abs(asteroids[i]) > stack.peek()) {
            stack.pop();
            pushFlag = true;
          } else if (Math.abs(asteroids[i]) < stack.peek()) {
            pushFlag = false;
            break;
          }

        }
      }

      if (pushFlag) {
        stack.push(asteroids[i]);
      }

    }

    int[] array=new int[stack.size()];


    int i=array.length-1;

    while (!stack.isEmpty()) {
      array[i]=stack.pop();
      i--;
    }


    return array;
  }


  static boolean oppositeSigns(int x, int y) {
    return ((x ^ y) < 0);
  }

  @Test
  public void test1() {
    int[] asteroids = {5, 10, -5};
    System.out.println(asteroidCollision(asteroids));
  }

  @Test
  public void test2() {
    int[] asteroids = {-5, -7, 15};
    System.out.println(asteroidCollision(asteroids));
  }

  @Test
  public void test3() {
    int[] asteroids = {10, 2, -5};
    System.out.println(asteroidCollision(asteroids));
  }

  //-2, -1, 1, 2

  @Test
  public void test4() {
    int[] asteroids = {-2, -1, 1, 2};
    System.out.println(asteroidCollision(asteroids));
  }


  @Test
  public void test5() {
    int[] asteroids = {8, -8};
    System.out.println(asteroidCollision(asteroids));
  }

  @Test
  public void test6() {
    int[] asteroids = {-2,1,1,-1};
    System.out.println(asteroidCollision(asteroids));
  }

}
