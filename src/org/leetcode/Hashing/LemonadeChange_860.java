package org.leetcode.Hashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LemonadeChange_860 {


  public boolean lemonadeChange(int[] bills) {
    Map<Integer, Integer> billsMap = new HashMap() {{
      put(5, 0);
      put(10, 0);
    }};

    for (int bill : bills) {
      if (bill == 5) {
        int freq = billsMap.get(5);
        billsMap.put(5, ++freq);
      } else {
        int actualBill = bill;
        int change = bill - 5;
        while (change >= 5) {
          if (change >= 10 && billsMap.get(10) > 0) {
            change -= 10;
            int freq = billsMap.get(10);
            billsMap.put(10, --freq);
          } else if (billsMap.get(5) > 0) {
            change -= 5;
            int freq = billsMap.get(5);
            billsMap.put(5, --freq);
          } else {
            return false;
          }
        }
        if (actualBill == 10) {
          int freq = billsMap.get(10);
          billsMap.put(10, ++freq);
        }
      }
    }

    return true;
  }

  @Test
  public void test() {
    int[] bills = new int[]{5, 5, 5, 10, 20};
    System.out.println(lemonadeChange(bills));
  }

  @Test
  public void test2() {
    int[] bills = new int[]{5, 5, 10, 10, 20};
    System.out.println(lemonadeChange(bills));
  }

}
