package ru.itis.inf304.Exam.Triangle;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            IsoscelesTriangle tr1 = new IsoscelesTriangle(2,2,3);
            IsoscelesTriangle tr2 = new IsoscelesTriangle(4,5,5);
            IsoscelesTriangle tr3 = new IsoscelesTriangle(5,5,9);
            IsoscelesTriangle tr4 = new IsoscelesTriangle(1,1,1);
            IsoscelesTriangle tr5 = new IsoscelesTriangle(1,1,1);
            System.out.println(tr1.perimetr());
            System.out.println(tr2.square());
            System.out.println(tr3.equals(tr4));
            System.out.println(Arrays.toString(tr4.triangleAngles()));
            System.out.println(tr5.toString());
            IsoscelesTriangle[] arr = {tr1, tr2, tr3, tr4, tr5};
            System.out.println(generalPerimetr(arr));
            System.out.println(equality(arr));
        }
        catch (TriangleNotIsoscelesException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double generalPerimetr(IsoscelesTriangle[] array) {
        double p = 0;
        for (int i = 0; i < array.length; i++) {
            p += array[i].perimetr();
        }
        return p;
    }

    public static boolean equality(IsoscelesTriangle[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) return true;
            }
        }
        return false;
    }
}
