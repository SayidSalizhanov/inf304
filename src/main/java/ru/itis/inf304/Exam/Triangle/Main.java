package ru.itis.inf304.Exam.Triangle;

public class Main {
    public static void main(String[] args) {
        try {
            IsoscelesTriangle tr1 = new IsoscelesTriangle(new Point(3,4), new Point(1,1), new Point(5,1));
            IsoscelesTriangle tr2 = new IsoscelesTriangle(new Point(5,4), new Point(1,1), new Point(9,1));
            IsoscelesTriangle tr3 = new IsoscelesTriangle(new Point(3,4), new Point(1,1), new Point(5,1));
            IsoscelesTriangle tr4 = new IsoscelesTriangle(new Point(5,1), new Point(3,4), new Point(1,1));
            IsoscelesTriangle[] arr = {tr1, tr2, tr3, tr4};
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