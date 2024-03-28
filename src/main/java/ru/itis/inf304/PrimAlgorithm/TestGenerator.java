package ru.itis.inf304.PrimAlgorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestGenerator {

    public static void testGenerate(int countVertexes, int countTest) throws IOException {
        File testFile = new File("testFile.txt");
        testFile.createNewFile();

        try {
            FileWriter writer = new FileWriter("testFile.txt");
            for (int i = 0; i < countTest; i++) {

                /*
                запись одного графа будет в файле в виде 4 строк:
                1) количество вершин
                2) вершина первая у ребра (здесь их будет множество)
                3) вершина вторая у ребра (здесь их будет множество)
                4) вес ребра (здесь из будет множество)
                то есть одно ребро будет считываться с элементов из столбца, а не из строки
                 */

                Graph graph = Graph.generateGraphs(countVertexes);

                List<Integer> firstVertexes = new ArrayList<>();
                List<Integer> secondVertexes = new ArrayList<>();
                List<Integer> weights = new ArrayList<>();

                for (Edge edge : graph.getEdges()) {
                    firstVertexes.add(edge.v1);
                    secondVertexes.add(edge.v2);
                    weights.add(edge.weight);
                }

                writer.write(countVertexes + "\n");
                for (Integer firstVertex : firstVertexes) writer.write(firstVertex + " ");
                writer.write("\n");
                for (Integer secondVertex : secondVertexes) writer.write(secondVertex + " ");
                writer.write("\n");
                for (Integer weight : weights) writer.write(weight + " ");
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}