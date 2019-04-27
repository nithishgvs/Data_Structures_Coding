package org.leetcode.Stack;

import org.junit.Test;

public class LongPressedName_925 {


  public boolean isLongPressedName(String name, String typed) {
    char temp = '\0';
    for (int i = 0; i < typed.length(); i++) {
      if (temp == typed.charAt(i)) {
        if (i == typed.length() - 1 && typed.charAt(typed.length() - 1) == name
            .charAt(name.length() - 1)) {
          if (name.substring(name.length() - 2).equals(typed.substring(typed.length() - 2))) {
            continue;
          } else {
            typed = typed.substring(0, i) + " " + typed.substring(i + 1);
          }
        }
        typed = typed.substring(0, i) + " " + typed.substring(i + 1);
        temp = '\0';
      } else {
        temp = typed.charAt(i);
      }
    }

    return typed.replaceAll(" ", "").equals(name);
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
