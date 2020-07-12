package org.leetcode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class KillProcess_582 {

  Map<Integer, List<Integer>> processMap = new HashMap<>();

  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < ppid.size(); i++) {
      if (ppid.get(i) != 0) {
        List<Integer> subChildren = processMap.getOrDefault(ppid.get(i), new ArrayList<>());
        subChildren.add(pid.get(i));
        processMap.put(ppid.get(i), subChildren);
      }
    }

    if (processMap.containsKey(kill)) {
      recursiveDependencies(processMap.get(kill), result, kill);
    } else {
      result.add(kill);
    }

    return result;
  }

  private void recursiveDependencies(List<Integer> processList, List<Integer> result,
      int kill) {
    result.add(kill);
    if (processMap.isEmpty()) {
      return;
    }
    for (Integer process : processList) {
      recursiveDependencies(processMap.getOrDefault(process, new ArrayList<>()), result, process);
    }
  }


  @Test
  public void test() {
    List<Integer> pid = Arrays.asList(1, 3, 10, 5);
    List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
    killProcess(pid, ppid, 5);
  }


  @Test
  public void test1() {
    List<Integer> pid = Arrays.asList(1, 2, 3);
    List<Integer> ppid = Arrays.asList(0, 1, 1);
    killProcess(pid, ppid, 2);
  }
}
