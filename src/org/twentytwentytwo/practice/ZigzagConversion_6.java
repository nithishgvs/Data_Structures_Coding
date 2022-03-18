package org.twentytwentytwo.practice;

import org.junit.Test;

public class ZigzagConversion_6 {


  public String convert(String s, int numRows) {

    StringBuilder[] stringBuilders = new StringBuilder[numRows];

    for (int i = 0; i < numRows; i++) {
      stringBuilders[i] = new StringBuilder();
    }

    int index = 0;
    int n = s.length();

    while (index < s.length()) {

      for (int i = 0; i < numRows && index < n; i++) {
        stringBuilders[i].append(s.charAt(index++));
      }

      for (int j = numRows - 2; j > 0 && index < n; j--) {
        stringBuilders[j].append(s.charAt(index++));
      }
    }
    StringBuilder stringBuilder = stringBuilders[0];

    for (int i = 1; i < numRows; i++) {
      stringBuilder.append(stringBuilders[i].toString());
    }

    return stringBuilder.toString();
  }


  @Test
  public void test1() {
    System.out.println(convert("PAYPALISHIRING", 3));
  }
}
