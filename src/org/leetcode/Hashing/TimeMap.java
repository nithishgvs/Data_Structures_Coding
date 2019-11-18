package org.leetcode.Hashing;

//TimeBasedKeyValueStore_981

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

public class TimeMap {


  Map<String, TreeMap<Integer, String>> timeMap;

  public TimeMap() {
    timeMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!timeMap.containsKey(key)) {
      TreeMap<Integer, String> treeMap = new TreeMap<>();
      treeMap.put(timestamp, value);
      timeMap.put(key, treeMap);
    } else {
      timeMap.get(key).put(timestamp, value);
    }

  }

  public String get(String key, int timestamp) {
    if (timeMap.containsKey(key)) {
      TreeMap<Integer, String> treeMap = timeMap.get(key);
      Map.Entry<Integer, String> result = treeMap.floorEntry(timestamp);
      return result == null ? "" : result.getValue();
    }
    return null;
  }


  @Test
  public void test() {
    TimeMap kv = new TimeMap();
    kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
    System.out.println(kv.get("foo", 1));  // output "bar"
    System.out.println(kv.get("foo",
        3)); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
    kv.set("foo", "bar2", 4);
    System.out.println(kv.get("foo", 4)); // output "bar2"
    System.out.println(kv.get("foo", 5)); //output "bar2"
  }

  @Test
  public void test1() {
    TimeMap kv = new TimeMap();

    kv.set("love", "high", 10);
    kv.set("love", "low", 20);
    System.out.println(kv.get("love", 5));
    System.out.println(kv.get("love", 10));
    System.out.println(kv.get("love", 15));
    System.out.println(kv.get("love", 20));
    System.out.println(kv.get("love", 25));

  }
}
