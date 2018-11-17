package org.leetcode.Graphs;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class KeysAndRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer i : rooms.get(0)) {
            queue.add(i);
        }
        visited.add(0);
        while (!queue.isEmpty()) {
            Integer room = queue.poll();
            if (visited.contains(room))
                continue;
            for (Integer room1 : rooms.get(room)) {
                queue.add(room1);
            }
            visited.add(room);
            System.out.println("Polled Element: " + room);
        }
        return visited.size()==rooms.size();
    }

    @Test
    public void testRooms1() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        List<Integer> list4 = new ArrayList<>();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        System.out.println(canVisitAllRooms(rooms));

    }

    @Test
    public void testRooms() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        System.out.println(canVisitAllRooms(rooms));

    }
}
