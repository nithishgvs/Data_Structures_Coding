package org.leetcode.Hashing;

import java.util.Arrays;

//706. Design HashMap
public class MyHashMap {

  int[] map;

  /**
   * Initialize your data structure here.
   */
  public MyHashMap() {
    map = new int[1000001];
    Arrays.fill(map, -1);
  }

  /**
   * value will always be non-negative.
   */
  public void put(int key, int value) {
    map[key] = value;
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    return map[key];
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  public void remove(int key) {
    map[key] = -1;
  }


  public static void main(String[] args) {
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1, 1); // The map is now [[1,1]]
    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
    myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
  }
}
