package org.leetcode.Hashing;

import java.util.Arrays;

//DesignHashSet_706
public class MyHashSet {


  int[] map;
  /** Initialize your data structure here. */
  public MyHashSet() {
    map = new int[1000001];
    Arrays.fill(map, -1);
  }

  public void add(int key) {
    map[key] = key;
  }

  public void remove(int key) {
     map[key]=-1;
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
   if(map[key]!=-1){
     return true;
   }
    return false;
  }


  public static void main(String[] args) {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1);      // set = [1]
    myHashSet.add(2);      // set = [1, 2]
    System.out.println(myHashSet.contains(1)); // return True
    System.out.println(myHashSet.contains(3)); // return False, (not found)
    myHashSet.add(2);      // set = [1, 2]
    System.out.println(myHashSet.contains(2)); // return True
    myHashSet.remove(2);   // set = [1]
    System.out.println(myHashSet.contains(2));// return False, (already removed)
  }
}
