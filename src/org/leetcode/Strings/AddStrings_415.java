package org.leetcode.Strings;

import org.junit.Test;

public class AddStrings_415 {


  public String addStrings(String num1, String num2) {

    String output = "";

    int i = num1.length() - 1, j = num2.length() - 1;
    int carry = 0;

    int sum = 0;

    while (i >= 0 || j >= 0 || carry > 0) {

      if (i >= 0) {
        sum += Character.getNumericValue(num1.charAt(i));
      }

      if (j >= 0) {
        sum += Character.getNumericValue(num2.charAt(j));
      }

      if (carry > 0) {
        sum += carry;
      }



      carry = sum / 10;
      output = sum % 10 + output;
      sum=0;

      i--;
      j--;
    }

    return output;
  }


  @Test
  public void test() {
    //System.out.println(addStrings("18582506933032752", "366213329703"));
    System.out.println(addStrings("9333852702227987", "85731737104263"));
    //System.out.println(addStrings("228", "222"));
  }

}
