package org.leetcode.Arrays;

import org.junit.Test;

public class RobotBoundedInCircle_1041 {

  public boolean isRobotBounded(String instructions) {

    int[] start = {0, 0};

    String direction = "NORTH";

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < instructions.length(); j++) {
        char ch = instructions.charAt(j);
        switch (direction) {
          case "NORTH":
            if (ch == 'L') {
              direction = "WEST";
            } else if (ch == 'R') {
              direction = "EAST";
            } else {
              start[1] += 1;
            }
            break;

          case "EAST":
            if (ch == 'L') {
              direction = "NORTH";
            } else if (ch == 'R') {
              direction = "SOUTH";
            } else {
              start[0] += 1;
            }
            break;
          case "WEST":
            if (ch == 'L') {
              direction = "SOUTH";
            } else if (ch == 'R') {
              direction = "NORTH";
            } else {
              start[0] -= 1;
            }
            break;

          case "SOUTH":
            if (ch == 'L') {
              direction = "EAST";
            } else if (ch == 'R') {
              direction = "WEST";
            } else {
              start[1] -= 1;
            }
            break;
        }

      }
      if (start[0] == 0 && start[1] == 0) {
        return true;
      }
    }

    return false;
  }

  @Test
  public void test1(){
    //System.out.println(isRobotBounded("GGLLGG"));
    //System.out.println(isRobotBounded("GG"));
    System.out.println(isRobotBounded("GL"));
  }


}
