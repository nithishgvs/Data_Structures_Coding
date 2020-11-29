package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class InvalidTransactions_1169 {

  public List<String> invalidTransactions(String[] transactions) {

    List<String> invalidString = new ArrayList<>();

    Map<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < transactions.length; i++) {
      String[] entry = transactions[i].split(",");
      if (!map.containsKey(entry[0])) {
        map.put(entry[0], new ArrayList<>());
      }
      map.get(entry[0]).add(transactions[i]);
    }

    for (String transaction : transactions) {

      String[] cut = transaction.split(",");

      if (Integer.valueOf(cut[2]) > 1000) {
        invalidString.add(transaction);
        continue;
      }
      List<String> entries = map.get(cut[0]);
      for (String entry : entries) {
        if (!entry.equals(transaction)) {
          String[] entryCut = entry.split(",");
          if (!entryCut[3].equals(cut[3])
              && Math.abs(Integer.valueOf(cut[1]) - Integer.valueOf(entryCut[1])) <= 60) {
            invalidString.add(transaction);
            break;
          }
        }
      }

    }

    return invalidString;
  }


  @Test
  public void test() {
    String[] transactions = new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"};
    invalidTransactions(transactions).forEach(v -> System.out.println(v));

  }

  @Test
  public void test1() {
    String[] transactions = new String[]{"bob,689,1910,barcelona", "alex,696,122,bangkok",
        "bob,832,1726,barcelona", "bob,820,596,bangkok", "chalicefy,217,669,barcelona",
        "bob,175,221,amsterdam"};
    invalidTransactions(transactions).forEach(v -> System.out.println(v));

  }
}
