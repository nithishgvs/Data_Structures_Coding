package org.seanparshad.practice;

import org.junit.Test;

public class FruitIntoBaskets_904 {

  public int totalFruit(int[] fruits) {

    if (fruits.length == 0) {
      return 0;
    }

    int max = 0;
    int lastFruit = 0;
    int secondLastFruit = -1;
    int start = 1;

    int currentIndex = 0;
    while (start < fruits.length) {
      if (fruits[start] != fruits[lastFruit]) {
        if (secondLastFruit == -1) {
          max = Math.max(max, start - currentIndex + 1);
        } else if (fruits[start] == fruits[secondLastFruit]) {
          max = Math.max(max, start - currentIndex + 1);
        } else {
          currentIndex = secondLastFruit + 1;
          max = Math.max(max, start - currentIndex + 1);
        }
        secondLastFruit = lastFruit;

      } else {
        if (secondLastFruit != -1) {
          max = Math.max(max, start - currentIndex + 1);
        }
      }
      lastFruit = start;
      start++;
    }

    return secondLastFruit == -1 ? fruits.length : max;
  }

  @Test
  public void test1() {
    int[] fruits = {0};
    System.out.println(totalFruit(fruits));
  }

}
