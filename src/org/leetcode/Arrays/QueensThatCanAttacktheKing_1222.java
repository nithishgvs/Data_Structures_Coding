package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class QueensThatCanAttacktheKing_1222 {

  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    List<List<Integer>> result = new ArrayList<>();

    return result;
  }


  @Test
  public void test() {
    int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
    int[] king = {0, 0};
    System.out.println(queensAttacktheKing(queens, king));
  }

}
