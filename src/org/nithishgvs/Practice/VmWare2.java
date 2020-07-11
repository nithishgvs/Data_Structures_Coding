package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VmWare2 {

  public static List<Integer> cutBamboo(List<Integer> lengths) {

    lengths.forEach(v -> System.out.println(v));

    List<Integer> output = new ArrayList<>();

    cutBambooHelper(output, lengths);

    return output;

  }

  private static void cutBambooHelper(List<Integer> output, List<Integer> lengths) {
    if (lengths.size() == 0) {
      return;
    }

    output.add(lengths.size());

    Collections.sort(lengths);

    int min = lengths.get(0);

    List<Integer> subList = new ArrayList<>();
    for (int val : lengths) {
      int newVal = val - min;
      if (newVal != 0) {
        subList.add(newVal);
      }
    }
    cutBambooHelper(output, subList);
  }

  public static int gcdValue(int num1, int num2) {

    int gcd = 1;

    for (int i = 1; i <= num1 && i <= num2; i++) {
      if (num1 % i == 0 && num2 % i == 0) {
        gcd = i;
      }
    }

    return gcd;

  }


  public static List<String> ReduceFraction(List<String> fractions) {
    // Write your code here
    List<String> output = new ArrayList<>();
    for (String val : fractions) {
      StringBuilder stringBuilder = new StringBuilder();
      int upper = Integer.parseInt(val.substring(0, val.indexOf("/")));
      int lower = Integer.parseInt(val.substring(val.indexOf("/") + 1));
      int gcd = gcdValue(upper, lower);
      stringBuilder.append(upper / gcd).append("/").append(lower / gcd);
      output.add(stringBuilder.toString());
    }
    return output;
  }


}
