package ru.itis.inf304.Exam.Triangle;

public class IsoscelesTriangle {

    public Point p1;
    public Point p2;
    public Point p3;
    public double a;
    public double b;
    public double c;

    public IsoscelesTriangle(Point p1, Point p2, Point p3) throws TriangleNotIsoscelesException {

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        double line1 = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
        double line2 = Math.sqrt((p1.x - p3.x) * (p1.x - p3.x) + (p1.y - p3.y) * (p1.y - p3.y));
        double line3 = Math.sqrt((p3.x - p2.x) * (p3.x - p2.x) + (p3.y - p2.y) * (p3.y - p2.y));

        if ((line1 > 0 && line2 > 0 && line3 > 0)
                && (line1 + line2 > line3 && line1 + line3 > line2 && line2 + line3 > line1)
                && (line1 == line2 || line1 == line3 || line2 == line3)) {
            a = line1;
            b = line2;
            c = line3;
        }
        else throw new TriangleNotIsoscelesException();
    }

    public double perimetr() {
        return a + b + c;
    }

    public double square() {
        return (float)Math.sqrt(perimetr() / 2 * (perimetr() / 2 - b) * (perimetr() / 2 - c) * (perimetr() / 2 - a));
    }

    public double[] triangleAngles() {
        double[] angles = new double[3];
        angles[0] = Math.acos((a * a + b * b - c * c) / (2 * a * b));
        angles[1] = Math.acos((b * b + c * c - a * a) / (2 * b * c));
        angles[2] = Math.acos((a * a + c * c - b * b) / (2 * a * c));
        return angles;
    }

    @Override
    public String toString() {
        return "IsoscelesTriangle {" +
                "p1=(" + p1.x + "," + p1.y +
                "), p2=(" + p2.x + "," + p2.y +
                "), p3=(" + p3.x + "," + p3.y +
                "), a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsoscelesTriangle that = (IsoscelesTriangle) o;
        return ((a == that.a) && (b == that.b) && (c == that.c) ||
                (a == that.a) && (b == that.c) && (c == that.b) ||
                (a == that.b) && (b == that.c) && (c == that.a) ||
                (a == that.b) && (b == that.a) && (c == that.c) ||
                (a == that.c) && (b == that.a) && (c == that.b) ||
                (a == that.c) && (b == that.b) && (c == that.a));
    }
}

class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class TriangleNotIsoscelesException extends Exception {
    public TriangleNotIsoscelesException() {
        super("Введенные значения не могут являться параметрами равнобедренного треугольника");
    }
}