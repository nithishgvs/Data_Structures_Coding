package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class DivisorGame_1025 {


  public boolean divisorGame1(int N) {
    int A = 0, B = 0;
    boolean boolA = false; //Making sure alice starts the game
    while (0 < 1 && 1 < N) {
      N -= 1;
      if (!boolA) { //is it alice's turn?
        A++;
        boolA = !boolA; //Alice just played, now next turn is for bob
      } else {
        B++;
        boolA = !boolA; //Bob just played, now next turn is for Alice
      }
    }
    return A > B; //If Alice has played more than bob
  }

  public boolean divisorGame(int N) {

    int aliceCount = 0;
    int bobCount = 0;
    boolean flag = true;

    while (N > 1) {
      if (flag) {
        N = N - 1;
        aliceCount++;
        flag = !flag;
      } else {
        N = N - 1;
        bobCount++;
        flag = !flag;
      }
    }

    return aliceCount > bobCount;
  }


  @Test
  public void test1() {

    System.out.println(divisorGame1(15));
  }
}
