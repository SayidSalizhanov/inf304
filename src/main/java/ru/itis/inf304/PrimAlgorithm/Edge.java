package ru.itis.inf304.PrimAlgorithm;

// класс ребра в графе
public class Edge {
    Integer v1; // первая вершина ребра
    Integer v2; // вторая вершина ребра
    Integer weight; // вес ребра

    Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" + v1 +
                "," + v2 +
                "}=" + weight;
    }
}
