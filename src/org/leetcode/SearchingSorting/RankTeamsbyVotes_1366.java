package org.leetcode.SearchingSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RankTeamsbyVotes_1366 {

  public String rankTeams(String[] votes) {
    Map<Character, int[]> map = new HashMap<>();

    for (String vote : votes) {
      for (int i = 0; i < vote.length(); i++) {
        char ch = vote.charAt(i);
        int[] current = map.getOrDefault(ch, new int[26]);
        current[i]++;
        map.put(ch, current);
      }
    }

    List<Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());

    Collections.sort(list, (a, b) -> {
      for (int i = 0; i < 26; i++) {
        if (b.getValue()[i] != a.getValue()[i]) {
          return b.getValue()[i] - a.getValue()[i];
        }
      }
      return a.getKey().compareTo(b.getKey());
    });

    StringBuilder result = new StringBuilder(list.size());
    for (int i = 0; i < list.size(); i++) {
      result.append(list.get(i).getKey());
    }

    return result.toString();
  }

}
