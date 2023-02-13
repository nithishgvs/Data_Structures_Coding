package org.nithishgvs.Practice;

import org.junit.Test;

public class WayFairTest {


  public String solution(String s) {

    String output = "";

    String[] array = s.split("\\s+");

    for (int i = 0; i < array.length; i++) {

      if (i != 2) {
        output += array[i];
      } else {
        output += array[i].toUpperCase();
      }
      output += " ";
    }

    return output.trim();

  }


  @Test
  public void test() {
    System.out.println(solution("This is Capgemini Engineering"));
  }


}
