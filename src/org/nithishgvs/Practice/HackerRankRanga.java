package org.nithishgvs.Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
      if (end - start == pattern.length()-1) {
        if (currentMap.get('a') == binaryMap.get('0') && currentMap.get('b') == binaryMap.get('1')) {
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


  @Test
  public void test1() {
    Map<String,String> mapResponse=new HashMap<>();
    for (Entry<String, String> entry : mapResponse.entrySet()) {
      String k = entry.getKey();
      String v = entry.getValue();
      System.out.println(k + ":" + v);
    }
  }

  public static void main(String[] args) {
    int sum=0;
    for(int i=0,j=0;i<5 &j<5;++i,j=i+1)
      sum+=i;
    System.out.println(sum);

  }


}
