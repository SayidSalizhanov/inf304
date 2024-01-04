package ru.itis.inf304.Exam.Parallelogram;

import java.util.Objects;

public class Parallelogram {

    public Point p1;
    public Point p2;
    public Point p3;
    public Point p4;
    public double a;
    public double b;
    public double c;
    public double d;

    public Parallelogram(Point p1, Point p2, Point p3, Point p4) throws FigureIsNotParallelogramException {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;

        a = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
        b = Math.sqrt((p3.x - p2.x) * (p3.x - p2.x) + (p3.y - p2.y) * (p3.y - p2.y));
        c = Math.sqrt((p3.x - p4.x) * (p3.x - p4.x) + (p3.y - p4.y) * (p3.y - p4.y));
        d = Math.sqrt((p1.x - p4.x) * (p1.x - p4.x) + (p1.y - p4.y) * (p1.y - p4.y));

        if (!(a == c && b == d)) throw new FigureIsNotParallelogramException();
    }

    public Parallelogram(Point p1, Point p2, Point p3, Point p4, double a, double b, double c, double d) throws FigureIsNotParallelogramException {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        if (!(a == c && b == d)) throw new FigureIsNotParallelogramException();
    }

    public double perimetr() {
        return a + b + c + d;
    }

    public double square() {
        double diagonalP2P4 = Math.sqrt((p2.x - p4.x) * (p2.x - p4.x) + (p2.y - p4.y) * (p2.y - p4.y));
        return a * d * Math.sin(Math.acos((a * a + d * d - diagonalP2P4 * diagonalP2P4) / (2 * a * d)));
    }

    @Override
    public boolean equals(Object o) {

        double diagonalP2P4 = Math.sqrt((p2.x - p4.x) * (p2.x - p4.x) + (p2.y - p4.y) * (p2.y - p4.y));
        double angleP1 = Math.acos((a * a + d * d - diagonalP2P4 * diagonalP2P4) / (2 * a * d));



        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parallelogram that = (Parallelogram) o;
        double oDiagonalP2P4 = Math.sqrt((that.p2.x - that.p4.x) * (that.p2.x - that.p4.x) + (that.p2.y - that.p4.y) * (that.p2.y - that.p4.y));
        double oAngleP1 = Math.acos((that.a * that.a + that.d * that.d - oDiagonalP2P4 * oDiagonalP2P4) / (2 * that.a * that.d));

        return (a == that.a && d == that.d && angleP1 == oAngleP1);
    }

    public double[] parallelogramAngles() {
        double[] angles = new double[4];
        double diagonalP1P3 = Math.sqrt((p1.x - p3.x) * (p1.x - p3.x) + (p1.y - p3.y) * (p1.y - p3.y));
        double diagonalP2P4 = Math.sqrt((p2.x - p4.x) * (p2.x - p4.x) + (p2.y - p4.y) * (p2.y - p4.y));
        angles[0] = Math.acos((a * a + d * d - diagonalP2P4 * diagonalP2P4) / (2 * a * d));
        angles[1] = Math.acos((a * a + b * b - diagonalP1P3 * diagonalP1P3) / (2 * a * b));
        angles[2] = angles[0];
        angles[3] = angles[1];
        return angles;
    }

    @Override
    public String toString() {
        return "Parallelogram {" +
                "p1=(" + p1.x + ',' + p1.y +
                "), p2=(" + p2.x + ',' + p2.y +
                "), p3=(" + p3.x + ',' + p3.y +
                "), p4=(" + p4.x + ',' + p4.y +
                ")}";
    }
}

class Point{
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class FigureIsNotParallelogramException extends Exception {
    public FigureIsNotParallelogramException() {
        super("Введенные данные не могут быть параллелограмом");
    }
}