package ua.ivannikova.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    public Map<Point, Point[]> graph = new HashMap<>();

    public int length(Point p1, Point p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    public Point[] neighbours(Point current) {
        return graph.get(current);
    }
}

