package org.leetcode.Graphs;

import org.junit.Test;

import java.util.*;

//My function returns the exisitng pair not the last vertex as per the question asked, therefore named it partial

public class RedundantConnectionPartial_684 {

    int[] redundant = new int[2];
    Map<Integer, List<Integer>> graphMap = new LinkedHashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> greySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> list = null;
            if (!graphMap.containsKey(edges[i][0])) {
                list = new ArrayList<>();
                list.add(edges[i][1]);
                graphMap.put(edges[i][0], list);
            } else {
                list = graphMap.get(edges[i][0]);
                list.add(edges[i][1]);
                graphMap.put(edges[i][0], list);
            }
        }
        for (Integer key : graphMap.keySet()) {
            redundantConnectionHelper(key, greySet, blackSet);
        }

        return redundant;
    }

    private void redundantConnectionHelper(int vertex, Set<Integer> greySet, Set<Integer> blackSet) {
        greySet.add(vertex);
        List<Integer> adjacentVertices = graphMap.get(vertex);
        if (adjacentVertices != null) {
            for (int i = 0; i < adjacentVertices.size(); i++) {
                if (blackSet.contains(adjacentVertices.get(i))) {
                    redundant[0] = vertex;
                    redundant[1] = adjacentVertices.get(i);
                }
                redundantConnectionHelper(adjacentVertices.get(i), greySet, blackSet);
            }
        }
        blackSet.add(vertex);
    }

    @Test
    public void testRedundantConnection() {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        findRedundantConnection(edges);
        System.out.println(redundant[0]+"  "+redundant[1]);
    }

    @Test
    public void testRedundantConnection1() {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        findRedundantConnection(edges);
        System.out.println(redundant[0]+"  "+redundant[1]);
    }

}
