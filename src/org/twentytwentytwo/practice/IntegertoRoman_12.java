package org.twentytwentytwo.practice;

import org.junit.Test;

public class IntegertoRoman_12 {

  public String intToRoman(int num) {

    StringBuilder stringBuilder = new StringBuilder();

    Integer[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    for (int i = numbers.length - 1; i >= 0 && num > 0; i--) {
      while (num >= numbers[i]) {
        num = num - numbers[i];
        stringBuilder.append(romans[i]);
      }
    }

    return stringBuilder.toString();

  }


  @Test
  public void test1() {
    System.out.println(intToRoman(3));
  }
}
