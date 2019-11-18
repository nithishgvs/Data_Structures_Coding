package org.leetcode.Arrays;

import org.junit.Test;

public class CountPrimes_204 {

  public int countPrimes(int n) {
    int primes = 0;

    if (n <= 2) {
      return 0;
    }

    if (n == 3) {
      return 1;
    }

    for (int i = 5; i <= n/2; i++) {
      if(i%2==0){
        continue;
      }
      if (isPrime(i)) {
        System.out.println(i);
        primes++;
      }
    }

    return primes + 2;

  }


  private boolean isPrime(int number) {

    if ((number + 1) % 6 == 0 || (number - 1) % 6 == 0) {
      return true;
    }
    return false;
  }


  @Test
  public void test1() {
    System.out.println(countPrimes(10000));
  }


}
