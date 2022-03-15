package org.twentytwentytwo.practice;

import org.junit.Test;

public class ReverseWordsinaString_151 {

  public String reverseWords(String s) {

    String[] arrayString = s.trim().split("\\s+");

    int l = 0;
    int h = arrayString.length - 1;

    while (l < h) {
      String temp = arrayString[l];
      arrayString[l] = arrayString[h];
      arrayString[h] = temp;
      l++;
      h--;
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (String string : arrayString) {
      stringBuilder.append(string).append(" ");
    }

    return stringBuilder.toString().trim();
  }


  @Test
  public void test1() {
    System.out.println(reverseWords(" the sky is "));
  }

}
