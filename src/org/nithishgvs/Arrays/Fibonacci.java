package org.nithishgvs.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

  int[] fibonacci = new int[0];

  public int func(int n) {
    int value = 0;
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (fibonacci[n] != 0) {
      return fibonacci[n];
    } else {
      value = func(n - 1) + func(n - 2);
      fibonacci[n] = value;
      return value;
    }


  }

  List<Integer> list = null;

  public int func2(int n) {
    if (list == null) {
      list = new ArrayList<>();
      list.add(0, 0);
      list.add(1, 1);
    }
    int value = 0;
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (n < list.size()) {
      return list.get(n);
    } else {
      value = func2(n - 1) + func2(n - 2);
      list.add(n, value);
      return value;
    }
  }

  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci();
    System.out.println(fibonacci.func2(10));
    System.out.println(fibonacci.func2(3));
  }

}
