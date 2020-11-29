package org.nithishgvs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.Test;

public class TestAmazon {


  public class Locations {

    int x;
    int y;

    public Locations(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Locations locations = (Locations) o;
      return x == locations.x &&
          y == locations.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }


  @Test
  public void testLocations() {
    Locations l1 = new Locations(1, -1);
    Locations l2 = new Locations(1, 2);
    Locations l3 = new Locations(3, 4);
    ArrayList<Locations> asList = new ArrayList<>();
    asList.add(l1);
    asList.add(l2);
    asList.add(l3);
    findCorrectOrder(3, asList, 2);
  }

  @Test
  public void testLocations2() {
    Locations l1 = new Locations(1, -3);
    Locations l2 = new Locations(1, 2);
    Locations l3 = new Locations(3, 4);
    ArrayList<Locations> asList = new ArrayList<>();
    asList.add(l1);
    asList.add(l2);
    asList.add(l3);
    findCorrectOrder(3, asList, 1);
  }

  @Test
  public void testLocations3() {
    List l1 = Arrays.asList(3, 6);
    List l2 = Arrays.asList(2, 4);
    List l3 = Arrays.asList(5, 3);
    List l4 = Arrays.asList(2, 7);
    List l5 = Arrays.asList(1, 8);
    List l6 = Arrays.asList(7, 9);
    ArrayList<List<Integer>> asList = new ArrayList<>();
    asList.add(l1);
    asList.add(l2);
    asList.add(l3);
    asList.add(l4);
    asList.add(l5);
    asList.add(l6);
    findCorrectOrder2(6, asList, 3);
  }

  private ArrayList<Locations> findCorrectOrder(int destinations, List<Locations> asList,
      int deliveries) {
    Locations first = findShortest(asList, new Locations(0, 0));
    asList.remove(new Locations(first.x, first.y));
    ArrayList<Locations> outputList = new ArrayList<>();
    outputList.add(first);
    int count = 1;
    Locations source = new Locations(0, 0);
    while (count < deliveries) {
      Locations nextShort = findShortest(asList, source);
      outputList.add(nextShort);
      asList.remove(new Locations(nextShort.x, nextShort.y));
      count++;
    }
    return outputList;
  }

  private List<List<Integer>> findCorrectOrder2(int destinations, List<List<Integer>> asList,
      int deliveries) {
    List<Integer> first = findShortest2(asList, Arrays.asList(0, 0));
    asList.remove(first);
    List<List<Integer>> outputList = new ArrayList<>();
    outputList.add(first);
    int count = 1;
    List<Integer> source = Arrays.asList(0, 0);
    while (count < deliveries) {
      List<Integer> nextShort = findShortest2(asList, source);
      outputList.add(nextShort);
      asList.remove(nextShort);
      count++;
    }
    return outputList;
  }

  private List<Integer> findShortest2(List<List<Integer>> asList, List<Integer> source) {
    double min = Integer.MAX_VALUE;
    List<Integer> loc = null;

    for (List<Integer> entry : asList) {
      double localmin = getDistance2(entry, source);
      if (localmin < min) {
        loc = Arrays.asList(entry.get(0), entry.get(1));
        min = localmin;
      }
    }
    return loc;
  }

  private double getDistance2(List<Integer> entry, List<Integer> source) {
    return Math.sqrt(
        Math.pow((entry.get(0) - source.get(0)), 2) + Math.pow(entry.get(1) - source.get(1), 2));
  }

  private Locations findShortest(List<Locations> asList, Locations locations) {

    double min = Integer.MAX_VALUE;
    Locations loc = null;

    for (Locations l : asList) {
      double localMin = getDistance(locations, l);
      if (localMin < min) {
        loc = new Locations(l.x, l.y);
        min = localMin;
      }
    }
    return loc;
  }

  private double getDistance(Locations locations, Locations l) {
    return Math.sqrt(Math.pow((l.x - locations.x), 2) + Math.pow(l.y - locations.y, 2));
  }


}
