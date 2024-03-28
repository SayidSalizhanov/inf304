package ru.itis.inf304.PrimAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class OtherTest {
    public static void main(String[] args) {
        int v = 5; // Number of vertices
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(1, 2, 3));

        new Graph(v, edges).primMST().print();
    }
}
