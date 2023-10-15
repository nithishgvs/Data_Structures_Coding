package org.leetcode.SearchingSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class RankTeamsByVotes_1366_2 {

  public String rankTeams(String[] votes) {
    Map<Character, int[]> map = new HashMap<>();

    for (String vote : votes) {
      for (int i = 0; i < vote.length(); i++) {
        char character = vote.charAt(i);
        int[] freqArray = map.getOrDefault(character, new int[26]);
        freqArray[i]++;
        map.put(character, freqArray);
      }
    }

    List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());

    Collections.sort(list, (a, b) -> {
      for (int i = 0; i < 26; i++) {
        if (a.getValue()[i] != b.getValue()[i]) {
          return b.getValue()[i] - a.getValue()[i];
        }
      }
      return a.getKey() - b.getKey();
    });

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      stringBuilder.append(list.get(i).getKey());
    }
    return stringBuilder.toString();

  }

  @Test
  public void test() {
    String[] votes = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};
    rankTeams(votes);
  }
}
