package org.nithishgvs.Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class HackerRankRanga {


  public int binaryPatternMatching(String pattern, String s) {
    int matches = 0;
    List<Character> alphabets = Arrays.asList('a', 'e', 'i', 'o', 'u');
    Map<Character, Integer> binaryMap = extractBinaryMap(pattern);

    int start = 0;

    int end = 0;

    Map<Character, Integer> currentMap = new HashMap<>();
    //all vowels this
    currentMap.put('a', 0);
    //all consonents this
    currentMap.put('b', 0);

    while (end <= s.length() - pattern.length()) {
      char ch = s.charAt(end);
      if (alphabets.contains(ch)) {
        currentMap.put('a', currentMap.get('a') + 1);
      } else {
        currentMap.put('b', currentMap.get('b') + 1);
      }
      if (end - start == pattern.length() - 1) {
        if (currentMap.get('a') == binaryMap.get('0') && currentMap.get('b') == binaryMap
            .get('1')) {
          matches++;
        }
        if (alphabets.contains(s.charAt(start))) {
          currentMap.put('a', currentMap.get('a') - 1);
        } else {
          currentMap.put('b', currentMap.get('b') - 1);
        }
        start++;
      }
      end++;
    }

    return matches;
  }


  private Map<Character, Integer> extractBinaryMap(String pattern) {
    Map<Character, Integer> binaryMap = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      if (binaryMap.containsKey(ch)) {
        binaryMap.put(ch, binaryMap.get(ch) + 1);
      } else {
        binaryMap.put(ch, 1);
      }
    }

    return binaryMap;
  }

  public String solution(String S, String C) {
    // write your code in Java SE 8
    Set<String> values = new HashSet<>();
    String[] splitArray = S.split(";");

    StringBuilder mainBuilder = new StringBuilder();

    for (int i = 0; i < splitArray.length; i++) {
      String current = splitArray[i];
      String[] newSplit = current.trim().split("\\s+");
      StringBuilder sb = new StringBuilder();
      int counter = 2;

      if (newSplit.length == 2) {
        sb.append(newSplit[0].toLowerCase()).append(".");
        String last = newSplit[1].replaceAll("-", "");
        if (last.length() > 8) {
          last = last.substring(0, 7);
        }
        sb.append(last.toLowerCase());
      } else {
        sb.append(newSplit[0].toLowerCase()).append(".");
        String last = newSplit[2].replaceAll("-", "");
        if (last.length() > 8) {
          last = last.substring(0, 8);
        }
        sb.append(last.toLowerCase());
      }

      String valueCurrent = sb.toString();
      while (!values.isEmpty()&& values.contains(valueCurrent)) {

        char lastChar=valueCurrent.charAt(valueCurrent.length()-1);

        if(Character.isDigit(lastChar)){
          valueCurrent=valueCurrent.substring(0,valueCurrent.length()-1);
        }
        valueCurrent = valueCurrent + counter;
        counter++;
      }
      values.add(valueCurrent);

      mainBuilder.append(valueCurrent).append("@").append(C.toLowerCase()).append(".com").append("; ");


    }

    return mainBuilder.toString().substring(0, mainBuilder.lastIndexOf(";"));
  }


  @Test
  public void test() {
    String av="aaa";
    System.out.println(av.substring(0,av.length()-1));
    String response= solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker","Example");
    System.out.println(response);

  }

}
