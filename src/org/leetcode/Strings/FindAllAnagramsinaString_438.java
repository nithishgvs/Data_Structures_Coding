package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FindAllAnagramsinaString_438 {

  public List<Integer> findAnagrams(String s, String p) {

    List<Integer> output = new ArrayList<>();

    Map<Character, Integer> anagramTargetMap = prepareAnagramTarget(p);

    int start = 0;
    int end = 0;

    int totalFreqsNeeded = anagramTargetMap.size();

    Map<Character, Integer> anagramSourceMap = new HashMap<>();

    int charFreqsObserved = 0;

    while (end < s.length()) {

      char c = s.charAt(end);

      populateSourceMap(anagramSourceMap, c);

      if (anagramTargetMap.containsKey(c)) {
        if (anagramSourceMap.get(c).intValue() == anagramTargetMap.get(c).intValue()) {
          charFreqsObserved++;
        }
      }
      if (charFreqsObserved == totalFreqsNeeded && end - start + 1 == p.length()) {
        output.add(start);
      }

      while (charFreqsObserved == totalFreqsNeeded && start <= end) {

        char c1 = s.charAt(start);

        anagramSourceMap.put(c1, anagramSourceMap.get(c1) - 1);

        if (anagramTargetMap.containsKey(c1)) {
          if (anagramSourceMap.get(c1).intValue() < anagramTargetMap.get(c1).intValue()) {
            charFreqsObserved--;
          }
        }
        start++;
        if (charFreqsObserved == totalFreqsNeeded && end - start + 1 == p.length()) {
          output.add(start);
        }
      }

      end++;

    }

    return output;

  }

  private void populateSourceMap(Map<Character, Integer> anagramSourceMap, char c) {

    if (!anagramSourceMap.containsKey(c)) {
      anagramSourceMap.putIfAbsent(c, 0);
    }
    anagramSourceMap.put(c, anagramSourceMap.get(c) + 1);
  }

  private Map<Character, Integer> prepareAnagramTarget(String p) {
    Map<Character, Integer> map = new HashMap<>();

    for (char c : p.toCharArray()) {
      if (!map.containsKey(c)) {
        map.putIfAbsent(c, 0);
      }
      map.put(c, map.get(c) + 1);
    }
    return map;
  }


  @Test
  public void test1() {
    findAnagrams("cbaebabacd", "abc").forEach(s -> System.out.println(s));
  }

  @Test
  public void test2() {
    findAnagrams("abaacbabc", "abc").forEach(s -> System.out.println(s));
  }

  @Test
  public void test3() {
    findAnagrams("abab", "ab").forEach(s -> System.out.println(s));
  }

}
