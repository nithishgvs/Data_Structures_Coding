package org.leetcode.Design;


import java.util.TreeMap;
import org.junit.Test;

//DesignHitCounter_362
public class HitCounter {


  TreeMap<Integer, Integer> treeCounter;

  /**
   * Initialize your data structure here.
   */
  public HitCounter() {
    treeCounter = new TreeMap<>();
    treeCounter.put(0, 0);
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {

    if (!treeCounter.containsKey(timestamp)) {
      int nearestKey = treeCounter.floorKey(timestamp);
      treeCounter.put(timestamp, treeCounter.get(nearestKey) + 1);
    } else {
      treeCounter.put(timestamp, treeCounter.get(timestamp) + 1);
    }
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    Integer nearestKey = treeCounter.floorKey(timestamp);

    return treeCounter.get(nearestKey) - ((timestamp - 300 < 0) ? 0
        : treeCounter.floorEntry(timestamp - 300).getValue());
  }


  public static void main(String[] args) {
    HitCounter counter = new HitCounter();

// hit at timestamp 1.
    counter.hit(1);

// hit at timestamp 2.
    counter.hit(2);

// hit at timestamp 3.
    counter.hit(3);

// get hits at timestamp 4, should return 3.
    System.out.println(counter.getHits(4));

// hit at timestamp 300.
    counter.hit(300);

// get hits at timestamp 300, should return 4.
    System.out.println(counter.getHits(300));

// get hits at timestamp 301, should return 3.
    System.out.println(counter.getHits(301));
  }

  @Test
  public void test() {
    hit(2);
    hit(3);
    hit(4);
    System.out.println(getHits(300));
    System.out.println(getHits(301));
    System.out.println(getHits(302));
    System.out.println(getHits(303));
    System.out.println(getHits(304));
    hit(501);
    System.out.println(getHits(600));

  }

}
