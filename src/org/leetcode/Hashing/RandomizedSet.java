package org.leetcode.Hashing;

//InsertDeleteGetRandomO(1)_380

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.Test;

public class RandomizedSet {

  /**
   * Initialize your data structure here.
   */
  Map<Integer, Object> randomMap;
  List<Integer> randomList;

  public RandomizedSet() {
    randomList = new ArrayList<>();
    randomMap = new HashMap<>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (!randomMap.containsKey(val)) {
      randomMap.put(val, null);
      randomList.add(val);
      return true;
    }
    return false;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {

    if (randomMap.containsKey(val)) {
      randomMap.remove(val);
      randomList.remove(new Integer(val));
      return true;
    }

    return false;
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    Random rand = new Random();
    return randomList.get(rand.nextInt(randomList.size()));
  }


  @Test
  public void test1() {
    // Init an empty set.
    RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
    randomSet.insert(1);

// Returns false as 2 does not exist in the set.
    randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
    randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
    System.out.println(randomSet.getRandom());

// Removes 1 from the set, returns true. Set now contains [2].
    randomSet.remove(1);

// 2 was already in the set, so return false.
    randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
    System.out.println(randomSet.getRandom());
  }

}
