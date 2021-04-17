package org.leetcode.UnionFind;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestConsecutiveSequence_128 {

  private int maxComponent = 0;


  public int longestConsecutive(int[] nums) {

    UnionFind unionFind = new UnionFind(nums.length);
    Map<Integer, Integer> helperMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {

      if (helperMap.containsKey(nums[i])) {
        continue;
      }

      if (helperMap.containsKey(nums[i] + 1)) {
        unionFind.unify(i, helperMap.get(nums[i] + 1));
      }
      if (helperMap.containsKey(nums[i] - 1)) {
        unionFind.unify(i, helperMap.get(nums[i] - 1));
      }
      helperMap.put(nums[i], i);
    }

    return maxComponent;

  }


  class UnionFind {

    private int size;

    // Used to track the size of each of the component
    private int[] sz;

    // id[i] points to the parent of i, if id[i] = i then i is a root node
    private int[] id;

    public UnionFind(int size) {

      if (size <= 0) {
        return;
      }

      this.size = size;
      sz = new int[size];
      id = new int[size];

      for (int i = 0; i < size; i++) {
        id[i] = i; // Link to itself (self root)
        sz[i] = 1; // Each component is originally of size one
        maxComponent=Math.max(maxComponent,sz[i]);
      }
    }

    public int find(int p) {

      // Find the root of the component/set
      int root = p;
      while (root != id[root]) {
        root = id[root];
      }

      // Compress the path leading back to the root.
      // Doing this operation is called "path compression"
      // and is what gives us amortized time complexity.
      while (p != root) {
        int next = id[p];
        id[p] = root;
        p = next;
      }

      return root;
    }
    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }

    // Unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q) {

      // These elements are already in the same group!
      if (connected(p, q)) {
        return;
      }

      int root1 = find(p);
      int root2 = find(q);

      // Merge smaller component/set into the larger one.
      if (sz[root1] < sz[root2]) {
        sz[root2] += sz[root1];
        id[root1] = root2;
        maxComponent = Math.max(maxComponent, sz[root2]);
      } else {
        sz[root1] += sz[root2];
        id[root2] = root1;
        maxComponent = Math.max(maxComponent, sz[root1]);
      }
    }
  }


  @Test
  public void test1() {
    System.out.println(longestConsecutive(new int[]{}));
  }
}
