package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FlexeSeatSelection {


  public int solution(int n, String s) {
    int families = 0;

    if(s.length()==0){
      return families;
    }

    String[] arr = s.split("\\s+");



    Map<Integer, List<Character>> map = new HashMap<>();
    for (String str : arr) {
      if (!map.containsKey(Integer.valueOf(str.substring(0,str.length()-1)))) {
        List<Character> list = new ArrayList<>();
        list.add(str.charAt(str.length()-1));
        map.put(Integer.valueOf(str.substring(0,str.length()-1)), list);
      } else {
        List<Character> list = map.get(Integer.valueOf(str.substring(0,str.length()-1)));
        list.add(str.charAt(str.length()-1));
        map.put(Integer.valueOf(str.substring(0,str.length()-1)), list);
      }
    }

    for (int i = 1; i <= n; i++) {

      if(!map.containsKey(i)){
        families=families+3;
        continue;
      }
      if (!map.get(i).contains('A') && !map.get(i).contains('B') && !map.get(i).contains('C')) {
        families++;
      }
      if (!map.get(i).contains('D') && !map.get(i).contains('E') && !map.get(i).contains('F')) {
        families++;
        List<Character> list = map.get(i);
        list.add('D');
        list.add('E');
        list.add('F');
        map.put(i, list);
      }
      if (!map.get(i).contains('E') && !map.get(i).contains('F') && !map.get(i).contains('G')) {
        families++;
      }
      if (!map.get(i).contains('H') && !map.get(i).contains('J') && !map.get(i).contains('K')) {
        families++;
      }
    }

    return families;
  }


  @Test
  public void test1() {
    System.out.println(solution(2, "1A 2F 1C"));
  }

  @Test
  public void test2() {
    System.out.println(solution(40, "1A 3C 2B 40G 5A"));
  }


}
