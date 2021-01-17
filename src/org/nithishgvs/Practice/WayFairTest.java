package org.nithishgvs.Practice;

import org.junit.Test;

public class WayFairTest {


  public String solution(String s) {

    String output = "";

    s = s.replaceAll("[^0-9]", "");

    int cut = 0;

    for (int i = 0; i < s.length(); i++) {
      if (cut == 2 && i == s.length() - 2) {
        cut = 0;
        output = output + "-" + s.charAt(i);
        continue;
      }
      output = output + s.charAt(i);
      cut++;
      if (cut == 3 && i!=s.length()-1) {
        output = output + "-";
        cut = 0;
      }
    }

    return output;

  }


  @Test
  public void test() {
    System.out.println(solution("00-44 48 5555 8361"));
    System.out.println(solution("0 - 22 1985--324"));
    System.out.println(solution("5553726541"));
  }


}
