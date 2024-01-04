package ru.itis.inf304.Exam.Parallelogram;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Parallelogram p1 = new Parallelogram(new Point(1,1), new Point(3,4), new Point(9,4), new Point(7,1));
            Parallelogram p2 = new Parallelogram(new Point(1,1), new Point(3,4), new Point(9,4), new Point(7,1));
            Parallelogram p3 = new Parallelogram(new Point(1,1), new Point(3,4), new Point(9,4), new Point(7,1));
            Parallelogram[] arr1 = {p1, p2, p3};
            Parallelogram[] arr2 = {p1, p2};
            System.out.println(equality(arr2));
        }
        catch (FigureIsNotParallelogramException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double generalSquare(Parallelogram[] arr) {
        double s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i].square();
        }
        return s;
    }

    public static boolean equality(Parallelogram[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) count++;
                if (count > 1) return false;
            }
        }
        return (count != 0);
    }
}