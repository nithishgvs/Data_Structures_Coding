package org.lcfresh.practice;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PartitionLabels_763 {


  public List<Integer> partitionLabels(String s) {

    List<Integer> result = new ArrayList<>();

    int[] lastIndices = new int[26];

    for (int i = 0; i < s.length(); i++) {
      lastIndices[s.charAt(i) - 'a'] = i;
    }

    int start = 0, end=0;
    for (int i = 0; i < s.length(); i++) {
      end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
      if (end == i) {
        result.add(end - start + 1);
        start = end + 1;
      }

    }

    return result;

  }

  @Test
  public void testPartition() {
    System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    //System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
  }
}
