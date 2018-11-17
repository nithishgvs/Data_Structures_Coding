package org.leetcode.Graphs;

import org.junit.Test;

import java.util.*;

public class NetworkDelayTime_743 {

    public class DistanceInfo {

        private int distance;
        private int lastVertex;

        public DistanceInfo(int lastVertex, int distance) {
            this.distance = distance;
            this.lastVertex = lastVertex;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }

    }

    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<DistanceInfo> queue = new PriorityQueue<>((v1, v2) -> v1.getDistance() - v2.getDistance());
        Map<Integer, List<DistanceInfo>> distanceTable = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int time = 0;
        for (int i = 0; i < times.length; i++) {
            if (!distanceTable.containsKey(times[i][0])) {
                distanceTable.put(times[i][0], new ArrayList<>());
            }
            List<DistanceInfo> list = distanceTable.get(times[i][0]);
            list.add(new DistanceInfo(times[i][1], times[i][2]));
            distanceTable.put(times[i][0], list);
        }

        List<DistanceInfo> distanceInfoList = distanceTable.get(K);
        if (distanceInfoList != null) {
            queue.addAll(distanceInfoList);
        }
        visited.add(K);
        while (!queue.isEmpty()) {
            DistanceInfo distanceInfo = queue.poll();
            if (visited.contains(distanceInfo.getLastVertex())) {
                continue;
            }
            time = distanceInfo.distance;
            visited.add(distanceInfo.getLastVertex());
            distanceInfoList = distanceTable.get(distanceInfo.getLastVertex());
            if (distanceInfoList != null) {
                for (DistanceInfo distanceInfo1 : distanceInfoList) {
                    queue.add(new DistanceInfo(distanceInfo1.getLastVertex(), distanceInfo1.getDistance() + time));
                }
            }
        }

        return visited.size() == N ? time : -1;
    }

    @Test
    public void testNetworkDelay1() {
        int[][] times = {
                { 3, 5, 78 },
                { 2, 1, 1 },
                { 1, 3, 0 },
                { 4, 3, 59 },
                { 5, 3, 85 },
                { 5, 2, 22 },
                { 2, 4, 23 },
                { 1, 4, 43 },
                { 4, 5, 75 },
                { 5, 1, 15 },
                { 1, 5, 91 },
                { 4, 1, 16 },
                { 3, 2, 98 },
                { 3, 4, 22 },
                { 5, 4, 31 },
                { 1, 2, 0 },
                { 2, 5, 4 },
                { 4, 2, 51 },
                { 3, 1, 36 },
                { 2, 3, 59 } };
        System.out.println(networkDelayTime(times, 5, 5));
    }

    @Test
    public void testNetworkDelay2() {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        System.out.println(networkDelayTime(times, 4, 2));
    }

    @Test
    public void testNetworkDelay3() {
        int[][] times = { { 1, 2, 1 } };
        networkDelayTime(times, 2, 2);
    }

}
