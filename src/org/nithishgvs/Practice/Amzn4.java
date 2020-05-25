package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Amzn4 {


  public List<String> reorderLines(int lofFileSize, List<String> logs) {

    if (logs.size() == 0 || logs.size() == 1) {
      return logs;
    }

    Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String s, String t1) {
        String[] charArray1 = s.split("\\s+");
        String[] charArray2 = t1.split("\\s+");

        if (Character.isDigit(charArray1[1].charAt(0)) && !Character
            .isDigit(charArray2[1].charAt(0))) {
          return 1;
        } else if (!Character.isDigit(charArray1[1].charAt(0)) && Character
            .isDigit(charArray2[1].charAt(0))) {
          return -1;
        } else if (!Character.isDigit(charArray1[1].charAt(0)) && !Character
            .isDigit(charArray2[1].charAt(0))) {
          //Both Characters
          int size = Math.min(charArray1.length, charArray2.length);
          for (int i = 1; i < size; i++) {
            if (charArray1[i].equals(charArray2[i])) {
              continue;
            } else {
              return charArray1[i].compareTo(charArray2[i]);
            }
          }
          return charArray1[0].compareTo(charArray2[0]);
        }

        return 0;
      }
    };

    Collections.sort(logs, comparator);

    return logs;

  }


  @Test
  public void test() {
    List<String> logs = new ArrayList<>();
    logs.add(new String("a1 9 2 3 1"));
    logs.add(new String("g1 act car"));
    logs.add(new String("zo4 4 7"));
    //logs.add(new String("ab1 off key dog"));
    //logs.add(new String("a8 act zoo"));

    List<String> output = reorderLines(5, logs);
    System.out.println(output);
  }


  @Test
  public void test2() {
    List<String> logs = new ArrayList<>();
    logs.add(new String("a1 9 2 3 1"));
    logs.add(new String("g1 act car"));
    logs.add(new String("zo4 4 7"));
    logs.add(new String("ab1 off key dog"));
    logs.add(new String("a8 act zoo"));

    List<String> output = reorderLines(5, logs);
    System.out.println(output);
  }


}
