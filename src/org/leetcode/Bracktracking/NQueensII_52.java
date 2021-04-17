package org.leetcode.Bracktracking;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class NQueensII_52 {

  public int totalNQueens(int n) {
    AtomicInteger results = new AtomicInteger(0);
    generateNQueens(0, n, new ArrayList<>(), results);
    return results.get();
  }


  private void generateNQueens(int row, int n, ArrayList<Integer> colPlacements,
      AtomicInteger results) {

    //base case
    if (row == n) {
      results.set(results.get() + 1);
      return;
    }

    for (int col = 0; col < n; col++) {
      colPlacements.add(col);

      if (isValid(colPlacements)) {
        generateNQueens(row + 1, n, colPlacements, results);
      }
      colPlacements.remove(colPlacements.size() - 1);
    }

  }

  private boolean isValid(ArrayList<Integer> colPlacements) {

    int currentRow = colPlacements.size() - 1;

    for (int ithQueenRow = 0; ithQueenRow < currentRow; ithQueenRow++) {
      int absoluteColumnDistance = Math
          .abs(colPlacements.get(ithQueenRow) - colPlacements.get(currentRow));

      int rowDistance = currentRow - ithQueenRow;

      if (absoluteColumnDistance == 0 || rowDistance == absoluteColumnDistance) {
        return false;
      }
    }

    return true;
  }

  @Test
  public void test1() {
    System.out.println(totalNQueens(4));
  }

}
