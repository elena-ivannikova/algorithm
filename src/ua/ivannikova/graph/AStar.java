package ua.ivannikova.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar {

    public static void searchPath(Graph graph, Point start, Point target) {

        Queue<Point> queue = new PriorityQueue<>(new Point.PointComparator());
        start.setPriority(0);
        queue.offer(start);
        Map<Point, Point> toFromMap = new HashMap<>();
        Map<Point, Integer> expectedLengthMap = new HashMap<>();
        toFromMap.put(start, null);
        expectedLengthMap.put(start, 0);

        while (queue.size() > 0) {

            Point current = queue.poll();
            if (current.equals(target)) {
                break;
            }

            for (Point next : graph.neighbours(current)) {
                Integer newLength = expectedLengthMap.get(current) + graph.length(current, next); // length to next neighbour
                if (!expectedLengthMap.containsKey(next) || newLength < expectedLengthMap.get(next)) {
                    expectedLengthMap.put(next, newLength);
                    Integer priority = newLength + graph.length(target, next);
                    next.setPriority(priority);
                    queue.offer(next);
                    toFromMap.put(next, current);
                }
            }
        }

        printPath(start, target, toFromMap);
    }

    private static void printPath(Point start, Point target, Map<Point, Point> toFromMap) {
        System.out.println("Shortest path (in reverse order):");
        Point currentPoint = target;
        while (toFromMap.containsKey(start)) {
            System.out.println(currentPoint);
            Point nextPoint = toFromMap.get(currentPoint);
            toFromMap.remove(currentPoint);
            currentPoint = nextPoint;
        }
    }
}
