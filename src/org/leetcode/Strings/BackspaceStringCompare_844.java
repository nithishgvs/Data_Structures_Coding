package org.leetcode.Strings;

import org.junit.Test;

public class BackspaceStringCompare_844 {

  public boolean backspaceCompare(String S, String T) {
    return backspaceCompareHelper(S).equals(backspaceCompareHelper(T));
  }

  private String backspaceCompareHelper(String inputString) {
    while (inputString.contains("#")) {
      if (inputString.indexOf("#") == 0) {
        inputString = inputString.substring(1);
      } else {
        int index = inputString.indexOf("#");
        if (inputString.length() > 2) {
          inputString = inputString.substring(0, index - 1) + inputString.substring(index + 1);
        } else {
          inputString = "";
        }
      }

    }
    return inputString;
  }


  @Test
  public void test() {
    System.out.println(backspaceCompare("a##c", "#a#c"));
  }
}
