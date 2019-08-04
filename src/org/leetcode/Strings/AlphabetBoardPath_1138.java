package org.leetcode.Strings;

import org.junit.Test;

public class AlphabetBoardPath_1138 {

  public String alphabetBoardPath(String target) {

    StringBuilder sb = new StringBuilder();

    int row = 0, col = 0, rowDes = 0, colDes = 0;

    for (char c : target.toCharArray()) {

      rowDes = ((int) c - 97) / 5;
      colDes = ((int) c - 97) % 5;

      while (true) {
        if (row < rowDes) {
          while (row == 4 && col > 0) {
            col--;
            sb.append("L");
          }
          row++;
          sb.append("D");
        } else if (row > rowDes) {
          sb.append("U");
          row--;
        } else if (col < colDes) {
          if (row == 5) {
            row--;
            sb.append("U");
          }
          col++;
          sb.append("R");
        } else if (col > colDes) {
          col--;
          sb.append("L");
        } else {
          sb.append("!");
          break;
        }

      }

    }

    return sb.toString();
  }


  @Test
  public void test1() {
    //System.out.println(alphabetBoardPath("code"));
    //System.out.println(alphabetBoardPath("leet"));
    System.out.println(alphabetBoardPath("zdz"));
  }
}
