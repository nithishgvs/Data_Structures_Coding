package org.leetcode.Graphs;

import org.junit.Test;

import java.util.*;

public class FindEventualSafeStates_802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodeList = new ArrayList<>();
        Set<Integer> greySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();
        for (int currentVertex = 0; currentVertex < graph.length; currentVertex++) {
            if (!hasCycle(graph, greySet, blackSet, currentVertex)) {
                safeNodeList.add(currentVertex);
            }
        }
        Collections.sort(safeNodeList);
        return safeNodeList;
    }

    private boolean hasCycle(int[][] graph, Set<Integer> greySet, Set<Integer> blackSet, int currentVertex) {
        int[] ints = graph[currentVertex];
        greySet.add(currentVertex);
        for (int j = 0; j < ints.length; j++) {
            if (blackSet.contains(ints[j]))
                continue;
            if (greySet.contains(ints[j]))
                return true;
            if (hasCycle(graph, greySet, blackSet, ints[j])) {
                return true;
            }
        }
        blackSet.add(currentVertex);
        return false;
    }

    @Test
    public void testSafeStates() {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        List<Integer> safeNodeList = eventualSafeNodes(graph);
        safeNodeList.forEach(System.out::println);
    }

    @Test
    public void testSafeStates1() {
        int[][] graph = { {}, { 0, 2, 3, 4 }, { 3 }, { 4 }, {} };
        List<Integer> safeNodeList = eventualSafeNodes(graph);
        safeNodeList.forEach(System.out::println);
    }
}
