package org.twentytwentytwo.practice;

import java.util.Stack;

public class BuildingsWithanOceanView_1762 {

  public int[] findBuildings(int[] heights) {

    Stack<Integer> stack = new Stack<>();

    for (int i = heights.length - 1; i > -1; i--) {
      int height = heights[i];
      if (stack.isEmpty()) {
        stack.add(i);
      } else if (heights[stack.peek()] < height) {
        stack.add(i);
      }
    }

    int[] heightArray = new int[stack.size()];

    for (int i = 0; i < heightArray.length; i++) {
      heightArray[i] = stack.pop();
    }

    return heightArray;
  }

}
