package org.leetcode.SlidingWindowTechnique;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class FindKLengthSubstringsWithNoRepeatedCharacters_1100 {

  public int numKLenSubstrNoRepeats(String S, int K) {

    int count = 0;

    if (S.length() < K) {
      return count;
    }

    int start = 0, end = 0;

    Map<Character, Integer> freqMap = new LinkedHashMap<>();

    while (end < S.length()) {

      updateMap(S.charAt(end), freqMap, true);

      if (end - start + 1 == K) {
        if (start > 0) {
          updateMap(S.charAt(start - 1), freqMap, false);
        }

        if (mapFreqsCheck(freqMap)) {
          count++;
        }
        start++;
      }

      end++;
    }

    return count;
  }

  private boolean mapFreqsCheck(Map<Character, Integer> freqMap) {

    for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
      if (entry.getValue() == 1) {
        continue;
      } else {
        return false;
      }
    }

    return true;
  }

  private void updateMap(char charAt, Map<Character, Integer> freqMap, boolean increment) {
    int freq = freqMap.getOrDefault(charAt, 0);
    if (increment) {
      freqMap.put(charAt, freq + 1);
    } else {
      if (freq > 1) {
        freqMap.put(charAt, freq - 1);
      } else {
        freqMap.remove(charAt);
      }
    }

  }


  @Test
  public void test1() {
    System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));
  }
}
