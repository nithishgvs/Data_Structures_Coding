package org.leetcode.Greedy;

import java.util.PriorityQueue;
import org.junit.Test;

public class LongestHappyString_1405 {


  class HelperClass {

    char ch;
    int value;

    public HelperClass(char ch, int value) {
      this.ch = ch;
      this.value = value;
    }
  }

  public String longestDiverseString(int a, int b, int c) {
    StringBuilder stringBuilder = new StringBuilder();

    PriorityQueue<HelperClass> priorityQueue = new PriorityQueue<>(
        (o1, o2) -> o2.value - o1.value);
    priorityQueue.add(new HelperClass('a', a));
    priorityQueue.add(new HelperClass('b', b));
    priorityQueue.add(new HelperClass('c', c));

    while (!priorityQueue.isEmpty()) {
      HelperClass currMax = priorityQueue.poll();

      char ch = currMax.ch;
      if (adjacentLastTwoCharsMatch(stringBuilder, ch)) {
        if (priorityQueue.isEmpty()) {
          break;
        }
        HelperClass newMax = priorityQueue.poll();
        appendToBuilder(stringBuilder, newMax);
        if (newMax.value > 0) {
          priorityQueue.add(newMax);
        }
        priorityQueue.add(currMax);
      } else {
        appendToBuilder(stringBuilder, currMax);
        if (currMax.value > 0) {
          priorityQueue.add(currMax);
        }
      }

    }

    return stringBuilder.toString();

  }

  private void appendToBuilder(StringBuilder stringBuilder, HelperClass newMax) {
    if (newMax.value > 0) {
      stringBuilder.append(newMax.ch);
      newMax.value--;
    }
  }

  private boolean adjacentLastTwoCharsMatch(StringBuilder stringBuilder, char ch) {
    String string = stringBuilder.toString();
    if (string.length() >= 2 && string.charAt(string.length() - 1) == ch
        && string.charAt(string.length() - 2) == ch) {
      return true;
    }
    return false;
  }

  @Test
  public void test1(){
    System.out.println(longestDiverseString(0,8,11));
  }


}
