package ua.ivannikova;

import ua.ivannikova.graph.AStar;
import ua.ivannikova.graph.Graph;
import ua.ivannikova.graph.Point;

public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);
        Point p4 = new Point(2, 3);
        Point p5 = new Point(3, 1);
        Point p6 = new Point(4, 4);

        Graph g = new Graph();
        g.graph.put(p1, new Point[]{p2, p3});
        g.graph.put(p2, new Point[]{p1, p3, p4});
        g.graph.put(p3, new Point[]{p1, p2, p4, p5, p6});
        g.graph.put(p4, new Point[]{p2, p3, p5, p6});
        g.graph.put(p5, new Point[]{p3, p4, p6});
        g.graph.put(p6, new Point[]{p3, p4, p5});

        AStar.searchPath(g, p3, p6);
    }
}
