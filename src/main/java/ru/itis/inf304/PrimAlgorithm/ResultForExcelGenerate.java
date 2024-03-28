package ru.itis.inf304.PrimAlgorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResultForExcelGenerate {
    public static void main(String[] args) throws IOException {
        File testFile = new File("resultFile.txt");
        testFile.createNewFile();

        try {
            FileWriter writer = new FileWriter("resultFile.txt");
            for (int i = 100; i <= 1000; i += 18) {
                PrimResult[] results = Main.primAlgorythmTest(i, 100);

                long averageCountEdges = 0;
                long averageCountTimes = 0;
                long averageCountIterations = 0;

                for (PrimResult result : results) {
                    averageCountEdges += result.countEdges;
                    averageCountTimes += result.timeUsed;
                    averageCountIterations += result.numberOfIterations;
                }

                averageCountEdges /= 100;
                averageCountTimes /= 100;
                averageCountIterations /= 100;

                writer.write(i + " " + averageCountEdges + " " + averageCountTimes + " " + averageCountIterations + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
