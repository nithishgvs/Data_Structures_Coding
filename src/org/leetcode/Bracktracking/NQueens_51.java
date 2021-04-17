package org.leetcode.Bracktracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class NQueens_51 {

  public List<List<String>> solveNQueens(int n) {

    List<List<String>> results = new ArrayList<>();

    generateNQueens(0, n, new ArrayList<>(), results);
    return results;

  }

  private void generateNQueens(int row, int n, ArrayList<Integer> colPlacements,
      List<List<String>> results) {

    //base case
    if (row == n) {
      results.add(generateBoardPlacements(colPlacements, n));
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

  private List<String> generateBoardPlacements(ArrayList<Integer> colPlacements, int n) {
    List<String> board = new ArrayList<>();
    for (int row = 0; row < colPlacements.size(); row++) {

      StringBuilder stringBuilder = new StringBuilder();

      for (int col = 0; col < colPlacements.size(); col++) {
        if (colPlacements.get(row) == col) {
          stringBuilder.append("Q");
        } else {
          stringBuilder.append(".");
        }
      }
      board.add(stringBuilder.toString());
    }

    return board;
  }


  @Test
  public void test1() {
    System.out.println(solveNQueens(1));
  }

}
