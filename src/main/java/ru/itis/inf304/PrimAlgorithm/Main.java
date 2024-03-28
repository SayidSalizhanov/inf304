package ru.itis.inf304.PrimAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static PrimResult[] primAlgorythmTest(int countVertexes, int countTest) throws IOException {
        TestGenerator.testGenerate(countVertexes, countTest);

        PrimResult[] results = new PrimResult[countTest];

        try {
            FileReader fr = new FileReader("testFile.txt");
            BufferedReader reader = new BufferedReader(fr);
            for (int i = 0; i < countTest; i++) {
                reader.readLine();

                //создаем данные для графа
                List<Edge> edges = new ArrayList<>();

                // создаем ребра
                String[] line1 = reader.readLine().split(" ");
                String[] line2 = reader.readLine().split(" ");
                String[] line3 = reader.readLine().split(" ");

                for (int j = 0; j < line1.length; j++) {
                    edges.add(new Edge(Integer.parseInt(line1[j]), Integer.parseInt(line2[j]), Integer.parseInt(line3[j])));
                }

                results[i] = new Graph(countVertexes, edges).primMST();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }
}
