package org.leetcode.Arrays;

import java.util.List;
import org.junit.Test;

public class FindAllDuplicatesInAnArray_442 {


  public List<Integer> findDuplicates(int[] nums) {


    return null;
  }


  @Test
  public void testDuplicates(){
    int[] array={4,3,2,7,8,2,3,1};
    int out=array[0];
    for(int i=1;i<array.length;i++){
      out=out^array[i];
      System.out.println(out);
      System.out.println(array[i-1]+" "+array[i]);
      System.out.println("#########");
    }


  }

}
