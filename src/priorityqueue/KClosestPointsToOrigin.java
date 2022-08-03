package priorityqueue;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];

            priorityQueue.offer(new int[]{distance, point[0], point[1]});
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[][] closestPoints = new int[k][2];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            int[] pointCandidate = priorityQueue.poll();
            closestPoints[index][0] = pointCandidate[1];
            closestPoints[index++][1] = pointCandidate[2];
        }

        return closestPoints;
    }
}
