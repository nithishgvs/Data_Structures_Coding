package org.leetcode.Hashing;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/online-election/description/?envType=list&envId=o5bqn4w1 911.
 * Online Election
 */
public class TopVotedCandidate {

  private Comparator<Entry<Integer, CandidateData>> entryComparator;

  class CandidateData {

    int count;
    int lastTime;

    public CandidateData(int count, int lastTime) {
      this.count = count;
      this.lastTime = lastTime;
    }
  }


  TreeMap<Integer, Integer> topVotedMap = new TreeMap<>();

  Map<Integer, CandidateData> candidateDataMap = new HashMap<>();

  public TopVotedCandidate(int[] persons, int[] times) {

    for (int i = 0; i < persons.length; i++) {
      int time = times[i];
      int person = persons[i];
      CandidateData candidateData = candidateDataMap
          .getOrDefault(person, new CandidateData(0, 0));
      candidateData.count += 1;
      candidateData.lastTime = time;
      candidateDataMap.put(person, candidateData);
      //Top Voted Map should have the entry with the top voted at the moment
      updateTopVotedMap(time);
    }

  }

  private void updateTopVotedMap(int time) {
    entryComparator = (o1, o2) -> {
      if (o1.getValue().count == o2.getValue().count) {
        return o1.getValue().lastTime - o2.getValue().lastTime;
      }
      return o1.getValue().count > o2.getValue().count ? 1 : -1;
    };
    int key = Collections.max(
        candidateDataMap.entrySet(),
        entryComparator).getKey();
    topVotedMap.put(time, key);
  }

  public int q(int t) {
    return topVotedMap.get(topVotedMap.floorKey(t));
  }


  public static void main(String[] args) {
    int[] persons = new int[]{0, 0, 0, 0, 1};
    int[] times = new int[]{0, 6, 39, 52, 75};
    TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
    System.out.println(topVotedCandidate.q(45));
    System.out.println(topVotedCandidate.q(49));
    System.out.println(topVotedCandidate.q(59));
    System.out.println(topVotedCandidate.q(68));
    System.out.println(topVotedCandidate.q(42));
    System.out.println(topVotedCandidate.q(37));

    System.out.println(topVotedCandidate.q(99));
    System.out.println(topVotedCandidate.q(26));
    System.out.println(topVotedCandidate.q(78));
    System.out.println(topVotedCandidate.q(43));
  }

}
