package ru.itis.inf304.lab29;

public class LineFunction implements IFunction {
    @Override
    public double calculateForY(double radius, double radian) {
        return (radius * Math.sin(radian));
    }

    @Override
    public double calculateForX(double radius, double radian) {
        return (radius * Math.cos(radian));
    }
}