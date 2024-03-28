package ru.itis.inf304.PrimAlgorithm;

import java.util.*;

// класс графа
public class Graph {
    private final int vertexesCount; // количество вершин
    private final List<Edge> edges; // множество ребер

    Graph(int vertexesCount, List<Edge> edges) {
        this.vertexesCount = vertexesCount;
        this.edges = edges;
    }

    static List<Edge>[] fillAdjacencyList(int V, List<Edge> allEdges) {
        List<Edge>[] adjList = new List[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (Edge edge : allEdges) {
            adjList[edge.v1].add(edge);
        }

        return adjList;
    }

    PrimResult primMST() {

        long before = System.currentTimeMillis();
        int countIterations = 0;

        List<Edge>[] adjList = fillAdjacencyList(vertexesCount, edges);
        countIterations+= edges.size() + vertexesCount;

        boolean[] inMST = new boolean[vertexesCount];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        List<Edge> mstEdges = new ArrayList<>();

        // добавим любой произвольный узел
        int source = 0;
        inMST[source] = true;
        pq.addAll(adjList[source]);

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (inMST[edge.v2]) continue;

            inMST[edge.v2] = true;
            mstEdges.add(new Edge(edge.v1, edge.v2, edge.weight));

            for (Edge nextEdge : adjList[edge.v2]) {
                if (!inMST[nextEdge.v2]) {
                    pq.add(nextEdge);
                }
                countIterations++;
            }
        }

        long after = System.currentTimeMillis();

        return new PrimResult(new Graph(vertexesCount, mstEdges), vertexesCount, edges.size(), after - before, countIterations);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexesCount=" + vertexesCount +
                ", edges=" + edges + "}";
    }

    public List<Edge> getEdges() {
        return edges;
    }
    public static Graph generateGraphs(int countVert) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < countVert - 1; i++) {
            int countEdges = customRandom(1, countVert - i);
            Set<Integer> vertex = new HashSet<>();
            for (int j = 0; j < countEdges; j++) {
                int addVertex = customRandom(i + 1, countVert);
                vertex.add(addVertex);
            }
            for (Integer num : vertex) {
                int weight = customRandom(1, 10);
                edges.add(new Edge(i, num, weight));
            }
        }
        return new Graph(countVert, edges);
    }

    public static int customRandom(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

}