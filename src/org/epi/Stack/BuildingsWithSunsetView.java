package org.epi.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class BuildingsWithSunsetView {

  //Did not understand

  private static class BuildingWithHeight {

    public Integer id;
    public Integer height;

    public BuildingWithHeight(Integer id, Integer height) {
      this.id = id;
      this.height = height;
    }
  }

  public List<Integer> examineBuildingsWithSunset(Iterator<Integer> sequence) {
    int buildingIdx = 0;

    Deque<BuildingWithHeight> canditates = new ArrayDeque<>();

    while (sequence.hasNext()) {
      Integer buildingHeight = sequence.next();
      while (!canditates.isEmpty()
          && Integer.compare(buildingHeight, canditates.peekLast().height) >= 0) {
        canditates.removeLast();
      }
      canditates.addLast(new BuildingWithHeight(buildingIdx++, buildingHeight));
    }
    List<Integer> buildingsWithSunset = new ArrayList<>();

    while (!canditates.isEmpty()) {
      buildingsWithSunset.add(canditates.removeLast().id);
    }

    return buildingsWithSunset;
  }


  @Test
  public void test() {
    List<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(5);
    list.add(1);
    list.add(3);
    examineBuildingsWithSunset(list.iterator());
  }


}
