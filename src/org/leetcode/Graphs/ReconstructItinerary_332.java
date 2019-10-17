package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class ReconstructItinerary_332 {


  public List<String> findItinerary(List<List<String>> tickets) {
    List<String> itenary = new LinkedList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    for (List<String> tikt : tickets) {
      if (!map.containsKey(tikt.get(0))) {
        map.put(tikt.get(0), new PriorityQueue<>((v1, v2) -> v1.compareTo(v2)));
      }
      map.get(tikt.get(0)).add(tikt.get(1));
    }

    helper("JFK", map, itenary);

    return itenary;
  }

  private void helper(String target, Map<String, PriorityQueue<String>> map,
      List<String> itenary) {

    while (map.containsKey(target) && map.get(target).size() > 0) {
      PriorityQueue<String> priorityQueue = map.get(target);
      String dest = priorityQueue.poll();
      helper(dest, map, itenary);
    }
    itenary.add(0,target);

  }


  @Test
  public void test() {
    System.out.println("LGA".compareTo("LGB"));
    List<String> list1 = new ArrayList<>();
    list1.add("JFK");
    list1.add("SFO");
    List<String> list2 = new ArrayList<>();
    list2.add("JFK");
    list2.add("ATL");
    List<String> list3 = new ArrayList<>();
    list3.add("SFO");
    list3.add("ATL");
    List<String> list4 = new ArrayList<>();
    list4.add("ATL");
    list4.add("JFK");
    List<String> list5 = new ArrayList<>();
    list5.add("ATL");
    list5.add("SFO");
    List<List<String>> tickets = new ArrayList<>();
    tickets.add(list1);
    tickets.add(list2);
    tickets.add(list3);
    tickets.add(list4);
    tickets.add(list5);
    findItinerary(tickets).forEach(v -> System.out.println(v));

  }

  @Test
  public void test1() {
    System.out.println("LGA".compareTo("LGB"));
    List<String> list1 = new ArrayList<>();
    list1.add("JFK");
    list1.add("KUL");
    List<String> list2 = new ArrayList<>();
    list2.add("JFK");
    list2.add("NRT");
    List<String> list3 = new ArrayList<>();
    list3.add("NRT");
    list3.add("JFK");
//    List<String> list4 = new ArrayList<>();
//    list4.add("ATL");
//    list4.add("JFK");
//    List<String> list5 = new ArrayList<>();
//    list5.add("ATL");
//    list5.add("SFO");
    List<List<String>> tickets = new ArrayList<>();
    tickets.add(list1);
    tickets.add(list2);
    tickets.add(list3);
//    tickets.add(list4);
//    tickets.add(list5);
    findItinerary(tickets).forEach(v -> System.out.println(v));

  }


  @Test
  public void test2() {
    findItinerary(listMethod()).forEach(v -> System.out.println(v));
  }

  public List<List<String>> listMethod() {
    List<List<String>> mainArray = new ArrayList<>();
    String[][] array = new String[][]{{"EZE", "TIA"}, {"EZE", "HBA"}, {"AXA", "TIA"},
        {"JFK", "AXA"}, {"ANU", "JFK"}, {"ADL", "ANU"}, {"TIA", "AUA"}, {"ANU", "AUA"},
        {"ADL", "EZE"}, {"ADL", "EZE"}, {"EZE", "ADL"}, {"AXA", "EZE"}, {"AUA", "AXA"},
        {"JFK", "AXA"}, {"AXA", "AUA"}, {"AUA", "ADL"}, {"ANU", "EZE"}, {"TIA", "ADL"},
        {"EZE", "ANU"}, {"AUA", "ANU"}};
    for (String[] a : array) {
      List<String> sub = new ArrayList<>();
      sub.add(a[0]);
      sub.add(a[1]);
      mainArray.add(sub);
    }
    return mainArray;
  }

}
