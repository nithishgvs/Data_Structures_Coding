package org.lcfresh.practice;

import java.util.Arrays;
import org.junit.Test;

public class CountPrimes_204 {


  public int countPrimes(int n) {

    if (n <= 1) {
      return 0;
    }
    int result = 0;

    boolean[] isPrime = new boolean[n];

    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 0; i < n; i++) {
      if (isPrime[i]) {
        for (int j = i + i; j < n; j = j + i) {
          isPrime[j] = false;
        }
        result++;
      }
    }
    return result;
  }

  @Test
  public void test1() {
    System.out.println(countPrimes(10));
  }
}
