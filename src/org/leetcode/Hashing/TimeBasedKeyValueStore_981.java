package org.leetcode.Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {


  Map<String, TreeMap<Integer, String>> timeBasesKVMap;

  public TimeBasedKeyValueStore_981() {
    timeBasesKVMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!timeBasesKVMap.containsKey(key)) {
      TreeMap<Integer, String> treeMap = new TreeMap<>();
      treeMap.put(timestamp, value);
      timeBasesKVMap.put(key, treeMap);
    } else {
      TreeMap<Integer, String> treeMap = timeBasesKVMap.get(key);
      treeMap.put(timestamp, value);
      timeBasesKVMap.put(key, treeMap);
    }
  }

  public String get(String key, int timestamp) {
    if (timeBasesKVMap.containsKey(key)) {
      TreeMap<Integer, String> treeMap = timeBasesKVMap.get(key);
      Integer floorKey = treeMap.floorKey(timestamp);
      return floorKey == null ? "" : treeMap.get(floorKey);
    }
    return "";
  }
}
