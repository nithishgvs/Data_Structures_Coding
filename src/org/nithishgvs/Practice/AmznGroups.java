package org.nithishgvs.Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AmznGroups {


  public static long findHealth(List<Integer> power, int armor) {

    int max = Collections.max(power);

    armor = Math.min(armor, max);

    int sum = power.stream().reduce(0, (x, y) -> x + y);

    return sum - (armor) - 1;
  }

  public static int minGroups(List<Integer> awards, int k) {

    Collections.sort(awards);

    int result = 0;

    for (int i = 0; i < awards.size(); i++) {

      int current = awards.get(i);

      while (i < awards.size() && awards.get(i) <= current + k) {
        i++;
      }
      i--;
      result = result + 1;
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 5, 4, 6, 8, 9, 2);
    System.out.println(minGroups(list, 3));
  }


}
