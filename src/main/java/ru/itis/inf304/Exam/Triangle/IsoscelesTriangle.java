package ru.itis.inf304.Exam.Triangle;

public class IsoscelesTriangle {
    public double a;
    public double b;
    public double c;

    public IsoscelesTriangle(double a, double b, double c) throws TriangleNotIsoscelesException {
        if ((a > 0 && b > 0 && c > 0)
                && (a + b > c && a + c > b && b + c > a)
                && (a == b || a == c || b == c)) {
            this.b = b;
            this.a = a;
            this.c = c;
        }
        else throw new TriangleNotIsoscelesException();
    }

    public double perimetr() {
        return a + b + c;
    }

    public double square() {
        return Math.sqrt(perimetr() / 2 * (perimetr() / 2 - b) * (perimetr() / 2 - c) * (perimetr() / 2 - a));
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
        return "IsoscelesTriangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsoscelesTriangle that = (IsoscelesTriangle) o;
        return Double.compare(a, that.a) == 0 && Double.compare(b, that.b) == 0 && Double.compare(c, that.c) == 0;
    }
}
