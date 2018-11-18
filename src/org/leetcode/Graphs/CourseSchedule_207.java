package org.leetcode.Graphs;

import org.junit.Test;

import java.util.*;

public class CourseSchedule_207 {

    Map<Integer, List<Integer>> graphMap = new LinkedHashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> greySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = null;
            if (!graphMap.containsKey(prerequisites[i][0])) {
                list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                graphMap.put(prerequisites[i][0], list);
            } else {
                list = graphMap.get(prerequisites[i][0]);
                list.add(prerequisites[i][1]);
                graphMap.put(prerequisites[i][0], list);
            }
        }

        for (Integer key : graphMap.keySet()) {
            if (courseScheduleHelper(key, greySet, blackSet)) {
                return false;
            }
        }

        return true;
    }

    private boolean courseScheduleHelper(Integer vertex, Set<Integer> greySet, Set<Integer> blackSet) {
        greySet.add(vertex);
        blackSet.add(vertex);
        List<Integer> adjacentVertices = graphMap.get(vertex);
        if (adjacentVertices != null) {
            for (int i = 0; i < adjacentVertices.size(); i++) {
                if (!greySet.contains(adjacentVertices.get(i)))
                    courseScheduleHelper(adjacentVertices.get(i), greySet, blackSet);
                if (blackSet.contains(adjacentVertices.get(i)))
                    return true;
            }
        }
        blackSet.remove(vertex);
        return false;
    }

    @Test
    public void testCourseFinish1() {
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(canFinish(2, prerequisites));
    }

    @Test
    public void testCourseFinish2() {
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
        System.out.println(canFinish(2, prerequisites));
    }

    @Test
    public void testCourseFinish3() {
        int[][] prerequisites = {{1,0},{2,6},{1,7},{6,4},{7,0}};
        System.out.println(canFinish(2, prerequisites));
    }

}
