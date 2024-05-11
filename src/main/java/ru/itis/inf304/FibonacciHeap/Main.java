package ru.itis.inf304.FibonacciHeap;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static FileWriter insertWriter;
    static FileWriter findWriter;
    static FileWriter deleteWriter;
    static Random random = new Random();

    static {
        try {
            insertWriter = new FileWriter("FibonacciHeapResults/inserts.txt");
            findWriter = new FileWriter("FibonacciHeapResults/search.txt");
            deleteWriter = new FileWriter("FibonacciHeapResults/deletes.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // создание кучи
        FibonacciHeap fibHeap = new FibonacciHeap();

        // storage, temp нужны для получения средних значений
        List<TimeAndNumOfOperations> storage = new ArrayList<>(10000);
        TimeAndNumOfOperations temp;

        // создание массива чисел
        int[] arrayOfNumbers = randomArrayGenerator(10000);

        // добавление чисел в кучу
        for (int i : arrayOfNumbers) {
            temp = fibHeap.insertWithTimeAndOperations(i);
            storage.add(temp);
            try {
                insertWrite(temp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // поиск среднего значения добавления, очищение хранилища
        TimeAndNumOfOperations averageInsert = TimeAndNumOfOperations.averageValues(storage);
        storage.clear();

        // поиск минимального элемента (результат и является средним значением)
        TimeAndNumOfOperations averageFind = fibHeap.getMinWithTimeAndOperations();
        try {
            findWrite(averageFind);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // многократное удаление минимального элемента
        for (int i = 0; i < 1000; i++) {
            temp = fibHeap.extractMinWithTimeAndOperations();
            storage.add(temp);
            try {
                deleteWrite(temp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // поиск среднего значения удаления
        TimeAndNumOfOperations averageDelete = TimeAndNumOfOperations.averageValues(storage);
        storage.clear();

        System.out.println("Вставка:\n" + averageInsert + "\n\n"
                + "Поиск минимума:\n" + averageFind + "\n\n"
                + "Извлечение минимума:\n" + averageDelete);

        // закрытие всех FileWriter
        try {
            insertWriter.close();
            findWriter.close();
            deleteWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertWrite(TimeAndNumOfOperations result) throws IOException {
        insertWriter.write(result.toString() + "\n");
    }

    public static void findWrite(TimeAndNumOfOperations result) throws IOException {
        findWriter.write(result.toString() + "\n");
    }

    public static void deleteWrite(TimeAndNumOfOperations result) throws IOException {
        deleteWriter.write(result.toString() + "\n");
    }

    public static int[] randomArrayGenerator(int length) {
        int[] randomArray = new int[length];

        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt();
        }

        return randomArray;
    }
}
