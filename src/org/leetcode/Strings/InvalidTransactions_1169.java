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

    for (Map.Entry<String, List<String>> entry : map.entrySet()) {

      if (entry.getValue().size() == 1) {
        if (Integer.valueOf(entry.getValue().get(0).split(",")[2]) > 1000) {
          invalidString.add(entry.getValue().get(0));
        }
      } else {

        List<String> list = entry.getValue();

        for (int i = 0; i < list.size(); i++) {
          if (Integer.valueOf(list.get(i).split(",")[2]) > 1000) {
            invalidString.add(list.get(i));
          }
          for (int j = 0; j < list.size(); j++) {
            if (i != j && Math.abs(Integer.valueOf(list.get(j).split(",")[1]) - Integer
                .valueOf(list.get(i).split(",")[1])) < 60 && !list.get(i).split(",")[3]
                .equals(list.get(j).split(",")[3])) {
              if (!invalidString.contains(list.get(i)) && !invalidString.contains(list.get(j))) {
                invalidString.add(list.get(i));
                invalidString.add(list.get(j));

              }
            }
          }

        }

      }
    }
    return invalidString;
  }


  @Test
  public void test() {
    String[] transactions = new String[]{"alice,20,800,mtv", "alice,50,100,beijing" };
    invalidTransactions(transactions).forEach(v -> System.out.println(v));

  }

}
