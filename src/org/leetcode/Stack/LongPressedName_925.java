package org.leetcode.Stack;

import org.junit.Test;

public class LongPressedName_925 {


  public boolean isLongPressedName(String name, String typed) {

    if (name.length() > typed.length()) {
      return false;
    }

    if (name.length() == 0 || typed.length() == 0) {
      return false;
    }

    for (int i = 0; i < name.length(); i++) {
      char ch = name.charAt(i);

      while (i + 1 < name.length() && name.charAt(i) == name.charAt(i + 1) && typed.length() > 1
          && typed.charAt(1) == ch) {
        i++;
      }

      boolean flag = false;
      if (typed.length() == 0) {
        return false;
      }
      while (typed.length() > 0) {
        if (typed.charAt(0) == ch) {
          flag = true;
          typed = typed.substring(1);
          continue;
        } else if (!flag) {
          return false;
        } else {
          break;
        }
      }
    }

    return true;
  }


  @Test
  public void pressedTest() {
    System.out.println(isLongPressedName("saeed", "ssaaedd"));
    System.out.println(isLongPressedName("alex", "aaleex"));
    System.out.println(isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
    System.out.println(isLongPressedName("leelee", "lleeelee"));
    System.out.println(isLongPressedName("vtkgn", "vttkgnn"));
  }


}
