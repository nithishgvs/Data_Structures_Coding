package org.leetcode.Hashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class N_RepeatedElement_961 {

  public int repeatedNTimes(int[] A) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < A.length; i++) {
      if (!map.containsKey(A[i])) {
        map.put(A[i], 1);
      } else {
        if ((map.get(A[i]) + 1) == A.length / 2) {
          return A[i];
        }
        map.put(A[i], map.get(A[i]) + 1);

      }
    }

    return -1;


  }


  @Test
  public void testRepeated(){
    int[] A={5,1,5,2,5,3,5,4};
    System.out.println(repeatedNTimes(A));
  }


}
