package org.practice.io.BackTracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Combinations_77 {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combinations = new ArrayList<>();
    if (k > n) {
      return combinations;
    }
    generateAllCombinations(1, n, k, new ArrayList<>(), combinations);
    return combinations;
  }

  private void generateAllCombinations(int i, int n, int k, ArrayList<Integer> currentList,
      List<List<Integer>> combinations) {
    if (k == 0) {
      combinations.add(new ArrayList<>(currentList));
      return;
    }

    for (int x = i; x <= n; x++) {
      currentList.add(x);
      generateAllCombinations(x + 1, n, k - 1, currentList, combinations);
      currentList.remove(currentList.size() - 1);
    }
  }


  @Test
  public void test() {
    combine(4, 2);
  }

}
