package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DestinationCity_1436 {

  public String destCity(List<List<String>> paths) {
    if(paths.size()<0){
      return "";
    }


    Map<String, List<String>> map = new HashMap<>();

    Set<String> set = new HashSet<>();

    for (List<String> path : paths) {
      String key = path.get(0);
      String value = path.get(1);
      List<String> dest = map.getOrDefault(key, new ArrayList<>());
      dest.add(value);
      set.add(key);
      set.add(value);
      map.put(key, dest);
    }

    set.removeAll(map.keySet());

    List<String> list = new ArrayList<>();
    list.addAll(set);


    return list.get(0);
  }
}
