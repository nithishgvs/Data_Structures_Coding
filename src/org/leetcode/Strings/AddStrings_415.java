package org.leetcode.Strings;

import java.math.BigInteger;
import org.junit.Test;

public class AddStrings_415 {


  public String addStrings(String num1, String num2) {
    long number1 = 0, number2 = 0;
    int j = 0;
    for (int i = num1.length() - 1; i >= 0; i--) {
      number1 += Character.getNumericValue(num1.charAt(i)) * Math.pow(10, j);
      j++;
    }
    j = 0;
    for (int i = num2.length() - 1; i >= 0; i--) {
      number2 += Character.getNumericValue(num2.charAt(i)) * Math.pow(10, j);
      j++;
    }

    return String.valueOf(number1 + number2);
  }

  public String addStrings2(String num1, String num2) {
    BigInteger n1 = new BigInteger("0");
    BigInteger n2 = new BigInteger("0");
    long number1 = 0, number2 = 0;
    int j = 0;
    for (int i = num1.length() - 1; i >= 0; i--) {
      n1.add(new BigInteger(String.valueOf(n1.abs()) + String
          .valueOf(Character.getNumericValue(num1.charAt(i)) * Math.pow(10, j))));
      j++;
    }
    j = 0;
    for (int i = num2.length() - 1; i >= 0; i--) {
      number2 += Character.getNumericValue(num2.charAt(i)) * Math.pow(10, j);
      j++;
    }

    return String.valueOf(number1 + number2);
  }

  @Test
  public void test() {
    //System.out.println(addStrings("18582506933032752", "366213329703"));
    addStrings2("9333852702227987", "85731737104263");
  }

}
