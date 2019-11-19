package org.leetcode.StackandQueue;

import java.util.Stack;
import org.junit.Test;

public class TrappingRainWater_42 {


  public class StackElement {

    int currentVal;
    int currentMax;
    int index;

    public StackElement(int currentVal, int currentMax, int index) {
      this.currentVal = currentVal;
      this.currentMax = currentMax;
      this.index = index;
    }
  }


  public int trap(int[] height) {

    int water = 0;

    Stack<StackElement> stack = new Stack<>();

    for (int i = 1; i < height.length; i++) {

      if (stack.isEmpty()) {
        stack.add(new StackElement(height[i], height[i], i));
        continue;
      }

      if (height[i] != 0) {

        if (stack.peek().currentMax <= height[i]) {
          while (!stack.isEmpty() && stack.peek().currentMax <= height[i]) {
            StackElement popped = stack.pop();
            water += Math.min(height[i], popped.currentVal) * i - popped.index;
          }
          stack.add(new StackElement(height[i], height[i], i));
        } else {
          stack.add(new StackElement(height[i], Math.max(height[i], stack.peek().currentMax), i));
        }
      }
    }

    return water;
  }


  @Test
  public void test1() {
    System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
}
