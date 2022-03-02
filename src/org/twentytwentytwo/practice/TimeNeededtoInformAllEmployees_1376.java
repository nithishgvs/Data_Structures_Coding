package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededtoInformAllEmployees_1376 {

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

    Map<Integer, List<Integer>> managerMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      managerMap.put(i, new ArrayList<>());
    }

    for (int i = 0; i < manager.length; i++) {
      if (i != headID) {
        List<Integer> subs = managerMap.get(manager[i]);
        subs.add(i);
      }
    }

    return helper(headID, managerMap, informTime);

  }


  private int helper(int headID, Map<Integer, List<Integer>> managerMap, int[] informTime) {
    int min = Integer.MIN_VALUE;

    List<Integer> subordinates = managerMap.get(headID);

    for (Integer sub : subordinates) {
      min = Math.max(min, helper(sub, managerMap, informTime));
    }

    return min == Integer.MIN_VALUE ? informTime[headID] : min + informTime[headID];
  }

}
