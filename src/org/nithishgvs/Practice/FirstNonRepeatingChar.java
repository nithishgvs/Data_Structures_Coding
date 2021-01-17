package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class FirstNonRepeatingChar {


  public Character firstNonRepeating(String string) {

    int[] charArray = new int[26];

    for (char ch : string.toCharArray()) {
      charArray[ch - 'a']++;
    }

    for (int i = 0; i < string.length(); i++) {
      if(charArray[string.charAt(i)-'a']==1){
        return string.charAt(i);
      }
    }
    return '\0';
  }

  //@Test
  public void test1(){
    System.out.println(firstNonRepeating("swiss"));
  }

 // @Test
  public void test2(){
    List<Integer> list1 = new ArrayList<>();
    list1.add(2);
    list1.add(3);
    list1.add(5);
    list1.add(7);
    list1.add(27);
    list1.add(1);
    list1.add(6);
    List<Integer> list2 = new ArrayList<>();
    list2.add(8);
    list2.add(55);
    list2.add(77);
    list2.add(5);
    list2.add(9);
    list2.add(6);
    list2.add(1);
    List<Integer> result = list1.stream()
        .distinct()
        .filter(list2::contains)
        .collect(Collectors.toList());
    Collections.sort(result, Comparator.reverseOrder());
    System.out.println(result);
  }


  public static void main(String[] args) {

  }

  public int missingNumber(int[] nums) {
    int l = nums.length;
    int total = ((l + 1)*l) / 2;
    int obtainedSum = 0;
    for (int i = 0; i < l; i++) {
      obtainedSum = obtainedSum+ nums[i];
    }
    return total - obtainedSum;
  }

  @Test
  public void test3(){
    int[] arr={3,0,1};
    System.out.println(missingNumber(arr));
  }

}
