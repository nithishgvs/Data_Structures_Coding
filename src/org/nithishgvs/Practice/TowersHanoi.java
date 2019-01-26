package org.nithishgvs.Practice;

import org.junit.Test;

public class TowersHanoi {


  public void solveHanoi(int n, char fromRod, char middleRod, char toRod) {
    if (n == 1) {
      System.out.println("Plate 1 from " + fromRod + " to " + toRod);
      return;
    }
    //Move n-1 plates from fromRod to middleRod using toRod
    solveHanoi(n - 1, fromRod, toRod, middleRod);

    System.out.println("Plate " + n + " from " + fromRod + " to " + toRod);

    //Move n-1 plates from middleRod to toRod using fromRod
    solveHanoi(n - 1, middleRod, fromRod, toRod);

  }

  @Test
  public void testHanoi() {
    solveHanoi(3, 'A', 'B', 'C');
  }


}
